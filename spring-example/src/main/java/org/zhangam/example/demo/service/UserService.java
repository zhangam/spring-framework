package org.zhangam.example.demo.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Live.InPast
 * @since 2022/6/3
 */
@Component
public class UserService {

	@PostConstruct
	public void init() {
		System.out.println("UserService Class init.");
	}

	public void getName() {
		System.out.println("This is Amin.");
	}

}
