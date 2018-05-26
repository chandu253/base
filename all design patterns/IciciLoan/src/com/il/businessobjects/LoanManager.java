package com.il.businessobjects;

import java.util.Random;

import com.il.bo.Loan;
import com.il.bo.LoanDocument;

public class LoanManager {
	public Loan process(LoanDocument ldocument) {
		Loan loan = null;

		loan = new Loan();
		loan.setLoanApplicationNo(ldocument.getLoanApplicationNo());
		loan.setLoanNo(new Random(353).nextInt());
		loan.setApplicantName(ldocument.getApplicantName());
		loan.setLoanType(ldocument.getLoanType());
		loan.setIssuedLoanAmount(ldocument.getLoanAmount());
		loan.setStatus("approved");

		return loan;
	}
}
