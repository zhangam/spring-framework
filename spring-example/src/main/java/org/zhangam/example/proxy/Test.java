package org.zhangam.example.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import java.lang.reflect.Proxy;

/**
 * @author Live.InPast
 * @since 2022/6/5
 */
public class Test {

	public static void main(String[] args) {
//		jdkDynamicProxy();
		cglibDynamicProxy();
	}

	/**
	 * jdk的动态代理，一定是基于接口
	 */
	private static void jdkDynamicProxy() {
		AminService aminService = new AminServiceImpl();
		Object proxyInstance = Proxy.newProxyInstance(aminService.getClass().getClassLoader(), aminService.getClass().getInterfaces(), (proxy, method, args) -> {
			System.out.println("jdk proxy before");
			Object invoke = method.invoke(aminService, args);
			System.out.println("jdk proxy after");
			return invoke;
		});
		AminService as = (AminService) proxyInstance;
		as.getName();
	}

	/**
	 * cglib动态代理，可接口可类
	 */
	private static void cglibDynamicProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Amin2Service.class);
		enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
			System.out.println("cglib proxy before");
			Object invoke = methodProxy.invokeSuper(o, objects);
			System.out.println("cglib proxy after");
			return invoke;
		});
		Amin2Service amin2Service = (Amin2Service) enhancer.create();
		amin2Service.getName();
	}

	/**
	 * cglib动态代理，可接口可类
	 */
	private static void cglibDynamicProxy2() {
		Amin2Service amin2Service1 = new Amin2Service();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(amin2Service1.getClass());
		enhancer.setCallback((InvocationHandler) (o, method, objects) -> {
			System.out.println("cglib proxy before");
			Object invoke = method.invoke(amin2Service1, objects);
			System.out.println("cglib proxy after");
			return invoke;
		});
		Amin2Service amin2Service = (Amin2Service) enhancer.create();
		amin2Service.getName();
	}


}
