package com.channel.admin.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.channel.admin.modules.system.entity.User;
import com.channel.admin.modules.system.mapper.PermissionMapper;
import com.channel.admin.modules.system.mapper.RoleMapper;
import com.channel.admin.modules.system.mapper.UserMapper;
import com.channel.admin.security.model.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserMapper userMapper;
  private final RoleMapper roleMapper;
  private final PermissionMapper permissionMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
        .eq(User::getUsername, username));

    if (user == null) {
      throw new UsernameNotFoundException("用户不存在");
    }

    Set<String> roles = roleMapper.selectRoleCodesByUserId(user.getId());
    Set<String> permissions = permissionMapper.selectPermissionCodesByUserId(user.getId());

    LoginUser loginUser = new LoginUser();
    loginUser.setUserId(user.getId());
    loginUser.setUsername(user.getUsername());
    loginUser.setPassword(user.getPassword());
    loginUser.setStatus(user.getStatus());
    loginUser.setRoles(roles != null ? roles : new HashSet<>());
    loginUser.setPermissions(permissions != null ? permissions : new HashSet<>());

    return loginUser;
  }
}
