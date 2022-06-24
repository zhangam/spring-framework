package org.zhangam.example.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.zhangam.example.transaction.mapper.UserMapper;
import org.zhangam.example.transaction.pojo.User;

/**
 * @author Live.InPast
 * @since 2022/6/3
 */
@Component
public class UserService2 {

	@Autowired
	private UserMapper userMapper;

	@Transactional(rollbackFor = Exception.class)
	@Cacheable(value = "cache", key = "#uid", unless = "#result == null")
	public void getName(Integer uid) {
		System.out.println(userMapper.selectById(uid).getName());
	}

	@Transactional(rollbackFor = Exception.class)
	public void insert() {
		User user = new User();
		user.setName("test_for_error");
		user.setAge(310);
		userMapper.insert(user);
		if (true) {
			throw new NullPointerException("测试异常回滚");
		}
	}

}
