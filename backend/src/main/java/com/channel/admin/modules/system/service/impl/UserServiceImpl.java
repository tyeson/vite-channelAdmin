package com.channel.admin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.channel.admin.common.exception.BusinessException;
import com.channel.admin.modules.system.dto.UserQueryParam;
import com.channel.admin.modules.system.dto.UserVO;
import com.channel.admin.modules.system.entity.User;
import com.channel.admin.modules.system.mapper.UserMapper;
import com.channel.admin.modules.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Page<UserVO> page(UserQueryParam param) {
    Page<User> page = new Page<>(param.getPage(), param.getPageSize());
    LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
    wrapper.like(StringUtils.hasText(param.getUsername()), User::getUsername, param.getUsername())
        .like(StringUtils.hasText(param.getNickname()), User::getNickname, param.getNickname())
        .eq(param.getStatus() != null, User::getStatus, param.getStatus())
        .orderByDesc(User::getCreateTime);

    Page<User> result = userMapper.selectPage(page, wrapper);

    Page<UserVO> voPage = new Page<>(result.getCurrent(), result.getSize(), result.getTotal());
    voPage.setRecords(result.getRecords().stream().map(this::convertToVO).toList());
    return voPage;
  }

  @Override
  public UserVO getById(Long id) {
    User user = userMapper.selectById(id);
    if (user == null) {
      throw new BusinessException("用户不存在");
    }
    return convertToVO(user);
  }

  @Override
  public Long create(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setCreateTime(LocalDateTime.now());
    user.setUpdateTime(LocalDateTime.now());
    userMapper.insert(user);
    return user.getId();
  }

  @Override
  public void update(Long id, User user) {
    User existing = userMapper.selectById(id);
    if (existing == null) {
      throw new BusinessException("用户不存在");
    }
    user.setId(id);
    user.setUpdateTime(LocalDateTime.now());
    if (StringUtils.hasText(user.getPassword())) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
    } else {
      user.setPassword(existing.getPassword());
    }
    userMapper.updateById(user);
  }

  @Override
  public void delete(Long id) {
    userMapper.deleteById(id);
  }

  private UserVO convertToVO(User user) {
    UserVO vo = new UserVO();
    BeanUtils.copyProperties(user, vo);
    return vo;
  }
}
