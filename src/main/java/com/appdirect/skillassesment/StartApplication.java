package com.appdirect.skillassesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by RahulGupta on 2017-12-02.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
//@EnableScheduling
public class StartApplication {

    public static void main(String[] args){
        SpringApplication.run(StartApplication.class, args);
    }
}
