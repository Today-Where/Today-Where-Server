package com.example.todaywhereserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationPropertiesScan
@SpringBootApplication
public class TodayWhereServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodayWhereServerApplication.class, args);
	}

}
