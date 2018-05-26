package com.pd.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class POTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder
				.parse(new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\PrintDom\\resource\\po.xml"));
		
		System.out.println(doc.getFirstChild().getFirstChild().getNextSibling().getNodeName());
		
	}
}








