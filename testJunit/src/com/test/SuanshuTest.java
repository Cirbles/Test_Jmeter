package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuanshuTest {

	//�����Ľ׳�
	@Test(expected = Exception.class)
	public void testJiecheng1()throws Exception {
		assertEquals(120, new Suanshu().jiecheng(-5));
		//new Suanshu().jiecheng(44);
	}
	
	//�������Ľ׳�
	@Test
	public void testJiecheng2()throws Exception {
		assertEquals(120, new Suanshu().jiecheng(5));
		//new Suanshu().jiecheng(44);
	}
	
	//0�Ľ׳�
	@Test
	public void testJiecheng3()throws Exception {
		assertEquals(1, new Suanshu().jiecheng(0));
		//new Suanshu().jiecheng(44);
	}
}