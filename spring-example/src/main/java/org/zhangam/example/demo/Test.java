package org.zhangam.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zhangam.example.demo.config.AppConfig;
import org.zhangam.example.demo.service.UserService;

/**
 * @author Live.InPast
 * @since  2022/6/3
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.zhangam.example");
		UserService userService = context.getBean(UserService.class);
		userService.getName();
	}

}