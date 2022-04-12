package com.eberjoe.motorwind.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_model")
@Getter
@Setter
@NoArgsConstructor
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotBlank
  @Column(name = "full_name")
  private String fullName;

  @NotBlank
  @Email
  @Column(unique = true)
  private String email;

  @NotBlank
  private String password;

  private String role;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserModel userModel = (UserModel) o;
    return getId().equals(userModel.getId()) && getFullName().equals(userModel.getFullName()) && getEmail().equals(
        userModel.getEmail()) && getPassword().equals(userModel.getPassword()) && Objects.equals(getRole(),
        userModel.getRole());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFullName(), getEmail(), getPassword(), getRole());
  }

}