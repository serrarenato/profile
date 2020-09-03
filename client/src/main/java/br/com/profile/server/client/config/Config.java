package br.com.profile.server.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

   @Profile("!prod")
   @Bean
   public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
   }
   @Profile("prod")
   @LoadBalanced
   @Bean
   public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
      return builder.build();
   }
}
