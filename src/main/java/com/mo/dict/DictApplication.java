package com.mo.dict;

import com.mo.dict.utils.UserContextFilter;
import com.mo.dict.utils.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class DictApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class, args);
    }

    @Bean
    public Filter userContextFilter() {
        return new UserContextFilter();
    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        List interceptors = template.getInterceptors();
        // UserContextInterceptor를 생성된 RestTemplate 인스턴스에 추가
        if (interceptors == null) {
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        } else {
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }
        return template;
    }

}
