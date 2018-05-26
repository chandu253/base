package com.ps.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetNoOfProductsPoHandler extends DefaultHandler {
	private int products;

	@Override
	public void startDocument() throws SAXException {
		products = 0;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null && qName.equals("item")) {
			products++;
		}
	}

	public int getProducts() {
		return products;
	}

}
