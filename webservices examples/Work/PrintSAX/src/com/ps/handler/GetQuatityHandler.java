package com.ps.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetQuatityHandler extends DefaultHandler {
	private int quantity;
	private String lElement;

	@Override
	public void startDocument() throws SAXException {
		quantity = 0;
		lElement = null;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		lElement = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		lElement = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (lElement != null && lElement.equals("quantity")) {
			String data = new String(ch, start, length);
			quantity = quantity + Integer.parseInt(data);
		}
	}

	public int getQuantity() {
		return quantity;
	}

}
