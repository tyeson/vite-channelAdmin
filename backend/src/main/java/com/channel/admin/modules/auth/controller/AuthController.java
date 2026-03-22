package com.channel.admin.modules.auth.controller;

import com.channel.admin.common.result.Result;
import com.channel.admin.common.utils.JwtUtil;
import com.channel.admin.common.utils.RedisUtil;
import com.channel.admin.modules.auth.dto.LoginParam;
import com.channel.admin.modules.auth.dto.LoginResult;
import com.channel.admin.modules.auth.dto.UserInfoVO;
import com.channel.admin.security.model.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Tag(name = "认证管理")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final RedisUtil redisUtil;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<LoginResult> login(@RequestBody LoginParam param) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                param.getUsername(), param.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(loginUser.getUserId(), loginUser.getUsername());

        redisUtil.set("user:" + loginUser.getUserId(), loginUser, 24, TimeUnit.HOURS);

        LoginResult result = new LoginResult();
        result.setToken(jwt);
        result.setUser(convertToUserInfo(loginUser));

        return Result.success(result);
    }

    @PostMapping("/logout")
    @Operation(summary = "用户登出")
    public Result<Void> logout(Authentication authentication) {
        if (authentication != null) {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            redisUtil.delete("user:" + loginUser.getUserId());
        }
        return Result.success();
    }

    @GetMapping("/user-info")
    @Operation(summary = "获取当前用户信息")
    public Result<UserInfoVO> getUserInfo(Authentication authentication) {
        if (authentication == null) {
            return Result.error(401, "未登录");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return Result.success(convertToUserInfo(loginUser));
    }

    private UserInfoVO convertToUserInfo(LoginUser loginUser) {
        UserInfoVO vo = new UserInfoVO();
        vo.setId(loginUser.getUserId());
        vo.setUsername(loginUser.getUsername());
        vo.setRoles(loginUser.getRoles());
        vo.setPermissions(loginUser.getPermissions());
        return vo;
    }
}
