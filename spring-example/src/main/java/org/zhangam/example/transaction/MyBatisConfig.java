package org.zhangam.example.transaction;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.zhangam.example.transaction.imports.TestDeferredImportSelector;
import org.zhangam.example.transaction.imports.TestImportSelector;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/6/20
 */
@Configuration
// 开启缓存
@EnableCaching
// 开启事务
@EnableTransactionManagement
@ComponentScan("org.zhangam.example.transaction")
@MapperScan("org.zhangam.example.transaction.mapper")
@EnableAspectJAutoProxy
@Import({TestImportSelector.class, TestDeferredImportSelector.class})
public class MyBatisConfig {

	@Bean
	public DataSource dataSource() {
		PooledDataSource pooledDataSource = new PooledDataSource();
		pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
		pooledDataSource.setUrl("jdbc:mysql://192.168.1.241:3307/spring_test?serverTimezone=GMT%2B8");
		pooledDataSource.setUsername("root");
		pooledDataSource.setPassword("zhixinhuixue");
		return pooledDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("org.zhangam.example.transaction.pojo");
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		return sqlSessionFactoryBean.getObject();
	}


	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("cache");
		return cacheManager;
	}

}