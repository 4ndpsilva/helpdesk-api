package com.helpdeskapi.config;

import com.helpdeskapi.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public void initDB(){
        dbService.initDB();
    }
}