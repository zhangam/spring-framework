package org.zhangam.example.transaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/6/23
 */
@Aspect
@Configuration
public class UserAspect {

	// execution 表达式主题
	// 第一个*号：表示返回类型， *号表示所有的类型。
	// 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
	// 第二个*号：表示类名，*号表示所有的类。
	// *(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
	@Pointcut(" execution (* org.zhangam.example.transaction.service.*.*(..))")
	public void pointcut() {
	}

	/*@Pointcut("@annotation(org.zhangam.example.transaction.aspect.TestAspectj)")
	public void pointcut() {
	}*/


	@Around(value = "pointcut()")
	public Object doBefore(ProceedingJoinPoint point) throws Throwable {
		System.out.println("test aspectj before");
		Object proceed = point.proceed();
		System.out.println("test aspectj after");
		return proceed;
	}

}