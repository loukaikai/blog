package com.blog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.blog.nosqldomain.Mail;

public interface MailService {
	 
	void sendMail(HttpServletRequest request);
	 /**
     * 发送的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to,String subject,String content,Mail mail);
	 /**
     * 发送html格式的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to,String subject,String content,Mail mail);
	
	Mail save(Mail mail);
	
	List<Mail> findMail(HttpServletRequest request);

}
