package com.bpp.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstanceTrackerBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object object, String beanName) throws BeansException {
		return object;
	}

	@Override
	public Object postProcessAfterInitialization(Object object, String beanName) throws BeansException {
		if (object instanceof EBook || object instanceof Video) {
			Tracker.increment();
		}
		return object;
	}

}
