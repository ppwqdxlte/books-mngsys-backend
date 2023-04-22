package org.laowang.booksmngsysbackend.utils;

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
public class ResultVo<T> implements Serializable {
    private String msg;
    private Integer code;
    private T data;
}
