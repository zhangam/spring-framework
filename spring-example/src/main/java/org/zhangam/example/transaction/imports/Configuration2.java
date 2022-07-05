package org.zhangam.example.transaction.imports;

import org.springframework.context.annotation.Bean;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/5
 */
public class Configuration2 {


	@Bean
	public String testc2() {
		System.out.println("Configuration2.testc2");
		return "b";
	}


}