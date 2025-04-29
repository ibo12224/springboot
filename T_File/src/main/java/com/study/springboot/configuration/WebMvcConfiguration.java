package com.study.springboot.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.MultipartConfigElement;

public class WebMvcConfiguration implements WebMvcConfigurer {
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
//		factory.setLocation("C:/Temp/board");//업로드 저장 위치
		factory.setMaxRequestSize(DataSize.ofMegabytes(100L));
		factory.setMaxFileSize(DataSize.ofMegabytes(100L));
		
		return factory.createMultipartConfig();
	}
}
