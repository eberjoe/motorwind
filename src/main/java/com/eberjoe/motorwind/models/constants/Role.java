package com.eberjoe.motorwind.models.constants;

public enum Role {
  TECHNICIAN,
  ADMIN,
  SUPER_ADMIN;

  @Override
  public String toString() {
    return this.name();
  }

}
