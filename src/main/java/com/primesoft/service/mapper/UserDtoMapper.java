package com.primesoft.service.mapper;

import com.primesoft.model.User;
import com.primesoft.model.dto.UserDto;

public interface UserDtoMapper {
    UserDto mapToDto(User user);

    User mapToModel(UserDto userDto);
}
