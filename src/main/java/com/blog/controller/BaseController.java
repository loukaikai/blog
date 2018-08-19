package com.blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.blog.service.imp.ArticeContentSercviceImp;
import com.blog.service.imp.MailServiceImp;
import com.blog.service.imp.MessageServiceImp;
import com.blog.service.imp.SortInfoServiceImp;

@Controller
public class BaseController {
	@Resource
	SortInfoServiceImp sortInfoService;
	
	@Resource
	ArticeContentSercviceImp  articeContentSercvice;
	
	@Resource
	MessageServiceImp  messgeSercvice;
	
	@Resource
	MailServiceImp mailService;
}
