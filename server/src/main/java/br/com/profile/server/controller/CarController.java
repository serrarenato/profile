package br.com.profile.server.controller;

import br.com.profile.server.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
   private static final Logger log = LoggerFactory.getLogger(CarController.class);
   @Autowired
   Car car;

   @RequestMapping(method = RequestMethod.GET)
   public @ResponseBody Car getCarName() {
      log.info("Getting car name" + car.toString());
      return car;

   }
}
