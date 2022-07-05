package org.zhangam.example.conditiional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/4
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);
		TestConfiguration bean = context.getBean(TestConfiguration.class);
		System.out.println(bean);
	}

}