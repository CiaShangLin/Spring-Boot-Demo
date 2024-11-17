package com.example.demo;

import com.example.demo.di.CommonImportSelector;
import org.example.Country;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@MapperScan("com.example.demo.mapper")
//@Import(CommonImportSelector.class)
public class DemoApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Country country = context.getBean(Country.class);
		System.out.println(country.toString());
	}


}
