# 后端开发指南

## 目录结构

```
backend/
├── src/main/java/com/channel/admin/
│   ├── config/           # 配置类
│   ├── common/           # 公共模块
│   ├── security/         # 安全认证
│   └── modules/          # 业务模块
├── src/main/resources/
│   ├── application.yml   # 主配置
│   ├── application-dev.yml
│   └── application-prod.yml
└── pom.xml
```

## 开发规范

### Controller 层

```java
@RestController
@RequestMapping("/system/user")
@Tag(name = "用户管理")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult<UserVO>> page(UserQueryParam param) {
        return Result.success(userService.page(param));
    }
}
```

### Service 层

```java
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public UserVO getById(Long id) {
        User user = userMapper.selectById(id);
        return convertToVO(user);
    }
}
```

### Entity 层

```java
@Data
@TableName("sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    // ...
}
```

## 常用命令

```bash
./mvnw spring-boot:run                    # 启动开发服务
./mvnw clean package -DskipTests          # 构建项目
./mvnw test                               # 运行测试
```

## API 文档

启动后访问：http://localhost:8080/swagger-ui.html
