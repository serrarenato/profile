package br.com.profile.server;

import br.com.profile.server.config.SpringProfilesConfig;
import br.com.profile.server.datasource.DatasourceConfig;
import br.com.profile.server.datasource.ProdDatasourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes = { SpringProfilesConfig.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("prod")
public class ProfileProdTests {

   @Autowired
   DatasourceConfig datasourceConfig;

   @Autowired
   Environment environment;

   @Test
   public void testSpringProfiles() {
      for (final String profileName : environment.getActiveProfiles()) {
         System.out.println("Currently active profile - " + profileName);
      }
      Assert.assertEquals("prod", environment.getActiveProfiles()[0]);
      Assert.assertTrue(datasourceConfig instanceof ProdDatasourceConfig);
      Assert.assertEquals(datasourceConfig.getInstance(), "PROD");
   }
}
