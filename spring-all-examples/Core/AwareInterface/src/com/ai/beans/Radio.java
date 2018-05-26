package com.ai.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Radio implements BeanFactoryAware {
	private IReceiver receiver;
	private BeanFactory factory;

	public Radio() {
		System.out.println("Radio()");
	}

	public void play(int frequency) {
		if (frequency > 0 && frequency <= 100) {
			receiver = factory.getBean("lowFrequencyReceiver", IReceiver.class);
		} else if (frequency > 100 && frequency <= 1000) {
			receiver = factory.getBean("highFrequencyReceiver", IReceiver.class);
		}
		receiver.tune(frequency);
		String info = receiver.receive();
		System.out.println(info);
	}

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("setBeanFactory(factory)");
		this.factory = factory;
	}

}
