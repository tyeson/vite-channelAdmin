package com.channel.admin.modules.auth.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserInfoVO {
  private Long id;
  private String username;
  private String nickname;
  private String avatar;
  private Set<String> roles;
  private Set<String> permissions;
}
