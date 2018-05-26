package com.templatemethod.test;

import java.util.Date;

import com.templatemethod.dto.Document;
import com.templatemethod.dto.LoanInfo;
import com.templatemethod.dto.Member;
import com.templatemethod.dto.WaiverStatus;
import com.templatemethod.pattern.CropWaiverManager;
import com.templatemethod.pattern.WaiverManager;

public class TemplateMethod {
	public static void main(String[] args) {
		WaiverManager waiverManager = new CropWaiverManager();
		LoanInfo loanInfo = new LoanInfo();
		loanInfo.setLoanNo("l938");
		loanInfo.setLoanType("paddy");
		loanInfo.setLoanIssuedDate(new Date());
		loanInfo.setAmount(250000);
		
		Member member=  new Member();
		member.setAdharNo("adhar-001");
		member.setFirstName("mathew");
		member.setLastName("m");
		
		Document document = new Document();
		document.setAssetNo("a938");
		document.setType("crop");
		
		WaiverStatus wStatus = waiverManager.processWaiver(loanInfo, member, document);
		System.out.println(wStatus.getComments());
	}
}









