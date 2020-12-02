package br.com.profile.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {

   @Override protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .httpBasic();
   }
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
      PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      auth.inMemoryAuthentication()
           .withUser("serra").password(encoder.encode("serra")).roles("USER")
              .and()
              .withUser("admin").password(encoder.encode("admin")).roles("ADMIN","USER");
   }
}
