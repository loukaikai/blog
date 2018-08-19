package com.blog.entity;

import java.util.Date;

public class ArticleInfo {
    private Long id;

    private String title;

    private String summary;

    private Boolean is_top;

    private Integer traffic;

    private Date create_by;

    public ArticleInfo(String title, String summary, Boolean is_top, Integer traffic, Date create_by, Date modified_by,
			String content) {
		super();
		this.title = title;
		this.summary = summary;
		this.is_top = is_top;
		this.traffic = traffic;
		this.create_by = create_by;
		this.modified_by = modified_by;
		this.content = content;
	}

	private Date modified_by;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public void setIs_top(Boolean is_top) {
        this.is_top = is_top;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public Date getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Date create_by) {
        this.create_by = create_by;
    }

    public Date getModified_by() {
        return modified_by;
    }

    public void setModified_by(Date modified_by) {
        this.modified_by = modified_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}