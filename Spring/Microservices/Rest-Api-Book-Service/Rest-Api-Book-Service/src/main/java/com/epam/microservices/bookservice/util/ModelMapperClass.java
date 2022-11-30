package com.epam.microservices.bookservice.util;

import org.modelmapper.ModelMapper;

public class ModelMapperClass {
    private static ModelMapper modelMapper;
    private ModelMapperClass(){

    }
    public static ModelMapper getMapper(){
        if (modelMapper == null)
            modelMapper= new ModelMapper();
        return modelMapper;
    }
}
