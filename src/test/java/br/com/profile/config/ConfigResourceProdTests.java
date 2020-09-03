package br.com.profile.config;

import br.com.profile.Entity.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes = { ConfigResource.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("prod")
public class ConfigResourceProdTests {

   @Autowired
   Car car;

   @Test
   public void testSpringProfiles() {
      Assert.assertEquals("fusca", car.getName());
   }
}
