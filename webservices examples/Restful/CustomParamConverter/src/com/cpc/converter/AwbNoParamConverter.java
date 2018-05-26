package com.cpc.converter;

import javax.ws.rs.ext.ParamConverter;

import com.cpc.dto.AwbNo;

public class AwbNoParamConverter implements ParamConverter<AwbNo> {

	/**
	 * awbNo - awb1239876 3 digits are branch code last 4 digits refNo
	 */
	@Override
	public AwbNo fromString(String param) {
		int branch = 0;
		int refNo = 0;
		AwbNo awbNo = null;

		branch = Integer.parseInt(param.substring(4, 7));
		refNo = Integer.parseInt(param.substring(7, param.length()));
		awbNo = new AwbNo(branch, refNo);

		return awbNo;
	}

	@Override
	public String toString(AwbNo awbNo) {
		return "awb" + awbNo.getBranch() + "" + awbNo.getRefNo();
	}

}








