package com.bse.broker;

import java.rmi.Remote;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(targetNamespace = "http://broker.bse.com/")
public interface StockAgentPortType extends Remote {
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    public float getPrice(@WebParam(name = "stockName") String stockName);
}
