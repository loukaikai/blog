package com.blog.service.imp;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.blog.dao.ArticleInfoMapper;
import com.blog.entity.ArticleInfo;
import com.blog.service.ArticeContentService;
import com.blog.util.AjaxResult;

@Service
public class ArticeContentSercviceImp implements ArticeContentService{
	@Resource
	ArticleInfoMapper articleInfoMapper;
	public AjaxResult addArtice(HttpServletRequest request){
		AjaxResult ajax = new AjaxResult();
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String content = request.getParameter("content");
		String is_top = request.getParameter("is_top");
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		Date date = new Date();
		ArticleInfo article = new  ArticleInfo(title, summary, Boolean.valueOf(is_top), 0, date,date,content);
		articleInfoMapper.insert(article);
		ajax.setSuccess(true);
		ajax.setMessage("文章已经添加成功");
		return ajax;
	}
}
