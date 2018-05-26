package com.mr.beans;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FindPlansReplacer implements MethodReplacer {
	@Override
	public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("findPlans")) {
			int age = 0;
			int zipCode = 0;
			String gender = null;
			int networkType = 0;
			int coverageType = 0;
			int copay = 0;

			age = (Integer) args[0];
			zipCode = (Integer) args[1];
			gender = (String) args[2];
			networkType = (Integer) args[3];
			coverageType = (Integer) args[4];
			copay = (Integer) args[5];

			System.out.println("age : " + age + " zipCode : " + zipCode + " gender : " + gender + " networkType : "
					+ networkType + " coverageType : " + coverageType + " copay : " + copay);
			System.out.println("computing the plans");
			return new String[] { "medicalPlan1", "medicalPlan2" };
		}
		throw new Exception("method not supported : " + method.getName() + " for replacing");
	}

}






