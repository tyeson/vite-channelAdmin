package com.channel.admin.modules.auth.dto;

import lombok.Data;

@Data
public class LoginParam {
  private String username;
  private String password;
  private Boolean remember;
}
