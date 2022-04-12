package com.eberjoe.motorwind.controllers;

import com.eberjoe.motorwind.models.UserModel;
import java.util.List;

public interface UserController {

  List<UserModel> getUsers();

  UserModel createUser(UserModel user);

}
