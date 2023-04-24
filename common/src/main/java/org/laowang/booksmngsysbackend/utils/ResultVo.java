package org.laowang.booksmngsysbackend.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: books-mngsys-backend
 * @description: This is a wrapper class for view-object result.
 * @author: Laowang
 * @create: 2023-04-22 10:26
 */
@Data
@AllArgsConstructor
@ApiModel(value = "返回结果视图对象",description = "携带了信息响应码和数据的结果类")
public class ResultVo<T> implements Serializable {
    @ApiModelProperty(value = "消息")
    private String msg;
    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty(value = "数据")
    private T data;
}
