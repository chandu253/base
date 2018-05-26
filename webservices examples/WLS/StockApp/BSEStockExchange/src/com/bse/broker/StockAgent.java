package com.bse.broker;

import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(endpointInterface = "com.bse.broker.StockAgentPortType")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class StockAgent {
    public float getPrice(String stockName) {
        return 353.34f;
    }
}
