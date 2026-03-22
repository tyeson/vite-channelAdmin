package com.channel.admin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_permission")
public class Permission {
  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private String code;
  private Integer type;
  private Long parentId;
  private String path;
  private String component;
  private String icon;
  private Integer sort;
  private Integer status;
  @TableLogic
  private Integer deleted;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
