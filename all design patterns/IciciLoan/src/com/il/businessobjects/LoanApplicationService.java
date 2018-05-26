package com.il.businessobjects;

import java.util.Random;

import com.il.bo.Application;
import com.il.bo.LoanDocument;

public class LoanApplicationService {
	public LoanDocument applyLoan(Application application) {
		LoanDocument ldocument = null;

		// validate and apply rules
		ldocument = new LoanDocument();
		ldocument.setLoanApplicationNo(new Random(353).nextInt());
		ldocument.setApplicantName(application.getApplicantName());
		ldocument.setLoanType(application.getLoanType());
		ldocument.setTenure(application.getTenure());
		ldocument.setLoanAmount(application.getLoanAmount());

		return ldocument;
	}
}
