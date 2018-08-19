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
@RequestMapping("/ArticeContentControlle")
public class ArticeContentController extends BaseController{
	
	@RequestMapping(value ="/addArtice", method = RequestMethod.GET)
 	@ApiOperation(value="addArtice", notes="添加文章")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "title", value = "分类标题", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "summary", value = "文章简介", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "content", value = "分类内容", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "is_top", value = "文章是否置顶", required = true, dataType = "String")})
	public AjaxResult addSort(HttpServletRequest request,HttpServletResponse resp) {
		return articeContentSercvice.addArtice(request);
	}

}
