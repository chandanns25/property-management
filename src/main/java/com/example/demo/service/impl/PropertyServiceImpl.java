package com.example.demo.service.impl;

import com.example.demo.converter.PropertyConverter;
import com.example.demo.dto.PropertyDTO;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorModel;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private UserRepository userRepository;




    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {



        Optional<UserEntity> opUe = userRepository.findById(propertyDTO.getUserid());
        if(opUe.isPresent()) {

            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

            pe.setUserEntity(opUe.get());

            pe = propertyRepository.save(pe);

            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        }else{

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER ID DOESNOT EXISTS");
            errorModel.setMessage("USER ID DOESNOT EXIST PLEASE PROVIDE IT");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }


        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
       List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
       List<PropertyDTO> propList = new ArrayList<>();

       for(PropertyEntity pe : listOfProps ){
          PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
          propList.add(dto);
       }
        return propList;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userid) {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAllByUserEntityId(userid);
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe : listOfProps ){
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            propList.add(dto);
        }
        return propList;

    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> opEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(opEn.isPresent()){
            PropertyEntity pe = opEn.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);

            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> opEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(opEn.isPresent()){
            PropertyEntity pe = opEn.get();

            pe.setDescription(propertyDTO.getDescription());

            dto = propertyConverter.convertEntitytoDTO(pe);

            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(opEn.isPresent()){
            PropertyEntity pe = opEn.get();

            pe.setPrice(propertyDTO.getPrice());

            dto = propertyConverter.convertEntitytoDTO(pe);

            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
