package com.channel.admin.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.channel.admin.modules.system.dto.UserQueryParam;
import com.channel.admin.modules.system.dto.UserVO;
import com.channel.admin.modules.system.entity.User;

public interface UserService {
  Page<UserVO> page(UserQueryParam param);

  UserVO getById(Long id);

  Long create(User user);

  void update(Long id, User user);

  void delete(Long id);
}
