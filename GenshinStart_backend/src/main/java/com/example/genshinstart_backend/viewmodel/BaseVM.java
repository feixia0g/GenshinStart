package com.example.genshinstart_backend.viewmodel;

import org.modelmapper.ModelMapper;
import com.example.genshinstart_backend.utility.ModelMapperSingle;

/**
 * @version 1.0.0
 * @description: The type Base vm.
 * @author feixia0g
 * @date 2024/7/10 19:30
 */
public class BaseVM {
    /**
     * The constant modelMapper.
     */
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


    /**
     * Gets model mapper.
     *
     * @return the model mapper
     */
    public static ModelMapper getModelMapper() {
        return modelMapper;
    }

    /**
     * Sets model mapper.
     *
     * @param modelMapper the model mapper
     */
    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}

