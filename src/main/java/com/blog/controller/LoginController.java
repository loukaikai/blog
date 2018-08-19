package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.LoginService;
import com.blog.util.AjaxResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("Token登录")
@RestController
@RequestMapping("/LoginController")
public class LoginController {
     @Autowired
	LoginService loginservice;
	
	@RequestMapping(value="/getLogin", method = RequestMethod.GET)
 	@ApiOperation(value="登录验证获取token", notes="test: 仅token有正确返回")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "usernme", value = "用户名", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "password", value = "用户密码", required = true, dataType = "String")})
	public AjaxResult getLogin(HttpServletRequest request,HttpServletResponse resp) {
		return loginservice.getLogin(request);
	}
	public String createToken(int userid) {
		return loginservice.createToken(userid);
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	@ApiOperation(value="添加用户", notes="test: 无返回")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="insert", name = "usernme", value = "用户名", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="insert", name = "password", value = "用户密码", required = true, dataType = "String")})
	public void addUser(HttpServletRequest request,HttpServletResponse resp) {
		loginservice.addUser(request);
	}  
	
	@RequestMapping(value = "/deteleUser",method=RequestMethod.DELETE)
	@ApiOperation(value="添加用户", notes="test: 无返回")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="insert", name = "rid", value = "rid", required = true, dataType = "String")})
	public void deteleUser(HttpServletRequest request,HttpServletResponse resp) {
		loginservice.deteleUser(request);
	}  
}
