package com.example.demo.controller;

import com.example.demo.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")//class level mapping of an url to a controller class
public class CalculatorController {

    @GetMapping("/add/{num3}")//method level mapping of an url with a controller function
    //http://localhost:8080/api/v1/calculator/add?num1=1.5&num2=1.5
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2,
                      @PathVariable("num3") Double num3){
        System.out.println(num1 + num2 + num3);

        return num1 + num2 + num3;



    }
    @GetMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2) {
        Double result = null;
        if (num1 > num2) {
            result = num1 - num2;

        }
        else {
            result = num2 - num1;
        }
        return result;

    }

    @PostMapping("/mul")
    public  ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
