package com.blog.web.redis;

import org.springframework.stereotype.Component;



/**消息发布者**/

@Component
public interface MessageSender {
	 public void sendMessage(String channel,String message);
}
