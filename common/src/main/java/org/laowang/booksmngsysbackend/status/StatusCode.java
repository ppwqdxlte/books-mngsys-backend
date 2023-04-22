package org.laowang.booksmngsysbackend.status;

import java.io.Serializable;

/**
 * @program: books-mngsys-backend
 * @description: This is property class with  status codes.
 * @author: Laowang
 * @create: 2023-04-22 10:52
 */
public class StatusCode implements Serializable {
    // 成功
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer ERROR_CODE = 700;
    // 没资源
    public static final Integer NOT_FOUND = 404;
    // 服务器内部错误
    public static final Integer SERVER_ERROR = 500;
    // 未登录
    public static final Integer NO_LOGIN = 401;
    // 无权限
    public static final Integer NO_AUTH = 403;
}
