package com.srl.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/care")
public class SamsungCare {
	private MobileCare mobileCare;
	private HomeApplianceCare homeApplianceCare;
	
	
	public SamsungCare() {
		mobileCare = new MobileCare();
		homeApplianceCare = new HomeApplianceCare();
	}


	@Path("/{productType}")
	public Object getProductCare(@PathParam("productType") String productType) {
		if (productType.equals("mobile")) {
			return mobileCare;
		} else if (productType.equals("home-appliances")) {
			return homeApplianceCare;
		}
		return null;
	}
}
