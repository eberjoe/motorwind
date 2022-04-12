package com.eberjoe.motorwind.repositories;

import com.eberjoe.motorwind.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  UserModel findByEmail(String email);
}