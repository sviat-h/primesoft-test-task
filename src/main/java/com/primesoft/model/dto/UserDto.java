package com.primesoft.model.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto implements Serializable {
    private String login;
    private String password;
}
