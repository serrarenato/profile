package br.com.profile.server.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {

   private static final Logger log = LoggerFactory.getLogger(SpringSecurity.class);

   @Autowired
   private UserDetailsService userDetailsService;

   @Override protected void configure(HttpSecurity http) throws Exception {
      log.debug ("Entrou no configure");
      http.authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .httpBasic();
   }
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
      log.debug ("Entrou no configureGlobal");
    // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//      auth.inMemoryAuthentication()
//           .withUser("serra").password(encoder.encode("serra")).roles("USER")
//              .and()
//              .withUser("admin").password(encoder.encode("admin")).roles("ADMIN","USER");
      auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
   }
}

