package com.example.spring_security_demo.persistance.mapper;

import com.example.spring_security_demo.domain.dto.UserDto;
import com.example.spring_security_demo.persistance.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public abstract class UserDtoMapper {
    public abstract UserDto toUserDto(User user);
    public abstract List<UserDto> toUserDto(List<User> users);
}
