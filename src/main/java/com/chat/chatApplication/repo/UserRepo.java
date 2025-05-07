package com.chat.chatApplication.repo;

import com.chat.chatApplication.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
  void deleteUserById(Long id); 
  Optional<User> findUserById(Long id);
}
