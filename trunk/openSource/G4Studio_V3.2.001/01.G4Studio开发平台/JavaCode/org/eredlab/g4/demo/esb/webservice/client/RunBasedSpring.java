package org.eredlab.g4.demo.esb.webservice.client;

import org.eredlab.g4.bmf.util.SpringBeanLoader;
import org.eredlab.g4.demo.esb.webservice.HelloWorldService;

public class RunBasedSpring {
	
	public static void main(String[] args) {
		sayHello();
		queryBalanceInfo();
	}
	
	private static void sayHello(){
		HelloWorldService helloWorldService = (HelloWorldService)SpringBeanLoader.getSpringBean("helloWorldService");
		String outString = helloWorldService.sayHello("Afghan!");
		System.out.println(outString);
	}
	
	private static void queryBalanceInfo(){
		HelloWorldService helloWorldService = (HelloWorldService)SpringBeanLoader.getSpringBean("helloWorldService");
		String outString = helloWorldService.queryBalanceInfo("BJLK1000000003900");
		System.out.println(outString);
	}
}
