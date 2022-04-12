package com.eberjoe.motorwind.services.impl;

import com.eberjoe.motorwind.models.UserModel;
import com.eberjoe.motorwind.repositories.UserRepository;
import com.eberjoe.motorwind.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public List<UserModel> findAll() {
    log.info("Retrieving all system users");
    return userRepository.findAll();
  }

  @Override
  public UserModel save(UserModel user) {
    log.info("Saving new user to the database");
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole("ROLE_USER");
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("Trying to log {} in", username);
    try {
      UserModel user = userRepository.findByEmail(username);

      assert user != null;
      var authorities = List.of(
          new SimpleGrantedAuthority(user.getRole()));
      log.info("User {} logged in", user.getEmail());

      return new User(user.getEmail(), user.getPassword(), authorities);
    } catch (Exception exception) {
      log.error("A problem occurred while trying to log in. Error: {}", exception.getMessage());
      throw new UsernameNotFoundException(String.format("User could not log in: %s", username));
    }
  }

}
