package com.blog.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.SysLog;
import com.blog.entity.SysView;
import com.blog.service.imp.SysServiceImp;
import com.blog.util.BrowserUtil;

public class SysInterceptor implements HandlerInterceptor{
	
	private SysView sysView = new SysView();
	private SysLog sysLog = new SysLog();
	
	@Resource 
	SysServiceImp sysService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String browser = BrowserUtil.getOsAndBrowserInfo(request);
		Date data = new Date();
		
		sysView.setIp(ip);
		sysView.setCreate_by(data);
		sysService.addSysView(sysView);
		
		sysLog.setCreate_by(data);
		sysLog.setIp(ip);
		sysLog.setOperate_by(browser);
		sysLog.setOperate_url(url);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		sysLog.setRemark(method.getName());
		sysService.addSysLog(sysLog);
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
