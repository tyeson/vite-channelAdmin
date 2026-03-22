package com.channel.admin.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.channel.admin.modules.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

  @Select("SELECT r.code FROM sys_role r " +
      "INNER JOIN sys_user_role ur ON r.id = ur.role_id " +
      "WHERE ur.user_id = #{userId} AND r.status = 1 AND r.deleted = 0")
  Set<String> selectRoleCodesByUserId(@Param("userId") Long userId);
}
