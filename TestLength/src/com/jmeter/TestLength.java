package com.jmeter;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.report.core.Sample;
import org.apache.jmeter.samplers.SampleResult;

import com.sun.javafx.logging.Logger;

public class TestLength extends AbstractJavaSamplerClient{
	
	private org.apache.log.Logger log = getLogger();
	private SampleResult results;
	private String testStr;
	
	@Override
	public void setupTest(JavaSamplerContext arg0) {
		
		log.info("execute setupTest...");
		results = new SampleResult();
		testStr = arg0.getParameter(testStr, ¡°¡±);
		if (testStr != null && testStr.length() > 0) {
			results.setSamplerData(testStr);
		}
		
		
	}

	
	
	
	
	
	
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		// TODO Auto-generated method stub
		return null;
	};
	

}
