package org.laowang.booksmngsysbackend.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: books-mngsys-backend
 * @description: This is a configuration class for mybatis-plus.
 * @author: Laowang
 * @create: 2023-04-22 10:11
 */
@Configuration
@MapperScan("org.laowang.booksmngsysbackend.*.*.mapper")
public class MybatisPlusConfig {
    /**
     * @description
     *
     * @return com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     * @author Laowang
     * @create 2023/4/22
     **/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
