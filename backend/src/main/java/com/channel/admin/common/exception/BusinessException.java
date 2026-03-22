package com.channel.admin.common.exception;

import com.channel.admin.common.enums.ResultCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private final int code;
  private final String message;

  public BusinessException(String message) {
    super(message);
    this.code = ResultCode.FAILED.getCode();
    this.message = message;
  }

  public BusinessException(ResultCode resultCode) {
    super(resultCode.getMessage());
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }
}
