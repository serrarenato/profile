package br.com.profile.server.config;

import br.com.profile.server.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigResource {

   @Profile("!dev")
   @Bean(name="car")
   public Car getCar(){
      return new Car("fusca");
   }

   @Profile("dev")
   @Bean(name="car")
   public Car getCarDev(){
      return new Car("gol");
   }
}
