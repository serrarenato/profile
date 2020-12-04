package br.com.profile.server.controller;

import br.com.profile.server.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
   private static final Logger log = LoggerFactory.getLogger(CarController.class);
   @Autowired
   Car car;

   @RequestMapping(method = RequestMethod.GET)
   @PreAuthorize("hasRole('ADMIN')")
   public @ResponseBody Car getCarName(@AuthenticationPrincipal UserDetails userDetails) {
      log.debug("Getting car name" + car.toString() + " User: " + userDetails);
      return car;

   }
}
