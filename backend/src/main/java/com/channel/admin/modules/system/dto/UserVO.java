package com.channel.admin.modules.system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
  private Long id;
  private String username;
  private String nickname;
  private String avatar;
  private String email;
  private String phone;
  private Integer status;
  private LocalDateTime createTime;
  private LocalDateTime lastLoginTime;
}
