package com.blog.nosqldomain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.thymeleaf.context.Context;

@Document
public class Mail extends AbstractDocument{
	private int uid;
	
	/**
	 * 邮件发送的地址
	 * **/
	private String AddressEmailTo;
	
	
	/**
	 * 邮件发送者
	 * **/
	private String AddressEmailFrom;
	
	/**
	 * 邮件主题
	 * **/
	private String subject;
	
	private String text;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAddressEmailTo() {
		return AddressEmailTo;
	}

	public void setAddressEmailTo(String addressEmailTo) {
		AddressEmailTo = addressEmailTo;
	}

	public String getAddressEmailFrom() {
		return AddressEmailFrom;
	}

	public void setAddressEmailFrom(String addressEmailFrom) {
		AddressEmailFrom = addressEmailFrom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	private Context context;
	
}
