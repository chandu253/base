package com.client.async.invoker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import com.client.async.callback.NewPackageCallbackHandler;
import com.client.dto.NewPackage;
import com.client.dto.PackageInfo;

public class TourManager {
	private final String TOUR_MANAGER_URI = "http://localhost:8082/QuickTour/api/tour";

	public PackageInfo newPackage(NewPackage newPackage) throws InterruptedException, ExecutionException {
		Future<Response> future = null;
		Response response = null;
		PackageInfo packageInfo = null;

		future = ClientBuilder.newClient().target(TOUR_MANAGER_URI).request().async().post(Entity.xml(newPackage));
		System.out.println("some work");

		// block and polling
		while (future.isDone() == false)
			;
		// once response available then execute the below lines of code
		response = future.get();
		if (response.getStatus() == 200) {
			packageInfo = response.readEntity(PackageInfo.class);
		}

		return packageInfo;
	}

	public void newPackageCallback(NewPackage newPackage) throws InterruptedException, ExecutionException {
		PackageInfo packageInfo = null;
		NewPackageCallbackHandler handler = null;

		handler = new NewPackageCallbackHandler();
		ClientBuilder.newClient().target(TOUR_MANAGER_URI).request().async().post(Entity.xml(newPackage), handler);
		System.out.println("some work");

	}

}








