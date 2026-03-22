package com.channel.admin.common.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
  ENABLED(1, "启用"),
  DISABLED(0, "禁用");

  private final int code;
  private final String desc;

  UserStatus(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
