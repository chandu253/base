package com.cpc.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.cpc.converter.AwbNoParamConverter;
import com.cpc.dto.AwbNo;

@Provider
public class CPCParamConverterProvider implements ParamConverterProvider {
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> classType, Type rawType, Annotation[] annotations) {
		ParamConverter<T> paramConverter = null;
		if (classType.isAssignableFrom(AwbNo.class)) {
			paramConverter = (ParamConverter<T>) new AwbNoParamConverter();
		}
		return paramConverter;
	}

}
