package com.ds.poc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@Component
public class PrintService {
private String message;

@PostConstruct
    public  void init()
{
    System.out.println("PrintService .. @PostConstruct");
}

@PreDestroy
    public void cleanUp(){
    System.out.println("PrintService ....@PreDestroy");
}

}
