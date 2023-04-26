package br.com.diegoandcontroll.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diegoandcontroll.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  Optional<User> findByEmail(String email);
}
