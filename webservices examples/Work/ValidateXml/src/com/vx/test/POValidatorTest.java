package com.vx.test;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class POValidatorTest {
	public static void main(String[] args) throws SAXException, IOException {
		SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema poSchema = sfactory.newSchema(new StreamSource(
				new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\ValidateXml\\src\\META-INF\\po.xsd")));

		Validator poSchemaValidator = poSchema.newValidator();

		poSchemaValidator.validate(new StreamSource(
				new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\ValidateXml\\resources\\po.xml")));
		System.out.println("hurray! valid xml");
	}
}
