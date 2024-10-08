package com.example.demo.controller;

import com.example.demo.dto.PropertyDTO;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("api/v1")
public class PropertyController {
    @Value("${pms.dummy:}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO =  propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        System.out.println(dummy);
        List<PropertyDTO> propertylist =  propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertylist,HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO>  updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
       propertyDTO =  propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;
    }
    @PatchMapping("/properties/updateDescription/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO =  propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;

    }
    @PatchMapping("/properties/updatePrice/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO =  propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;

    }
    @DeleteMapping("properties/{propertyId}")
    public  ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
