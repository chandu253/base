package com.ep.beans;

import org.springframework.context.ApplicationListener;

// role - handler
public class ReloadEventListener implements ApplicationListener<ReloadEvent> {

	@Override
	public void onApplicationEvent(ReloadEvent event) {
		System.out.println("reloading data for : " + event.getTableName());
	}
}
