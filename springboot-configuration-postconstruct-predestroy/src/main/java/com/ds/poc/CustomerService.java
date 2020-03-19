package com.ds.poc;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@Component
public class CustomerService {
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("CustomerService .... @PostConstruct");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("CustomerService .... @PreDestroy");

    }
}
