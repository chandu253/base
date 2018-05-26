package com.bl.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Rocket implements BeanFactoryAware, InitializingBean, DisposableBean {
	private int threshold;
	private int level;
	private double distance;

	public Rocket(int threshold) {
		System.out.println("Rocket(threshold)");
		this.threshold = threshold;
	}

	public void prepare() {
		System.out.println("prepare()");
	}

	public void setLevel(int level) {
		System.out.println("setLevel(level)");
		this.level = level;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroying...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		distance = threshold * level;
	}

	public void release() {
		System.out.println("release()");
	}

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("setBeanFactory(factory)");
	}

	@Override
	public String toString() {
		return "Rocket [threshold=" + threshold + ", level=" + level + ", distance=" + distance + "]";
	}

}
