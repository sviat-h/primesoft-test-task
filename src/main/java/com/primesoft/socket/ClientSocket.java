package com.primesoft.socket;

import com.primesoft.exception.DataProcessingException;
import com.primesoft.lib.Injector;
import com.primesoft.model.User;
import com.primesoft.model.dto.VehicleDto;
import com.primesoft.service.AuthenticationService;
import com.primesoft.service.mapper.UserDtoMapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocket {
    public static final String LOGIN = "userLogin";
    public static final String PASSWORD = "user1234";
    public static final String HOST = "localhost";
    public static final int PORT = 4999;

    private static final Injector injector = Injector.getInstance("com.primesoft");
    private static final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final UserDtoMapper USER_DTO_MAPPER_IMPL =
            (UserDtoMapper) injector.getInstance(UserDtoMapper.class);
    private static Socket socket;

    public static void main(String[] args) {
        try {
            openConnection();
            sendRequest();
            System.out.println(getResponse());
            closeConnection();
        } catch (IOException e) {
            throw new DataProcessingException("An exception occurred while writing or reading a "
                    + "socket.", e);
        } catch (ClassNotFoundException e) {
            throw new DataProcessingException("There is no such class.", e);
        }
    }

    private static void openConnection() throws IOException {
        socket = new Socket(HOST, PORT);
    }

    private static void sendRequest() throws IOException {
        User authenticatedUser = authenticationService.login(LOGIN, PASSWORD);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(USER_DTO_MAPPER_IMPL.mapToDto(authenticatedUser));
        objectOutputStream.flush();
    }

    private static List<VehicleDto> getResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        return (List<VehicleDto>) objectInputStream.readObject();
    }

    private static void closeConnection() throws IOException {
        socket.close();
    }
}
