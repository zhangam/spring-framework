package org.zhangam.example.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zhangam.example.transaction.service.UserService;
import org.zhangam.example.transaction.service.UserService2;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/6/20
 */
public class TestSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBatisConfig.class);
		UserService2 userService = context.getBean(UserService2.class);
		System.out.println(userService);
		userService.getName(6);
	}

}