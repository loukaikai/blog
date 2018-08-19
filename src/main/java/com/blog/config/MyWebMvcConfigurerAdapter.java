package com.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport  {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
//		registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/LoginController/**");
//		registry.addInterceptor(sysInterceptor()).addPathPatterns("/**");
//		super.addInterceptors(registry);
	}

}
