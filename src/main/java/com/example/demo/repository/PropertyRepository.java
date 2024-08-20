package com.example.demo.repository;

import com.example.demo.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PropertyRepository extends CrudRepository <PropertyEntity,Long> {

    List<PropertyEntity> findAllByUserEntityId(Long userId);



}
