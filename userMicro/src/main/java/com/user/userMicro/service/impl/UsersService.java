package com.user.userMicro.service.impl;



import com.user.userMicro.dto.ResponseDto;
import com.user.userMicro.dto.UsersDto;
import com.user.userMicro.entity.Users;
import com.user.userMicro.exception.ResourceAlreadyExistException;
import com.user.userMicro.exception.ResourceNotFoundException;
import com.user.userMicro.mapper.UsersMapper;
import com.user.userMicro.repo.UsersRepo;
import com.user.userMicro.service.IUserstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUserstService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UsersDto createUser(UsersDto userDto) {
        Optional<Users> optionalUsers = usersRepo.findByPhone(userDto.getPhone());

        if(optionalUsers.isPresent())
        {
            throw new ResourceAlreadyExistException("User already exist with Phone no "+userDto.getPhone());
        }

        Users savedUser = usersRepo.save(UsersMapper.dtoToUsers(userDto));
        return UsersMapper.usersToDto(savedUser);

    }

    @Override
    public UsersDto fetchUser(String phone) {
        Users users = usersRepo.findByPhone(phone).orElseThrow(

                ()-> new ResourceNotFoundException("User not found with mobile no "+phone)

        );

        return UsersMapper.usersToDto(users);
    }

    @Override
    public List<UsersDto> fetchAllUsers() {

        List<Users> usersList = usersRepo.findAll();
        List<UsersDto> usersDtos = new ArrayList<>();
        usersList.forEach(

                (user)-> usersDtos.add(UsersMapper.usersToDto(user))
        );
        return usersDtos;

    }

    @Override
    public com.user.userMicro.dto.ResponseDto updateUser(String phone) {
        return null;
    }
}
