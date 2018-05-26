package com.bf.loan;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.il.dto.LoanApplication;
import com.il.dto.LoanDetails;
import com.il.facade.LoanService;

public class LoanManager {
	public LoanDetails applyLoan(LoanApplication loanApplication) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(1099);
		LoanService loanService = (LoanService) registry.lookup("loanService");

		LoanDetails loanDetails = loanService.applyLoan(loanApplication);
		return loanDetails;
	}
}
