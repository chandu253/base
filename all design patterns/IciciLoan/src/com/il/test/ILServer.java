package com.il.test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.il.facade.LoanServiceImpl;

public class ILServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		LoanServiceImpl loanService = new LoanServiceImpl();
		Registry registry = LocateRegistry.createRegistry(1099);
		Remote obj = UnicastRemoteObject.exportObject(loanService);
		//Registry registry = LocateRegistry.getRegistry();
		registry.bind("loanService", obj);
	}

}








