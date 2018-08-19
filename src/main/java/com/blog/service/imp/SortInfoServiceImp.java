package com.blog.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.blog.dao.SortInfoMapper;
import com.blog.entity.SortInfo;
import com.blog.service.SortInfoService;
import com.blog.util.AjaxResult;

@Service
public class SortInfoServiceImp implements SortInfoService {
	
	@Resource
	SortInfoMapper sortInfoMapper;
	public AjaxResult addSort(HttpServletRequest request){
		AjaxResult ajax = new AjaxResult();
		String name = request.getParameter("name");
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		SortInfo sortInfo = sortInfoMapper.selectByname(name);
		if(null != sortInfo) {
			ajax.setSuccess(false);
			ajax.setMessage("分类已经存在");
			
		}else {
			Date date = new Date();
			SortInfo sort = new SortInfo(name,0,date,date,0);
			sortInfoMapper.insert(sort);
			ajax.setSuccess(true);
			ajax.setMessage("分类已经添加成功");
		}
		return ajax;
	}
	
	public AjaxResult deteleSort(HttpServletRequest request) {
		AjaxResult ajax = new AjaxResult();
		String rid = request.getParameter("rid");
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		sortInfoMapper.deleteByPrimaryKey(Long.valueOf(rid));
		return ajax;
	}
	
	public AjaxResult updateSort(HttpServletRequest request) {
		AjaxResult ajax = new AjaxResult();
		String rid = request.getParameter("rid");
		String name = request.getParameter("name");
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		Date date = new Date();
		SortInfo sort = new SortInfo();
		sort.setId(Long.valueOf(rid));
		sort.setName(name);
		sort.setModified_by(date);
		sortInfoMapper.updateByPrimaryKeySelective(sort);
		ajax.setSuccess(true);
		ajax.setMessage("更新分类已经成功");
		return ajax;
	}
	
	public AjaxResult findAllSort(HttpServletRequest request) {
		AjaxResult ajax = new AjaxResult();
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		List<SortInfo> list = sortInfoMapper.selectAllSort();
		ajax.setSuccess(true);
		ajax.setMessage("更新分类已经成功");
		ajax.setValue(list);
		return ajax;
	}
}
