package com.test;

public class Suanshu {
	
	public int jiecheng(int n) throws Exception {
		if(n < 0){
			throw new Exception("负数没有阶乘！！！");
		}else if (n == 0) {
			return 1;
		}else {
			return n*jiecheng(n-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new Suanshu().jiecheng(-1));
	}

}
