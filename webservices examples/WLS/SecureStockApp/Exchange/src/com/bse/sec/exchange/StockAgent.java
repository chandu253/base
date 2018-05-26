package com.bse.sec.exchange;

import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicy;

@WebService(endpointInterface = "com.bse.sec.exchange.StockAgentPortType")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
@SecurityPolicy(uri = "oracle/wss_username_token_service_policy")
public class StockAgent {
    public float getStockPrice(String stockName) {
        return 353.34f;
    }
}
