package com.channel.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.channel.admin.modules.**.mapper")
public class ChannelAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChannelAdminApplication.class, args);
  }
}
