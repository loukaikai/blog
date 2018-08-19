package com.blog.web.user;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenManage {
	@Resource
	RedisTemplate<Object, Object> redisTemplate;
	
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
				15*60*1000, TimeUnit.HOURS);
		return token;
	}
	/**
	 * 检查token是否正确
	 * @param token 令牌
	 * @return true正确;false失败
	 */
	public boolean checkToken(String token){
		//解析出userId和uuid
		String arr[] = token.split("_");
		String key = arr[1]+"_token";
		String r_token = (String) redisTemplate.opsForValue().get(key);
		if(null == r_token) {
			return false;
		}
		if(!token.equals(r_token)) {
			return false;
		}
		return true;
	}	
	
	/**
	 * 注销Token
	 * @param token 令牌
	 * @return true正确;false失败
	 */
	public boolean clearToken(String token){
		//解析出userId和uuid
		String arr[] = token.split("_");
		String key = arr[1]+"_token";
		String r_token = (String) redisTemplate.opsForValue().get(key);
		if(null == r_token) {
			return false;
		}
		if(!token.equals(r_token)) {
			return false;
		}
		redisTemplate.delete(key);
		 return true;
	}	
 	public static void main(String[] args){
		TokenManage manager = new TokenManage();
		System.out.println(manager.createToken(1));
	} 

}
