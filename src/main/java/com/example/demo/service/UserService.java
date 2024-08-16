package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface UserService {
     UserDTO register(UserDTO userDTO);
     UserDTO login(String email,String password);

}
