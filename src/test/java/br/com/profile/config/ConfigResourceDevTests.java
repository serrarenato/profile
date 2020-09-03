package br.com.profile.config;

import br.com.profile.Entity.Car;
import br.com.profile.datasource.DatasourceConfig;
import br.com.profile.datasource.DevDatasourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes = { SpringProfilesConfig.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class ConfigResourceDevTests {

   @Autowired
   Car car;

   @Test
   public void testSpringProfiles() {
      Assert.assertEquals("gol", car.getName());
   }
}
