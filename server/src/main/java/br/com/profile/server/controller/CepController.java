package br.com.profile.server.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.profile.server.entity.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

   @Autowired
   private Car car;

   @Value("${application.cep.base-url:notfound}")
   private String cepEndpoint;

   @Autowired
   private Environment environment;

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<Map> getCepEndpoint() {
      Map<String, String> map = Collections.singletonMap("URL", cepEndpoint);
      return ResponseEntity.ok(map);
   }

   @RequestMapping(method = RequestMethod.GET, value = "/profile")
   public ResponseEntity<Map> getActiveProfiles() {
      Map map = new HashMap<String, String>();

      for (String profileName : environment.getActiveProfiles()) {
         map.put("Currently active profile - ", profileName);
      }

      return ResponseEntity.ok(map);
   }
}
