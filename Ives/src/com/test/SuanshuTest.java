package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuanshuTest {

	@Test(expected = Exception.class)
	public void testJiecheng()throws Exception {
		//assertEquals(120, new Suanshu().jiecheng(4));
		new Suanshu().jiecheng(-4);
	}
}
