package com.client.test;

import java.util.concurrent.ExecutionException;

import com.client.async.invoker.TourManager;
import com.client.dto.NewPackage;
import com.client.dto.PackageInfo;

public class NewPackageTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TourManager tourManager = new TourManager();
		NewPackage np = new NewPackage();
		np.setPackageName("p1");
		np.setPerson("john");
		np.setMobile("394945");
		np.setEmailAddress("john@gmail.com");

		tourManager.newPackageCallback(np);
		//System.out.println(pi.getPackageName());

	}

}
