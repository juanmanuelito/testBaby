package com.example.crud.config;

import com.example.crud.domain.entity.TestEntity;
import com.example.crud.dto.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.typeMap(Test.class, TestEntity.class);
        return modelMapper;
    }
}
