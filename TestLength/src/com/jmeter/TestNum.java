package com.jmeter;

import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestNum extends AbstractJavaSamplerClient{
		private SampleResult results;
		//输入数字
		private String inNum;
		//需要匹配的数字
		private String resultNum;
		/*
		 *初始化方法，初始化性能测试的每个线程
		 *实际运行时，每个线程只执行一次，在测试方法执行前执行 
		 */
		public void setupTest(JavaSamplerContext jsc) {
			results = new SampleResult();
			inNum = jsc.getParameter("inNum", "");
			resultNum = jsc.getParameter("resultNum", "");
			
			if (inNum != null && inNum.length() > 0) {
				results.setSamplerData(inNum);
			}
			if (resultNum != null && resultNum.length() > 0) {
				results.setSamplerData(resultNum);
			}
		}
		
		/*设置传入参数
		 * 可以设置多个，已设置的参数会显示到Jmeter的参数列表中
		 * */
		public Arguments getDefaultParameters() {
			Arguments params = new Arguments();
			params.addArgument("inNum", "");
			params.addArgument("resultNum", "66");
			return params;
		}
		
		public SampleResult runTest(JavaSamplerContext arg0) {
			
			//定义一个事物，表示这是事物的起始点
			results.sampleStart();
			for (int i = inNum.length(); i > 0; --i) {
				
			}
			
			
			//定义一个事物，表示这是事物的结束
			results.sampleEnd();
		}
		
}
