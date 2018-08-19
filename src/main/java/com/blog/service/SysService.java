package com.blog.service;

import com.blog.entity.SysLog;
import com.blog.entity.SysView;

public interface SysService {
	
	public void addSysView(SysView sysView);
	
	public void addSysLog(SysLog sysLog);

}
