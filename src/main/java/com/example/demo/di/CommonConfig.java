package com.example.demo.di;

import org.example.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public Country getCountry(){
        return new Country();
    }

}
