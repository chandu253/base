package com.il.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.il.dto.LoanApplication;
import com.il.dto.LoanDetails;

public interface LoanService extends Remote {
	LoanDetails applyLoan(LoanApplication loanApplication) throws RemoteException;
}
