package br.com.profile.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("br.com.profile")
@PropertySource(value = "classpath:application.properties")
public class SpringProfilesConfig {

}