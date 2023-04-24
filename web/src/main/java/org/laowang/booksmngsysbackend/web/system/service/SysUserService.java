package org.laowang.booksmngsysbackend.web.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.laowang.booksmngsysbackend.web.system.entity.PageParam;
import org.laowang.booksmngsysbackend.web.system.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    /**
     * @description 手动添加一个分页查询的方法
     *
     * @param pageParam 分页参数对象
     * @return com.baomidou.mybatisplus.core.metadata.IPage<org.laowang.booksmngsysbackend.web.system.entity.SysUser>
     * @author Laowang
     * @create 2023/4/24
     **/
    IPage<SysUser> list(PageParam pageParam);
}
