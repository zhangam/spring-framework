package org.zhangam.example.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/5
 */
@Component
public class UserService {

	@Value("${testuser.name}")
	private String name;


	public void printName() {
		System.out.println(">>>>" + this.name);
	}

	public void printUser() {
		// System.out.println(this.name);
	}
}