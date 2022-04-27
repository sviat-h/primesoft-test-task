package com.primesoft.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String nick;
    private String login;
    private String password;
    private LocalDateTime insertTime;
    private List<Vehicle> vehicles;
}
