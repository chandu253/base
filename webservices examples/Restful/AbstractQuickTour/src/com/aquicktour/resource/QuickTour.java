package com.aquicktour.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import com.aquicktour.dto.PackageInfo;
import com.aquicktour.dto.UpgradePackage;

abstract public class QuickTour {
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public StreamingOutput upgradePackage(InputStream in) {
		UpgradePackage upgradePackage = null;
		PackageInfo packageInfo = null;

		upgradePackage = readUpgradePackage(in);
		// business logic in changing the package
		packageInfo = new PackageInfo();
		packageInfo.setOrderNo(upgradePackage.getOrderNo());
		packageInfo.setPackageName(upgradePackage.getPackageName());
		packageInfo.setStatus("upgraded");
		String response = convertPackageInfo(packageInfo);
		return new PackageInfoStreamingOutput(response);
	}

	private final class PackageInfoStreamingOutput implements StreamingOutput {
		private String response;

		public PackageInfoStreamingOutput(String response) {
			this.response = response;
		}

		@Override
		public void write(OutputStream os) throws IOException, WebApplicationException {
			os.write(response.getBytes());
			os.close();
		}

	}

	protected abstract UpgradePackage readUpgradePackage(InputStream in);

	protected abstract String convertPackageInfo(PackageInfo packageInfo);
}
