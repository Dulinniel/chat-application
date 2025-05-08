package com.chat.chatApplication.service;

import com.chat.chatApplication.repo.UserRepo;
import com.chat.chatApplication.model.User;
import com.chat.chatApplication.exceptions.UserNotFoundException;

import java.util.List;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
  private final UserRepo userRepo;

  @Autowired
  public UserService(UserRepo userRepo)
  {
    this.userRepo = userRepo;
  }

  @Transactional
  public User addUser(User user)
  {
    return userRepo.save(user);
  }

  @Transactional
  public List<User> findAllUser()
  {
    return userRepo.findAll();
  }

  @Transactional
  public User findUser(Long id)
  {
    return userRepo.findUserById(id)
      .orElseThrow(() -> new UserNotFoundException("User id : " + id.toString() + " is not found"));
  }

  @Transactional
  @DynamicUpdate
  public User updateUser(User user)
  { 
    return userRepo.save(user);
  }

  @Transactional
  public void deleteUser(Long id)
  {
    userRepo.deleteUserById(id);
  }

}
