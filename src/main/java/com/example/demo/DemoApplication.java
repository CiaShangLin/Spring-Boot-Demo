package com.example.demo;

import org.example.Country;
import org.example.Province;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan("com.example.demo.mapper")
//@Import(CommonImportSelector.class)
public class DemoApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Country country = context.getBean(Country.class);
		Province province = context.getBean(Province.class);
		System.out.println("country:"+country.toString());
		System.out.println("province:"+province.toString());
	}


}
