package com.blog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("接口测试")
@RestController
public class HelloControll {
	 @ApiOperation(value = "hello", notes = "测试接口")
	@RequestMapping("/hello")
	
    public String index() {
        return "Hello World1111";
    }
}
