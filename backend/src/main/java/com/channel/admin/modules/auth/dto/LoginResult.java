package com.channel.admin.modules.auth.dto;

import lombok.Data;

import java.util.Set;

@Data
public class LoginResult {
  private String token;
  private UserInfoVO user;
}
