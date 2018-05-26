package com.il.facade;

import java.rmi.RemoteException;

import com.il.bo.Application;
import com.il.bo.Loan;
import com.il.bo.LoanDocument;
import com.il.businessobjects.LoanApplicationService;
import com.il.businessobjects.LoanManager;
import com.il.dto.LoanApplication;
import com.il.dto.LoanDetails;

public class LoanServiceImpl implements LoanService {
	/**
	 * Workflow and interactions with sub-system components are taken care by facade
	 */
	@Override
	public LoanDetails applyLoan(LoanApplication loanApplication) throws RemoteException {
		LoanApplicationService loanApplicationService = null;
		Application application = null;
		LoanDocument ldocument = null;
		LoanDetails loanDetails = null;
		LoanManager loanManager = null;
		Loan loan = null;

		application = new Application();
		application.setApplicantName(loanApplication.getApplicationName());
		application.setLoanType(loanApplication.getLoanType());
		application.setLoanAmount(loanApplication.getLoanAmount());
		application.setTenure(loanApplication.getTenure());

		loanApplicationService = new LoanApplicationService();
		ldocument = loanApplicationService.applyLoan(application);
		loanManager = new LoanManager();
		loan = loanManager.process(ldocument);

		loanDetails = new LoanDetails();
		loanDetails.setApplicantName(loan.getApplicantName());
		loanDetails.setLoanNo(loan.getLoanNo());
		loanDetails.setLoanType(loan.getLoanType());
		loanDetails.setIssuedLoanAmount(loan.getIssuedLoanAmount());
		loanDetails.setStatus(loan.getStatus());

		return loanDetails;
	}

}
