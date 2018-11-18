package com.hui.wang.spring.cloud.threadlocal;

/**
 * threadLocal问题
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
public class ThreadLocalTest {

	static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

	public static void main(String[] args) {
		new Thread(() -> {
			THREAD_LOCAL.set("测试");
			new A().run();
			new C().run();
		}).start();
	}
}

class A {
	public void run() {
		System.out.println("=========方式1==============");
		System.out.println("thread name :" + Thread.currentThread().getName());
		System.out.println("A get ThreadLocal :" + ThreadLocalTest.THREAD_LOCAL.get());
		new B().run();
	}
}

class B {
	public void run() {
		System.out.println("************");
		System.out.println("thread name :" + Thread.currentThread().getName());
		System.out.println("B get ThreadLocal :" + ThreadLocalTest.THREAD_LOCAL.get());
	}
}

class C {
	public void run() {
		System.out.println("=========方式2==============");
		System.out.println("thread name :" + Thread.currentThread().getName());
		System.out.println("C get ThreadLocal :" + ThreadLocalTest.THREAD_LOCAL.get());
		new Thread(() -> new D().run()).start();
	}
}

class D {
	public void run() {
		System.out.println("************");
		System.out.println("thread name :" + Thread.currentThread().getName());
		System.out.println("D get ThreadLocal :" + ThreadLocalTest.THREAD_LOCAL.get());
	}
}