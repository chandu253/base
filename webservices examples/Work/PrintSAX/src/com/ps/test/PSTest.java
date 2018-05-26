package com.ps.test;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.ps.handler.PrintHandler;

public class PSTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema poSchema = sfactory.newSchema(new StreamSource(
				new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\PrintSAX\\src\\META-INF\\po.xsd")));

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setSchema(poSchema);
		factory.setValidating(true);
		
		SAXParser parser = factory.newSAXParser();
		PrintHandler handler = new PrintHandler();
		parser.parse(new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\PrintSAX\\resource\\po.xml"), handler);
	}
}
