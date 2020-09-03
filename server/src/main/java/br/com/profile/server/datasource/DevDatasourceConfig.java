package br.com.profile.server.datasource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {

   @Override public void setup() {
      System.out.println("Setting up datasource for DEV environment. ");
   }

   @Override
   public String getInstance() {
      return "DEV";
   }
}
