package com.user.userMicro.mapper;


import com.user.userMicro.dto.UsersDto;
import com.user.userMicro.entity.Users;

public class UsersMapper {

    public static Users dtoToUsers(UsersDto usersDto)
    {
       Users users = new Users();
       users.setUserId(usersDto.getUserId());
       users.setDate(usersDto.getDate());
       users.setAbout(usersDto.getAbout());
       users.setEmail(usersDto.getEmail());
       users.setActive(usersDto.isActive());
       users.setName(usersDto.getName());
       users.setGender(usersDto.getGender());
       users.setPassword(usersDto.getPassword());
       users.setPhone(usersDto.getPhone());
       users.setAddress(usersDto.getAddress());

       return users;
    }

    public static UsersDto usersToDto(Users users)
    {
        UsersDto usersDto = new UsersDto();
        usersDto.setDate(users.getDate());
        usersDto.setAbout(users.getAbout());
        usersDto.setEmail(users.getEmail());
        usersDto.setActive(users.isActive());
        usersDto.setName(users.getName());
        usersDto.setGender(users.getGender());
        usersDto.setPassword(users.getPassword());
        usersDto.setPhone(users.getPhone());
        usersDto.setAddress(users.getAddress());

        return usersDto;

    }
}
