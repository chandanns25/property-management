package com.example.demo.controller;

public class CalculatorMain {
    public static void main(String[] args){
       CalculatorController c = new CalculatorController();
        Double result = c.add(1.5,1.5,9.5);
        System.out.println(result);


    }
}
