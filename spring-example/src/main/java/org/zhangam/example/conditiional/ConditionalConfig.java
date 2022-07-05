package org.zhangam.example.conditiional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/4
 */
@Configuration
@ComponentScan("org.zhangam.example.conditiional")
public class ConditionalConfig {


//	@Bean
//	@ConditionalOnAmin
//	public TestConfiguration testConfiguration(){
//		return new TestConfiguration();
//	}

	@Bean
	@Conditional(OnAminCondition.class)
	public TestConfiguration testConfiguration(){
		return new TestConfiguration();
	}

}