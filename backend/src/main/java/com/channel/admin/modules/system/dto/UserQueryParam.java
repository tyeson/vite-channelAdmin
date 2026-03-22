package com.channel.admin.modules.system.dto;

import lombok.Data;

@Data
public class UserQueryParam {
  private String username;
  private String nickname;
  private Integer status;
  private Integer page = 1;
  private Integer pageSize = 10;
}
