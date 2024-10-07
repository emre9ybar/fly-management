package com.flyroute.fly.config;

import com.flyroute.fly.message.UserMessage;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public UserMessage userMessage(){
        return new UserMessage();
    }
}
