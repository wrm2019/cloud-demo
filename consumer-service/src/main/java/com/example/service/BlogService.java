package com.example.service;

import com.example.bean.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
* 访问Blog的Feign客户端服务
* */
@FeignClient(name="producer-service",fallback=BlogServiceFallBack.class)//name属性必须是服务的名称,也就是spring.application.name的值
public interface BlogService {

    /*
    * feign支持用springmvc的RequestMapping注解来表你要访问的服务的地址
    * */
    @RequestMapping("/blog/{title}")
    public Blog findByTitle(@PathVariable("title") String title);

    @RequestMapping("/blog/findList")
    public List<Blog> findList();

}
