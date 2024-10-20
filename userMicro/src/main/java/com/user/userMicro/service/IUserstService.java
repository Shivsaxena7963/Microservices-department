package com.user.userMicro.service;


import com.user.userMicro.dto.ResponseDto;
import com.user.userMicro.dto.UsersDto;

import java.util.List;

public interface IUserstService {

    UsersDto createUser(UsersDto userDto);

    UsersDto fetchUser(String phone);

    List<UsersDto> fetchAllUsers();

    ResponseDto updateUser(String phone);


}
