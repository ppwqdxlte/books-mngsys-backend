package org.laowang.booksmngsysbackend.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.laowang.booksmngsysbackend.web.system.entity.PageParam;
import org.laowang.booksmngsysbackend.web.system.entity.SysUser;
import org.laowang.booksmngsysbackend.web.system.mapper.SysUserMapper;
import org.laowang.booksmngsysbackend.web.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @program: books-mngsys-backend
 * @description: Implement of SysUserService interface.
 * @author: Laowang
 * @create: 2023-04-24 14:17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {
    /**
     * @description 分页查询的实现
     *
     * @param pageParam 分页参数
     * @return com.baomidou.mybatisplus.core.metadata.IPage<org.laowang.booksmngsysbackend.web.system.entity.SysUser>
     * @author Laowang
     * @create 2023/4/24
     **/
    @Override
    public IPage<SysUser> list(PageParam pageParam) {
        // 定义分页对象
        IPage<SysUser> page = new Page<>();
        page.setCurrent(pageParam.getCurrentPage());
        page.setSize(pageParam.getPageSize());
        // 构造查询条件
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(pageParam.getPhone())){
            queryWrapper.lambda().like(SysUser::getPhone,pageParam.getPhone());
        }
        if (StringUtils.isNotEmpty(pageParam.getNickName())) {
            queryWrapper.lambda().like(SysUser::getNickName,pageParam.getNickName());
        }
        return this.baseMapper.selectPage(page,queryWrapper);
    }
}
