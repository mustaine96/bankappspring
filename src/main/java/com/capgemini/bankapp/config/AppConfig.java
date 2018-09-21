package com.capgemini.bankapp.config;

//import java.sql.DriverManager;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.capgemini.bankapp"})
public class AppConfig {
//DriverManagerDataSource
}
