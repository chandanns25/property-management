package com.example.demo.repository;

import com.example.demo.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
    
}
