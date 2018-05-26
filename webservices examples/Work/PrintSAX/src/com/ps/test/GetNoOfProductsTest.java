package com.ps.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.ps.handler.GetNoOfProductsPoHandler;

public class GetNoOfProductsTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		GetNoOfProductsPoHandler handler = new GetNoOfProductsPoHandler();

		parser.parse(new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\PrintSAX\\resource\\po.xml"), handler);
		System.out.println("products : " + handler.getProducts());

		parser.parse(
				new File(
						"D:\\\\Work\\\\WebServices\\\\Master\\\\WS20170614\\\\Work\\\\PrintSAX\\\\resource\\\\po2.xml"),
				handler);
		System.out.println("Products : " + handler.getProducts());
	}
}


