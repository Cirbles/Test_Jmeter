package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuanshuTest {

	//负数的阶乘
	@Test(expected = Exception.class)
	public void testJiecheng1()throws Exception {
		assertEquals(120, new Suanshu().jiecheng(-5));
		//new Suanshu().jiecheng(44);
	}
	
	//正整数的阶乘
	@Test
	public void testJiecheng2()throws Exception {
		assertEquals(120, new Suanshu().jiecheng(5));
		//new Suanshu().jiecheng(44);
	}
	
	//0的阶乘
	@Test
	public void testJiecheng3()throws Exception {
		assertEquals(1, new Suanshu().jiecheng(0));
		//new Suanshu().jiecheng(44);
	}
}
