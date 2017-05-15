package com.jmeter;

import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestNum extends AbstractJavaSamplerClient{
		private SampleResult results;
		//��������
		private String inNum;
		//��Ҫƥ�������
		private String resultNum;
		/*
		 *��ʼ����������ʼ�����ܲ��Ե�ÿ���߳�
		 *ʵ������ʱ��ÿ���߳�ִֻ��һ�Σ��ڲ��Է���ִ��ǰִ�� 
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
		
		/*���ô������
		 * �������ö���������õĲ�������ʾ��Jmeter�Ĳ����б���
		 * */
		public Arguments getDefaultParameters() {
			Arguments params = new Arguments();
			params.addArgument("inNum", "");
			params.addArgument("resultNum", "66");
			return params;
		}
		
		public SampleResult runTest(JavaSamplerContext arg0) {
			
			//����һ�������ʾ�����������ʼ��
			results.sampleStart();
			for (int i = inNum.length(); i > 0; --i) {
				
			}
			
			
			//����һ�������ʾ��������Ľ���
			results.sampleEnd();
		}
		
}