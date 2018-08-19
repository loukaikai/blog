package com.blog.web.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImp implements MessageSender{

	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public  void sendMessage(String channel, String message) {
		stringRedisTemplate.convertAndSend(channel, message);
	}

}
