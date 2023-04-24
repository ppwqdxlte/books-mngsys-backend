package org.laowang.booksmngsysbackend.web.system.entity;

import lombok.Data;

/**
 * @program: books-mngsys-backend
 * @description: Pagination util of query list.
 * @author: Laowang
 * @create: 2023-04-24 15:10
 */
@Data
public class PageParam {
    private Long currentPage;
    private Long pageSize;
    private String phone;
    private String nickName;
}
