package com.jmeter.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JavaTest  implements JavaSamplerClient{
	
	private MathTest test = null;
	private String a;//定义入参1
	private String b;//定义入参2
	private String resultData;
	private static long start =0;
	private static long end = 0;
	
	//这个方法是用来定义java入参的
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		//添加指定的值的参数，相当于给map中的key添加value，
		//只不过这里的“ ”是可以通过jmeter的java请求进行入参
		params.addArgument("num1", "");
		params.addArgument("num2", "");
		return params;//把添加的结果返回，这样就可以调用我们的入参了
	}
	
	//每个线程测试前，做一些初始化工作
	public void setupTest(JavaSamplerContext arg0) {
		test = new MathTest();//初始化类MathTest
		a = arg0.getParameter("num1");//获取到手动入参的num1
		b = arg0.getParameter("num2");//获取到手动入参的num2
		start = System.currentTimeMillis();//记录程序开始运行的时间点
	}
	
	//开始测试，从arg0参数可以获得参数值
	public SampleResult runTest(JavaSamplerContext arg0) {
		
		SampleResult sr = new SampleResult();
		//在查看结果树的请求中可以看到，请求中的两个参数
		sr.setSamplerData("请求参数num1：" + a +"\n请求参数num2：" + b);//在查看结果树的请求中输出入参
		try {
			sr.sampleStart();//jmeter开始统计响应时间标记
			//通过下面的操作可以将被测方法的响应输出到jmeter的察看结果树中的响应数据里面了。
			//将a和b强转为int类型，传入被测函数中，并将获取的结果强转为string类型
			resultData = String.valueOf(test.sum(Integer.valueOf(a), Integer.valueOf(b)));
			//如果计算的结果不是空且计算的结果的字符串长度大于0
			if (resultData != null && resultData.length() > 0) {			
				sr.setResponseData("结果是：" + resultData, null);//存入相应数据，为什么要传两个参数，因为一个参数的方法被弃用了
				
				sr.setDataType(SampleResult.TEXT);//？？？？？？？？？？？
				
			}
			Thread.sleep(10);//10毫秒以后往下执行
			System.out.println(resultData);
			sr.setSuccessful(true);
		} catch (Throwable e) {
			// TODO: handle exception
			sr.setSuccessful(false);
			e.printStackTrace();//调查所发生的异常的原因
		}finally {
			sr.sampleEnd();//jmeter结束统计响应标记
		}
		return sr;//返回sr
	}
	
	//测试结束时调用，方法名要固定，这样jmeter才会调到
	public void teardownTest(JavaSamplerContext arg0) {
		end = System.currentTimeMillis();
		//总体耗时
		System.err.println("cost time:" + (end - start) + "毫秒");
	}
	
	/*public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("num1", "1");//设置参数，并赋予默认值1
		params.addArgument("num2", "2");//设置参数，并赋予默认值2
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		JavaTest test = new JavaTest();
		test.setupTest(arg0);
		test.teardownTest(arg0);
	}*/

}
