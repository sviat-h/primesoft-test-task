package com.primesoft.socket;

import com.primesoft.exception.DataProcessingException;
import com.primesoft.lib.Injector;
import com.primesoft.model.dto.UserDto;
import com.primesoft.model.dto.VehicleDto;
import com.primesoft.service.VehicleService;
import com.primesoft.service.mapper.VehicleDtoMapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class ServerSocket {
    public static final int PORT = 4999;

    private static final Injector injector = Injector.getInstance("com.primesoft");
    private static final VehicleService vehicleService =
            (VehicleService) injector.getInstance(VehicleService.class);
    private static final VehicleDtoMapper vehicleDtoMapper =
            (VehicleDtoMapper) injector.getInstance(VehicleDtoMapper.class);

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = openConnection();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            UserDto user = getRequest(socket);
            sendResponse(objectOutputStream, user);
            closeConnection(socket);
        } catch (IOException e) {
            throw new DataProcessingException("An exception occurred while writing or reading a "
                    + "socket.", e);
        } catch (ClassNotFoundException e) {
            throw new DataProcessingException("There is no such class.", e);
        }
    }

    private static void closeConnection(Socket socket) throws IOException {
        socket.close();
    }

    private static void sendResponse(ObjectOutputStream objectOutputStream, UserDto user)
            throws IOException {
        List<VehicleDto> response = vehicleService.getAllByUserLogin(user.getLogin()).stream()
                .map(vehicleDtoMapper::mapToDto)
                .collect(Collectors.toList());
        objectOutputStream.writeObject(response);
    }

    private static UserDto getRequest(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        return (UserDto) objectInputStream.readObject();
    }

    private static Socket openConnection() throws IOException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected. . .");
        return socket;
    }
}
