package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.util.AjaxResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/MessageController")
public class MessageController extends BaseController{
	@RequestMapping(value ="/addMessage", method = RequestMethod.GET)
 	@ApiOperation(value="addArtice", notes="添加文章")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "content", value = "评论内容", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "email", value = "邮箱", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "name", value = "名称", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "flag", value = "名称", required = true, dataType = "String")})
	public AjaxResult addSort(HttpServletRequest request,HttpServletResponse resp) {
		return null;
	}
}
