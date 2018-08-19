package com.blog.interceptor;

import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.blog.web.user.TokenManage;

public class TokenInterceptor implements HandlerInterceptor{

	private static Logger logger = LogManager.getLogger(TokenInterceptor.class);
	@Resource
	TokenManage tokenmanage ;
	
	/*该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
	 * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info(request+"   "+response);
		
	}
	/*该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
	 * 该方法将在整个请求结束之后，也就是在DispatcherServlet 
	 * 渲染了对应的视图之后执行。用于进行资源清理。*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.info(request+"   "+response+arg2+arg3);
		
	}
	/*该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，
	 * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
	 * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hahdler) throws Exception {
		String token = request.getParameter("token");
		System.out.println("*************************token*********************");
		System.out.println(token);
		boolean flag = tokenmanage.checkToken(token);
		if(flag) {
			return true;
		}else {
			OutputStream out = response.getOutputStream();
			response.setContentType("text/html");
			JSONObject json = new JSONObject();
			json.put("success", false);
			json.put("message", "token faile");
			out.write(json.toString().getBytes() );
		}
		return false;
	}

}
