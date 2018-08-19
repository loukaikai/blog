package com.blog.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.SysLogMapper;
import com.blog.dao.SysViewMapper;
import com.blog.entity.SysLog;
import com.blog.entity.SysView;
import com.blog.service.SysService;

@Service
public class SysServiceImp implements SysService{
	
	@Resource
	SysViewMapper sysViewMapper;
	
	@Resource
	SysLogMapper sysLogMapper;
	@Override
	public void addSysView(SysView sysView) {
		sysViewMapper.insert(sysView);
	}

	@Override
	public void addSysLog(SysLog sysLog) {
		sysLogMapper.insertSelective(sysLog);
	}

 
}
