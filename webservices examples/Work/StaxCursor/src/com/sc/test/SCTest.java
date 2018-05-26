package com.sc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.sc.bean.Address;

public class SCTest {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		String tag = null;
		String data = null;
		Address address = null;

		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(
				new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\StaxCursor\\resources\\address.xml")));
		address = new Address();

		while (reader.hasNext()) {
			int event = reader.next();
			if (event == XMLStreamReader.START_ELEMENT) {
				tag = reader.getLocalName();
				data = getData(reader);
				
				if (tag.equals("addressLine1")) {
					address.setAddressLine1(data);
				} else if (tag.equals("addressLine2")) {
					address.setAddressLine2(data);
				}else if(tag.equals("city")) {
					address.setCity(data);
				}else if(tag.equals("state")) {
					address.setState(data);
				}else if(tag.equals("zip")) {
					address.setZip(data);
				}else if(tag.equals("country")) {
					address.setCountry(data);
				}
			}
		}
		
		System.out.println(address);
	}

	private static String getData(XMLStreamReader reader) throws XMLStreamException {
		String data = null;

		reader.next();
		data = reader.getText();
		return data;
	}

}
