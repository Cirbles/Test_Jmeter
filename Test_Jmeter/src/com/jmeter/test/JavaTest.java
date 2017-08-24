package com.jmeter.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JavaTest  implements JavaSamplerClient{
	
	private MathTest test = null;
	private String a;//�������1
	private String b;//�������2
	private String resultData;
	private static long start =0;
	private static long end = 0;
	
	//�����������������java��ε�
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		//����ָ����ֵ�Ĳ������൱�ڸ�map�е�key����value��
		//ֻ��������ġ� ���ǿ���ͨ��jmeter��java����������
		params.addArgument("num1", "");
		params.addArgument("num2", "");
		return params;//�����ӵĽ�����أ������Ϳ��Ե������ǵ������
	}
	
	//ÿ���̲߳���ǰ����һЩ��ʼ������
	public void setupTest(JavaSamplerContext arg0) {
		test = new MathTest();//��ʼ����MathTest
		a = arg0.getParameter("num1");//��ȡ���ֶ���ε�num1
		b = arg0.getParameter("num2");//��ȡ���ֶ���ε�num2
		start = System.currentTimeMillis();//��¼����ʼ���е�ʱ���
	}
	
	//��ʼ���ԣ���arg0�������Ի�ò���ֵ
	public SampleResult runTest(JavaSamplerContext arg0) {
		
		SampleResult sr = new SampleResult();
		//�ڲ鿴������������п��Կ����������е���������
		sr.setSamplerData("�������num1��" + a +"\n�������num2��" + b);//�ڲ鿴�������������������
		try {
			sr.sampleStart();//jmeter��ʼͳ����Ӧʱ����
			//ͨ������Ĳ������Խ����ⷽ������Ӧ�����jmeter�Ĳ쿴������е���Ӧ���������ˡ�
			//��a��bǿתΪint���ͣ����뱻�⺯���У�������ȡ�Ľ��ǿתΪstring����
			resultData = String.valueOf(test.sum(Integer.valueOf(a), Integer.valueOf(b)));
			//�������Ľ�����ǿ��Ҽ���Ľ�����ַ������ȴ���0
			if (resultData != null && resultData.length() > 0) {			
				sr.setResponseData("����ǣ�" + resultData, null);//������Ӧ���ݣ�ΪʲôҪ��������������Ϊһ�������ķ�����������
				
				sr.setDataType(SampleResult.TEXT);//����������������������
				
			}
			Thread.sleep(10);//10�����Ժ�����ִ��
			System.out.println(resultData);
			sr.setSuccessful(true);
		} catch (Throwable e) {
			// TODO: handle exception
			sr.setSuccessful(false);
			e.printStackTrace();//�������������쳣��ԭ��
		}finally {
			sr.sampleEnd();//jmeter����ͳ����Ӧ���
		}
		return sr;//����sr
	}
	
	//���Խ���ʱ���ã�������Ҫ�̶�������jmeter�Ż����
	public void teardownTest(JavaSamplerContext arg0) {
		end = System.currentTimeMillis();
		//�����ʱ
		System.err.println("cost time:" + (end - start) + "����");
	}
	
	/*public static void main(String[] args) {
		Arguments params = new Arguments();
		params.addArgument("num1", "1");//���ò�����������Ĭ��ֵ1
		params.addArgument("num2", "2");//���ò�����������Ĭ��ֵ2
		JavaSamplerContext arg0 = new JavaSamplerContext(params);
		JavaTest test = new JavaTest();
		test.setupTest(arg0);
		test.teardownTest(arg0);
	}*/

}