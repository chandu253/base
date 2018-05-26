package com.ep.beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

// role - source
public class EditCityController implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	public void updateCity(int cityId, String cityName) {
		System.out.println("updated tblCities table");
		ReloadEvent event = new ReloadEvent(this, "tblCities");
		publisher.publishEvent(event);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
