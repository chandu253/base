package com.templatemethod.pattern;

import com.templatemethod.dto.Document;
import com.templatemethod.dto.LoanInfo;
import com.templatemethod.dto.Member;

public class HomeWaiverManager extends WaiverManager {

	@Override
	protected boolean verifyDocument(Document document) {
		if (document.getAssetNo() != null) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isEligibleForWaiveOff(LoanInfo loanInfo) {
		if (loanInfo.getLoanType().equals("2bhk")) {
			return true;
		}
		return false;
	}

	@Override
	double getWaiverAmount(LoanInfo loanInfo, Member member) {
		return loanInfo.getAmount() * 0.40 < 50000 ? loanInfo.getAmount() * 0.40 : 50000;
	}

}
