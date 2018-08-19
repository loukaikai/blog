package com.blog.service.imp;

import org.springframework.stereotype.Service;

import com.blog.service.MessageService;

@Service
public class MessageServiceImp implements MessageService{
/*	
	@Resource
	MessageMapper messageMapper;
	
	public AjaxResult addMessage(HttpServletRequest request){
		AjaxResult ajax = new AjaxResult();
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String is_effective = request.getParameter("flag");
		
		String token = request.getParameter("token");
		if(null == token) {
			ajax.setSuccess(false);
			ajax.setMessage("token不能为空");
			return ajax;
		}
		String ip = request.getRemoteAddr();
		Date date = new Date();
		Message message = new Message( content,date, email, name, ip,Boolean.valueOf(is_effective));
		messageMapper.insert(message);
		ajax.setSuccess(true);
		ajax.setMessage("评论已经添加成功");
		return ajax;
	}*/
	
}
