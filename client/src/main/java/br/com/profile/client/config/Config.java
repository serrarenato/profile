package br.com.profile.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

   @Value("${server.user}")
   private String user;
   @Value("${server.password}")
   private String password;

   @Profile("!prod")
   @Bean
   public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return getRestTemplateDefault(builder);
   }

   @Profile("prod")
   @LoadBalanced
   @Bean
   public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
      return getRestTemplateDefault(builder);
   }

   private RestTemplate getRestTemplateDefault(RestTemplateBuilder builder){
      return builder.basicAuthentication(user, password).build();
   }
}
