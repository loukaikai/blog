package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.util.AjaxResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("分类")
@RestController
@RequestMapping("/SortInfoController")
public class SortInfoController extends BaseController{
	
	@RequestMapping(value ="/addSort", method = RequestMethod.POST)
 	@ApiOperation(value="add sort", notes="添加分类信息")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token名", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "name", value = "分类名称", required = true, dataType = "String")})
	public AjaxResult addSort(HttpServletRequest request,HttpServletResponse resp) {
		return sortInfoService.addSort(request);
	}
	
	@RequestMapping(value ="/deteleSort", method = RequestMethod.DELETE)
 	@ApiOperation(value="add sort", notes="添加分类信息")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token名", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "rid", value = "分类rid", required = true, dataType = "String")})
	public AjaxResult deteleSort(HttpServletRequest request,HttpServletResponse resp) {
		return sortInfoService.deteleSort(request);
	}
	
	@RequestMapping(value ="/updateSort",method = RequestMethod.PUT)
 	@ApiOperation(value="add sort", notes="更新分类信息")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token名", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "rid", value = "分类rid", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "name", value = "分类名称", required = true, dataType = "String")})
	public AjaxResult updateSort(HttpServletRequest request,HttpServletResponse resp) {
		return sortInfoService.updateSort(request);
	}
	
	@RequestMapping(value ="/findAllSort",method = RequestMethod.GET)
 	@ApiOperation(value="add sort", notes="查询所有分类信息")
	@ApiImplicitParams({
    @ApiImplicitParam(paramType="query", name = "token", value = "token名", required = true, dataType = "String")})
	public AjaxResult findAllSort(HttpServletRequest request,HttpServletResponse resp) {
		return sortInfoService.findAllSort(request);
	}
	

}
