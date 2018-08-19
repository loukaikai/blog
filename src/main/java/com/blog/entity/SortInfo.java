package com.blog.entity;

import java.util.Date;

public class SortInfo {
    @Override
	public String toString() {
		return "SortInfo [id=" + id + ", name=" + name + ", number=" + number + ", create_by=" + create_by
				+ ", modified_by=" + modified_by + ", is_effective=" + is_effective + "]";
	}

	public SortInfo(String name, int number, Date create_by, Date modified_by, int is_effective) {
		super();
		this.name = name;
		this.number = number;
		this.create_by = create_by;
		this.modified_by = modified_by;
		this.is_effective = is_effective;
	}
	
	public SortInfo(Long id,String name, int number, Date create_by, Date modified_by, int is_effective) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.create_by = create_by;
		this.modified_by = modified_by;
		this.is_effective = is_effective;
	}
	
	public SortInfo() {
	}

	private Long id;

    private String name;

    private int number;

    private Date create_by;

    private Date modified_by;

    private int is_effective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int i) {
        this.number = i;
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

    public int getIs_effective() {
        return is_effective;
    }

    public void setIs_effective(int is_effective) {
        this.is_effective = is_effective;
    }
}