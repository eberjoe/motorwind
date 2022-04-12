package com.eberjoe.motorwind.services;

import com.eberjoe.motorwind.models.UserModel;
import java.util.List;

public interface UserService {

  List<UserModel> findAll();

  UserModel save(UserModel user);

}
