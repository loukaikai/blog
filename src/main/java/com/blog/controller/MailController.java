package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.MailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("Mail")
@RestController
@RequestMapping("/MailController")
public class MailController extends BaseController{
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value="/sendMail",method=RequestMethod.GET)
 	@ApiOperation(value="/sendMail", notes=" ")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "to", value = "接受者的地址", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "subject", value = "邮件主题", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "content", value = "邮件内容", required = true, dataType = "String")})
	public void sendMail(HttpServletRequest request,HttpServletResponse resp) {
		  mailService.sendMail(request); 
	}
	
	@RequestMapping(value="/finAllMail", method=RequestMethod.GET)
 	@ApiOperation(value="finAllMail", notes="查找用户所有的mail")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "uid", value = "用户id", required = true, dataType = "String"),
 })
	public void finAllMail(HttpServletRequest request,HttpServletResponse resp) {
		  mailService.findMail(request); 
	} 

}
