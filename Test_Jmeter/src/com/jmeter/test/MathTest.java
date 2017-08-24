package com.jmeter.test;

public class MathTest {
	
	public String sayHello() {
		return "hello";
	}
	
	public String sayHelloToPerson(String s) {
		if(s == null || s.equals("")){
			s = "no boday";
			return (new StringBuilder()).append("hello").append(s).toString();
		}else {
			return s;
		}
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	/*public static void main(String[] args) {
		MathTest mathTest = new MathTest();
		System.out.println(mathTest.sum(1, 2));
	}*/
}
