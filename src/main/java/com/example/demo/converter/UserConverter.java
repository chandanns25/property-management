package com.example.demo.converter;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }

    public UserDTO convertTEntityTODTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO .setOwnerEmail(userEntity.getOwnerEmail());
        userDTO .setOwnerName(userEntity.getOwnerName());
        userDTO .setPhone(userEntity.getPhone());
        userDTO.setId(userEntity.getId());
        return userDTO ;
    }


}
