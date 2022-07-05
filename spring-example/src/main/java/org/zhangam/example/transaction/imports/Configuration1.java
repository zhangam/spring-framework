package org.zhangam.example.transaction.imports;

import org.springframework.context.annotation.Bean;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/5
 */
public class Configuration1 {


	@Bean
	public String testc1() {
		System.out.println("Configuration1.testc1");
		return "a";
	}


}