package com.blog.entity;

import java.util.Date;

public class Message {
    private Long id;

    private String content;

    @Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", create_by=" + create_by + ", email=" + email
				+ ", name=" + name + ", ip=" + ip + ", is_effective=" + is_effective + "]";
	}

	public Message(String content, Date create_by, String email, String name, String ip, Boolean is_effective) {
		super();
		this.content = content;
		this.create_by = create_by;
		this.email = email;
		this.name = name;
		this.ip = ip;
		this.is_effective = is_effective;
	}

	private Date create_by;

    private String email;

    private String name;

    private String ip;

    private Boolean is_effective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Date create_by) {
        this.create_by = create_by;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Boolean getIs_effective() {
        return is_effective;
    }

    public void setIs_effective(Boolean is_effective) {
        this.is_effective = is_effective;
    }
}