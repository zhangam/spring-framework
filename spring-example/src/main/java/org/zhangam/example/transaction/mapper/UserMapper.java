package org.zhangam.example.transaction.mapper;

import org.zhangam.example.transaction.pojo.User;

import java.util.List;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/6/20
 */
public interface UserMapper {

	void insert(User user);

	List<User> selectAll();

	User selectById(Integer id);
}
