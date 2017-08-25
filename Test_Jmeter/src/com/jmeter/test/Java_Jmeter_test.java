package com.jmeter.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Java_Jmeter_test extends JavaSamplerContext{
	
	public Java_Jmeter_test(Arguments args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}
	
}
