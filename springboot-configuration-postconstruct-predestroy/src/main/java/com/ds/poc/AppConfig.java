package com.ds.poc;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Configuration
public class AppConfig {

    @PostConstruct
    public void init()
    {
        System.out.println("AppConfig......@PostConstruct");
    }

    @PreDestroy
    public void celanUp(){
        System.out.println("AppConfig ...... @PreDestroy ");
    }

}
