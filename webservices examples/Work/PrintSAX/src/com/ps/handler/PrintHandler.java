package com.ps.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PrintHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("start document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</" + qName + ">");
	}

	@Override
	public void characters(char[] doc, int offSet, int length) throws SAXException {
		String data = new String(doc, offSet, length);
		System.out.print(data);
	}

}
