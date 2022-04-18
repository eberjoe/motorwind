package com.eberjoe.motorwind.models;

import static com.eberjoe.motorwind.models.constants.Role.TECHNICIAN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_model")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

  @Builder.Default
  private String role = TECHNICIAN.toString();

  @Builder.Default
  private Boolean accountNonExpired = true;

  @Builder.Default
  private Boolean accountNonLocked = true;

  @Builder.Default
  private Boolean credentialsNonExpired = true;

  @Builder.Default
  private Boolean enabled = true;

}