package org.zhangam.example.transaction;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zhangam.example.transaction.mapper.UserMapper;
import org.zhangam.example.transaction.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 事务测试
 *
 * @author zhangamin
 * @date 2022/6/20
 */
public class Test {

	public static void main(String[] args) throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setName("zhangam");
			user.setAge(31);
			mapper.insert(user);


			List<User> users = mapper.selectAll();
			System.out.println(users.size());

			// 一定要提交，否则没有插入进去
			sqlSession.commit();
		}
	}


}