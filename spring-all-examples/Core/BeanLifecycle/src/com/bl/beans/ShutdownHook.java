package com.bl.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ShutdownHook implements Runnable, BeanFactoryAware {
	private BeanFactory factory;

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}

	@Override
	public void run() {
		((ConfigurableListableBeanFactory) factory).destroySingletons();
	}

}
