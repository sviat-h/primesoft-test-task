package com.primesoft.service.mapper;

import com.primesoft.lib.annotation.Service;
import com.primesoft.model.User;
import com.primesoft.model.dto.UserDto;

@Service
public class UserDtoMapperImpl implements UserDtoMapper {
    @Override
    public UserDto mapToDto(User user) {
        return UserDto.builder().login(user.getLogin()).password(user.getPassword()).build();
    }

    @Override
    public User mapToModel(UserDto userDto) {
        return User.builder().login(userDto.getLogin()).password(userDto.getPassword()).build();
    }
}
