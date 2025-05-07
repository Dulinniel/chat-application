package com.chat.chatApplication.exceptions;

public class UserNotFoundException extends RuntimeException
{
  public UserNotFoundException(String errorDetail)
  {
    super(errorDetail);
  }
}
