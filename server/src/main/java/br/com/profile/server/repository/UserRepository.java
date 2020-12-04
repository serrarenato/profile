package br.com.profile.server.repository;

import java.util.Optional;

import br.com.profile.server.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   Optional<User> findByLogin(String login);
}
