package com.bse.sec.exchange;

import java.rmi.Remote;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://exchange.sec.bse.com/")
public interface StockAgentPortType extends Remote {
    @WebMethod
    public float getStockPrice(@WebParam(name = "arg0") String stockName);
}
