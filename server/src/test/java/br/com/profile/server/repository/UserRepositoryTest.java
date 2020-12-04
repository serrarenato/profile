package br.com.profile.server.repository;

import java.util.Optional;

import br.com.profile.server.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

      @Autowired
      private UserRepository userRepository;

      @Test
      public void whenFindingUserById_thenCorrect() {
         userRepository.save(new User("serra", "teste2", "teste3"));

         Optional<User> user = userRepository.findById(1L);
         Assert.assertTrue(user.isPresent());
         Assert.assertTrue(user.get().getUsername().equals("serra"));
      }

}


