package com.channel.admin.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.channel.admin.common.result.PageResult;
import com.channel.admin.common.result.Result;
import com.channel.admin.modules.system.dto.UserQueryParam;
import com.channel.admin.modules.system.dto.UserVO;
import com.channel.admin.modules.system.entity.User;
import com.channel.admin.modules.system.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/page")
  @Operation(summary = "分页查询用户")
  public Result<PageResult<UserVO>> page(UserQueryParam param) {
    Page<UserVO> page = userService.page(param);
    return Result
        .success(PageResult.of(page.getRecords(), page.getTotal(), (int) page.getCurrent(), (int) page.getSize()));
  }

  @GetMapping("/{id}")
  @Operation(summary = "获取用户详情")
  public Result<UserVO> getById(@PathVariable Long id) {
    return Result.success(userService.getById(id));
  }

  @PostMapping
  @Operation(summary = "创建用户")
  public Result<Long> create(@RequestBody User user) {
    return Result.success(userService.create(user));
  }

  @PutMapping("/{id}")
  @Operation(summary = "更新用户")
  public Result<Void> update(@PathVariable Long id, @RequestBody User user) {
    userService.update(id, user);
    return Result.success();
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "删除用户")
  public Result<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return Result.success();
  }
}
