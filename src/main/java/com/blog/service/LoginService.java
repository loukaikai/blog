package com.blog.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.blog.dao.UserMapper;
import com.blog.entity.User;
import com.blog.util.AjaxResult;

@Service
public class LoginService {
 	@Resource
	RedisTemplate<Object, Object> redisTemplate;
	@Resource
	UserMapper userMapper;
	
	public AjaxResult getLogin(HttpServletRequest request) {
		AjaxResult ajax = new AjaxResult();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userMapper.selectByUsername(username);
		if(null == user) {
			ajax.setSuccess(false);
			ajax.setMessage("用户名密码为空");
			return ajax;
		}else {
			if(!password.equals(user.getPassword())) {
				ajax.setSuccess(false);
				ajax.setMessage("用户名密码错误");
				return ajax;
			}
			ajax.setSuccess(true);
			ajax.setMessage("登录成功");
			ajax.setValue(createToken(user.getRid()));
			return ajax;
		}
	}
	
	 /**
	 * 生成一个令牌
	 * @param username 用户名
	 * @return 返回令牌
	 */ 
	public String createToken(int userid) {
		UUID uuid = UUID.randomUUID();
		String token = userid+"_"+uuid.toString().replaceAll("-", "");
		String key = userid+"_token";
		redisTemplate.opsForValue().set(key, token, 
				15, TimeUnit.HOURS);
		return token;
	}
	
	public void addUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(null != user)
			userMapper.insert(user);
	}  
	public void deteleUser(HttpServletRequest request) {
		String rid = request.getParameter("rid");
		userMapper.deleteByPrimaryKey(Integer.valueOf(rid));
	}  
}
