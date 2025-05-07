package com.chat.chatApplication;

import com.chat.chatApplication.service.UserService;
import com.chat.chatApplication.model.User;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/user")
public class UserResource
{
  private final UserService userService;

  public UserResource(UserService userService)
  {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUser()
  {
    List<User> users = userService.findAllUser();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> addUser(@RequestBody User user)
  {
    User newUser = userService.addUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<User> updateUser(@RequestBody User user)
  {
    User updatedUser = userService.updateUser(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
  {
    User user = userService.findUser(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
  {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
}
