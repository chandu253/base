package com.templatemethod.pattern;

import com.templatemethod.dto.Document;
import com.templatemethod.dto.LoanInfo;
import com.templatemethod.dto.Member;

public class CropWaiverManager extends WaiverManager {

	@Override
	protected boolean verifyDocument(Document document) {
		if (document.getAssetNo() != null) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isEligibleForWaiveOff(LoanInfo loanInfo) {
		if (loanInfo.getLoanType().equals("paddy")) {
			return true;
		}
		return false;
	}

	@Override
	double getWaiverAmount(LoanInfo loanInfo, Member member) {
		return loanInfo.getAmount() / 2 < 100000 ? loanInfo.getAmount() / 2 : 100000;
	}

}
