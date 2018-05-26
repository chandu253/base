package com.client.async.callback;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

import com.client.dto.PackageInfo;

public class NewPackageCallbackHandler implements InvocationCallback<Response> {

	@Override
	public void completed(Response response) {
		PackageInfo packageInfo = null;

		if (response.getStatus() == 200) {
			packageInfo = response.readEntity(PackageInfo.class);
			response.close();
		}
		System.out.println(packageInfo.getAmount());
	}

	@Override
	public void failed(Throwable e) {
		e.printStackTrace();
	}

}
