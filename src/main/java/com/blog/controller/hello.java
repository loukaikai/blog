package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/hellocontroller")
@Api("/hello")
public class hello {
	/*@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}*/
}
