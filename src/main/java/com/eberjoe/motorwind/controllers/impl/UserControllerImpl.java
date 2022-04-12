package com.eberjoe.motorwind.controllers.impl;

import com.eberjoe.motorwind.controllers.UserController;
import com.eberjoe.motorwind.models.UserModel;
import com.eberjoe.motorwind.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;


  @Override
  @GetMapping("/all")
  public List<UserModel> getUsers() {
    return userService.findAll();
  }

  @Override
  @PostMapping("/register")
  public UserModel createUser(@RequestBody UserModel user) {
    return userService.save(user);
  }

}
