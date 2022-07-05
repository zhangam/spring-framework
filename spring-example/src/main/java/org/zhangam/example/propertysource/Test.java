package org.zhangam.example.propertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/5
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
		UserService userService = context.getBean(UserService.class);
		userService.printName();
	}

}