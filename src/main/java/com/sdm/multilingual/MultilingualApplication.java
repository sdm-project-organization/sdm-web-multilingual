package com.sdm.multilingual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
/*@EnableDiscoveryClient*/
public class MultilingualApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MultilingualApplication.class, args);
    }

}
