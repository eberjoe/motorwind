package com.eberjoe.motorwind.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = BAD_REQUEST)
public class ErrorOnSaveException extends RuntimeException {

  public ErrorOnSaveException(String message, Throwable cause) {
    super(message, cause);
  }

}
