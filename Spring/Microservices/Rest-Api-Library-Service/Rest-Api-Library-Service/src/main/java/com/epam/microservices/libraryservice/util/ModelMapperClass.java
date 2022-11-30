package com.epam.microservices.libraryservice.util;

import org.modelmapper.ModelMapper;

public class ModelMapperClass {
    private static ModelMapper modelMapper;
    public ModelMapper getMapper(){
        if (modelMapper == null)
            modelMapper = new ModelMapper();
        return modelMapper;
    }
}
