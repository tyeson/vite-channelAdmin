USE channel_admin_dev;

-- 用户表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
  username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
  password VARCHAR(100) NOT NULL COMMENT '密码',
  nickname VARCHAR(50) COMMENT '昵称',
  avatar VARCHAR(255) COMMENT '头像',
  email VARCHAR(100) COMMENT '邮箱',
  phone VARCHAR(20) COMMENT '手机号',
  status TINYINT DEFAULT 1 COMMENT '状态 0:禁用 1:启用',
  deleted TINYINT DEFAULT 0 COMMENT '删除标记 0:未删除 1:已删除',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  last_login_time DATETIME COMMENT '最后登录时间',
  INDEX idx_username (username),
  INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 角色表
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '角色ID',
  name VARCHAR(50) NOT NULL COMMENT '角色名称',
  code VARCHAR(50) NOT NULL UNIQUE COMMENT '角色编码',
  description VARCHAR(255) COMMENT '描述',
  status TINYINT DEFAULT 1 COMMENT '状态 0:禁用 1:启用',
  deleted TINYINT DEFAULT 0 COMMENT '删除标记',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  INDEX idx_code (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 权限表
DROP TABLE IF EXISTS sys_permission;
CREATE TABLE sys_permission (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '权限ID',
  name VARCHAR(50) NOT NULL COMMENT '权限名称',
  code VARCHAR(100) NOT NULL UNIQUE COMMENT '权限编码',
  type TINYINT NOT NULL COMMENT '类型 1:菜单 2:按钮',
  parent_id BIGINT DEFAULT 0 COMMENT '父级ID',
  path VARCHAR(255) COMMENT '路由路径',
  component VARCHAR(255) COMMENT '组件路径',
  icon VARCHAR(50) COMMENT '图标',
  sort INT DEFAULT 0 COMMENT '排序',
  status TINYINT DEFAULT 1 COMMENT '状态',
  deleted TINYINT DEFAULT 0 COMMENT '删除标记',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  INDEX idx_code (code),
  INDEX idx_parent_id (parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- 用户角色关联表
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  user_id BIGINT NOT NULL COMMENT '用户ID',
  role_id BIGINT NOT NULL COMMENT '角色ID',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  UNIQUE KEY uk_user_role (user_id, role_id),
  INDEX idx_user_id (user_id),
  INDEX idx_role_id (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- 角色权限关联表
DROP TABLE IF EXISTS sys_role_permission;
CREATE TABLE sys_role_permission (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  role_id BIGINT NOT NULL COMMENT '角色ID',
  permission_id BIGINT NOT NULL COMMENT '权限ID',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  UNIQUE KEY uk_role_permission (role_id, permission_id),
  INDEX idx_role_id (role_id),
  INDEX idx_permission_id (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- 初始化管理员账号 (密码: admin123, 使用 BCrypt 加密)
INSERT INTO sys_user (username, password, nickname, email, status) VALUES
('admin', '$2a$10$e.fomH6acVt9fACn/SK6yuQR.QQzmjIgCUdsSoATeeu1NZ.V/Kjle', '超级管理员', 'admin@example.com', 1);

-- 初始化角色
INSERT INTO sys_role (name, code, description, status) VALUES
('超级管理员', 'admin', '拥有所有权限', 1),
('普通用户', 'user', '普通用户权限', 1);

-- 初始化权限
INSERT INTO sys_permission (name, code, type, parent_id, path, component, icon, sort, status) VALUES
('系统管理', 'system', 1, 0, '/system', 'Layout', 'Setting', 1, 1),
('用户管理', 'system:user', 1, 1, '/system/user', 'system/user/index', 'User', 1, 1),
('角色管理', 'system:role', 1, 1, '/system/role', 'system/role/index', 'UserFilled', 2, 1),
('权限管理', 'system:permission', 1, 1, '/system/permission', 'system/permission/index', 'Lock', 3, 1),
('新增用户', 'system:user:add', 2, 2, NULL, NULL, NULL, 1, 1),
('编辑用户', 'system:user:edit', 2, 2, NULL, NULL, NULL, 2, 1),
('删除用户', 'system:user:delete', 2, 2, NULL, NULL, NULL, 3, 1);

-- 分配管理员角色
INSERT INTO sys_user_role (user_id, role_id) VALUES (1, 1);

-- 分配角色权限 (超级管理员拥有所有权限)
INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 1, id FROM sys_permission;

-- 分配普通用户权限
INSERT INTO sys_role_permission (role_id, permission_id) VALUES
(2, 1), (2, 2);
