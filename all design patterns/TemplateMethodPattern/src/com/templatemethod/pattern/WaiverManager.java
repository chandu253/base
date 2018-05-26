package com.templatemethod.pattern;

import com.templatemethod.dto.Document;
import com.templatemethod.dto.LoanInfo;
import com.templatemethod.dto.Member;
import com.templatemethod.dto.WaiverStatus;

public abstract class WaiverManager {
	/* template method with algorithm */
	public WaiverStatus processWaiver(LoanInfo loanInfo, Member member, Document document) {
		WaiverStatus wStatus = null;

		wStatus = new WaiverStatus();
		wStatus.setLoanNo(loanInfo.getLoanNo());
		if (validateLoan(loanInfo) == false) {
			wStatus.setStatus("rejected");
			wStatus.setComments("Loan not eligible for Waiver");
		} else {
			if (verifyMember(member) == false) {
				wStatus.setStatus("rejected");
				wStatus.setComments("member identity mis-match");
			} else {
				if (verifyDocument(document) == false) {
					wStatus.setStatus("rejected");
					wStatus.setComments("asset verification failed");
				} else {
					if (isEligibleForWaiveOff(loanInfo) == false) {
						wStatus.setStatus("rejected");
						wStatus.setComments("not eligible for waiver");
					} else {
						double amount = getWaiverAmount(loanInfo, member);
						releaesFunds(loanInfo, amount);
						wStatus.setStatus("processed");
						wStatus.setComments("amount of : " + amount + " has been paid to your loan");
					}
				}
			}
		}

		return wStatus;
	}

	public boolean validateLoan(LoanInfo loanInfo) {
		if (loanInfo.getLoanNo() != null) {
			return true;
		}
		return false;
	}

	public boolean verifyMember(Member member) {
		if (member.getAdharNo() != null) {
			if (member.getAdharNo().equals("adhar-001") && member.getFirstName().equals("mathew")
					&& member.getLastName().equals("m")) {
				return true;
			}
		}
		return false;
	}

	abstract protected boolean verifyDocument(Document document);

	abstract protected boolean isEligibleForWaiveOff(LoanInfo loanInfo);

	abstract double getWaiverAmount(LoanInfo loanInfo, Member member);

	public void releaesFunds(LoanInfo loanInfo, double amount) {
		System.out.println("amount of : " + amount + " has been paid to your loan : " + loanInfo.getLoanNo());
	}
}
