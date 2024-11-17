package com.example.demo.di;

import org.example.Country;
import org.example.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//改到1.1版自動引入
//@Configuration
//public class CommonConfig {
//
//    @ConditionalOnProperty(prefix = "country", name = {"name", "system"})
//    @Bean
//    public Country getCountry(@Value("${country.name}") String name, @Value("${country.system}") String system) {
//        Country country = new Country();
//        country.setName(name);
//        country.setSystem(system);
//        return country;
//    }
//
//    //@ConditionalOnMissingBean(Country.class)
//    //@ConditionalOnClass(name = "org.example.Country")
//    @Bean
//    public Province getProvince() {
//        return new Province();
//    }
//
//}
