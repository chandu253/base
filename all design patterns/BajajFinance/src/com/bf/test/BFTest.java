package com.bf.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.bf.loan.LoanManager;
import com.il.dto.LoanApplication;
import com.il.dto.LoanDetails;

public class BFTest {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		LoanApplication loanApplication = null;

		loanApplication = new LoanApplication();
		loanApplication.setApplicationName("Susan");
		loanApplication.setLoanType("Home Loan");
		loanApplication.setTenure(36);
		loanApplication.setLoanAmount(5000000);
		LoanManager loanManager = new LoanManager();
		LoanDetails loanDetails = loanManager.applyLoan(loanApplication);
		System.out.println(loanDetails);
	}

}
