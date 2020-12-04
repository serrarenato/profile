package br.com.profile.server.config.security;


import java.util.Optional;

import javax.transaction.Transactional;

import br.com.profile.server.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.profile.server.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   UserRepository repository;

   private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

   @Override public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
      log.debug("Busca usuario: {} ",login);
      Optional<User> user = repository.findByLogin(login);
      if (user.isPresent())
              return user.get();
      log.debug("Usuario {} nao encontrado ",login);
      throw new UsernameNotFoundException("User not found:" + login);
   }
}
