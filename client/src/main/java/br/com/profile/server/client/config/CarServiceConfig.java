package br.com.profile.server.client.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

@Configuration
public class CarServiceConfig {
   @Bean
   @Primary
   ServiceInstanceListSupplier serviceInstanceListSupplier() {

      return new DemoServiceInstanceListSuppler("carserver");
   }

}

class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

   private final String serviceId;

   @Value("${url.car.service.list:null}")
   List<String> serviceURL;

   DemoServiceInstanceListSuppler(String serviceId) {
      this.serviceId = serviceId;
   }

   @Override
   public String getServiceId() {
      return serviceId;
   }

   @Override
   public Flux<List<ServiceInstance>> get() {
      return Flux.just(getServicesURL());
   }

   private List<ServiceInstance> getServicesURL() {
      List<ServiceInstance> list = new ArrayList<>();
      int x = 1;
      for (String url : serviceURL) {
         String[] string = url.split(":");
         list.add(new DefaultServiceInstance(serviceId + x, serviceId, string[0], new Integer(string[1]), false));
         x++;
      }
      return list;
   }
}
