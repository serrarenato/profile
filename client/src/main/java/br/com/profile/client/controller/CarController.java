package br.com.profile.client.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

   @Autowired
   RestTemplate restTemplate;

   @Value("${url.car.service:notfound}")
   String url;

   private static final Logger log = LoggerFactory.getLogger(CarController.class);

   @RequestMapping(method = RequestMethod.GET)
   public @ResponseBody Map<String, String> getCarName() {
      Map<String, String> result;
      log.info("Call getCarName", url);
      result = restTemplate.getForObject(url, Map.class);
      log.info(result.toString());
      return result;
   }
}
