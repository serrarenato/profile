package br.com.profile.server.controller;

import br.com.profile.server.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

   @Autowired
   Car car;

   @RequestMapping(method = RequestMethod.GET)
   public @ResponseBody Car getCarName() {
      return car;

   }
}
