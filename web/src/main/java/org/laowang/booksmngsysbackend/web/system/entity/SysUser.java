package org.laowang.booksmngsysbackend.web.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: books-mngsys-backend
 * @description: Entity class of sys_user
 * @author: Laowang
 * @create: 2023-04-24 14:00
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId(type = IdType.AUTO) //自增
    private Long userId;
    private String username;
    private String nickName;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private String address;
    private String isAdmin;
    private Boolean accountNotLocked = true;
    private Boolean credentialNotExpired = true;
    private Boolean isEnabled = true;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;
}
