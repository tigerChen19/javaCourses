package com.cta.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfiguration.class)
@EnableConfigurationProperties(WebProperties.class)
public class WebAutoConfiguration {
    @Autowired WebConfiguration webConfiguration;
    @Autowired WebProperties properties;

    @Bean
    public WebInfo createInfo(){
        return new WebInfo(webConfiguration.name+"-"+properties.getA());
    }
}
