package org.laowang.booksmngsysbackend.utils;

import org.laowang.booksmngsysbackend.status.StatusCode;

import java.io.Serializable;

/**
 * @program: books-mngsys-backend
 * @description: This is a util class for ResultVo's operations.
 * @author: Laowang
 * @create: 2023-04-22 11:19
 */
public class ResultUtils implements Serializable {
    /**
     * @description 结果
     *
     * @param msg msg
     * @param code code
     * @param data data
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @author Laowang
     * @create 2023/4/22
     **/
    private static ResultVo resultVo(String msg,Integer code,Object data){
        return new ResultVo<>(msg,code,data);
    }
    /**
     * @description 请求成功返回
     *
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @author Laowang
     * @create 2023/4/22
     **/
    public static ResultVo success(){
        return resultVo(null, StatusCode.SUCCESS_CODE,null);
    }
    public static ResultVo success(String msg){
        return resultVo(msg,StatusCode.SUCCESS_CODE,null);
    }
    public static ResultVo success(String msg,Object data){
        return resultVo(msg,StatusCode.SUCCESS_CODE,data);
    }
    public static ResultVo success(String msg,Integer code,Object data){
        return resultVo(msg,code,data);
    }
    /**
     * @description 请求失败返回
     *
     * @return org.laowang.booksmngsysbackend.utils.ResultVo
     * @author Laowang
     * @create 2023/4/22
     **/
    public static ResultVo error(){
        return resultVo(null,StatusCode.ERROR_CODE,null);
    }
    public static ResultVo error(String msg){
        return resultVo(msg,StatusCode.ERROR_CODE,null);
    }
    public static ResultVo error(String msg,Object data){
        return resultVo(msg,StatusCode.ERROR_CODE,data);
    }
    public static ResultVo error(String msg,Integer code,Object data){
        return resultVo(msg,code,data);
    }
}
