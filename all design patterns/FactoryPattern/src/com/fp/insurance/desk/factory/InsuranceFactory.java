package com.fp.insurance.desk.factory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fp.provider.AthenaInsurance;
import com.fp.provider.Insurance;
import com.fp.provider.UhgInsurance;

public class InsuranceFactory {
	public static Insurance newInsurance(String provider) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document doc = null;
		Insurance insurance = null;
		int hospitalNo = 0;
		String hospitalName = null;
		String partnerCode = null;

		try {
			if (provider != null) {
				factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
				doc = builder
						.parse(InsuranceFactory.class.getClassLoader().getResourceAsStream("yashoda-insurance.xml"));
				Node insurancePartner = doc.getFirstChild();
				NodeList nList = insurancePartner.getChildNodes();
				for (int i = 0; i < nList.getLength(); i++) {
					Node child = nList.item(i).getNextSibling();
					if (child != null && child.getFirstChild() != null ) {
						String nValue = child.getFirstChild().getNodeValue();
						if (nValue != null) {
							if (child.getNodeName().equals("hospital-no")) {
								hospitalNo = Integer.parseInt(nValue);
							} else if (child.getNodeName().equals("hospital-name")) {
								hospitalName = nValue;
							} else if (child.getNodeName().equals("partner-code")) {
								partnerCode = nValue;
							}
						}
					}
				}
				if (provider.equals("uhg")) {
					insurance = new UhgInsurance(hospitalNo, hospitalName, partnerCode);
				} else if (provider.equals("athena")) {
					insurance = new AthenaInsurance(hospitalNo, hospitalName, partnerCode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insurance;
	}
}
