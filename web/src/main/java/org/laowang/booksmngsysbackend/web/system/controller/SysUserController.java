package org.laowang.booksmngsysbackend.web.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.laowang.booksmngsysbackend.utils.ResultUtils;
import org.laowang.booksmngsysbackend.utils.ResultVo;
import org.laowang.booksmngsysbackend.web.system.entity.PageParam;
import org.laowang.booksmngsysbackend.web.system.entity.SysUser;
import org.laowang.booksmngsysbackend.web.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

/**
 * @program: books-mngsys-backend
 * @description: Controller of sys_user.
 * @author: Laowang
 * @create: 2023-04-24 14:21
 */
@RestController
@RequestMapping("/api/system/user")
@Api(tags = "系统管理",value = "用户管理")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * @param user 新增的用户对象
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @description add user
     * @author Laowang
     * @create 2023/4/24
     **/
    @ApiOperation(value = "添加用户",notes = "添加一个用户，传入用户名姓名密码邮箱性别等等")
    @PostMapping
    public ResultVo addUser(@RequestBody SysUser user) {
        // 判断账户是否被占用
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername, user.getUsername());
        SysUser one = sysUserService.getOne(queryWrapper);
        if (one == null) {
            // 密码加密
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            user.setIsAdmin("0");
            user.setCreatedTime(new Date());
            // 入库
            boolean save = sysUserService.save(user);
            if (save) {
                return ResultUtils.success("添加成功", user);
            }
            return ResultUtils.error("添加失败");
        } else {
            return ResultUtils.error("该账户已被占用");
        }
    }

    /**
     * @param user user
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @description edit user
     * @author Laowang
     * @create 2023/4/24
     **/
    @ApiOperation(value = "编辑用户",notes = "修改用户信息，如果账号占用就失败了")
    @PutMapping
    public ResultVo editUser(@RequestBody SysUser user) {
        // 判断账户是否被占用
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername,user.getUsername());
        SysUser one = sysUserService.getOne(queryWrapper);
        if (one != null && !Objects.equals(one.getUserId(), user.getUserId())){
            return ResultUtils.error("账户被占用！");
        }
        // 密码加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setUpdatedTime(new Date());
        // 更新
        boolean updateById = sysUserService.updateById(user);
        if (updateById){
            return ResultUtils.success("编辑成功",user);
        }
        return ResultUtils.error("编辑失败");
    }
    /**
     * @description delete user
     *
     * @param userId userId
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @author Laowang
     * @create 2023/4/24
     **/
    @ApiOperation(value = "删除用户",notes = "根据ID删除用户")
    @ApiImplicitParam(paramType = "path",name = "userId",value = "用户id",required = true
            ,dataType = "Long",dataTypeClass = Long.class)
    @DeleteMapping("/{userId}")
    public ResultVo deleteUser(@PathVariable("userId") Long userId){
        boolean removeById = sysUserService.removeById(userId);
        if (removeById) {
            return ResultUtils.success("删除用户成功！");
        }
        return ResultUtils.error("删除用户失败");
    }
    /**
     * @description query list
     * GetMapping 一般不支持@RequestBody所以分页对象不需要注解
     *
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @author Laowang
     * @create 2023/4/24
     **/
    @ApiOperation(value = "分页查询用户列表",notes = "按分页参数分页查询")
    @GetMapping
    public ResultVo getList(PageParam pageParam){
        IPage<SysUser> page = sysUserService.list(pageParam);
        // 处理密码
        page.getRecords().stream().forEach(item -> item.setPassword(""));
        return ResultUtils.success("查询如下",page);
    }
}
