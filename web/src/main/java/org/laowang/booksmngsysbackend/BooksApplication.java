package org.laowang.booksmngsysbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableOpenApi  // 添加这个才能访问swagger文档 http://localhost:8089/swagger-ui/index.html
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class,args);
    }
}
