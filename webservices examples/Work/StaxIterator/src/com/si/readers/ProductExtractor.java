package com.si.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import com.si.bean.Product;

public class ProductExtractor {
	public List<Product> extractProducts(String inPath) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory factory = null;
		XMLEventReader reader = null;
		List<Product> products = null;
		Product product = null;
		String tag = null;
		String data = null;

		factory = XMLInputFactory.newFactory();
		reader = factory.createXMLEventReader(new FileInputStream(new File(inPath)));
		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if (event.isStartElement()) {
				tag = event.asStartElement().getName().getLocalPart();
				if (tag.equals("products")) {
					products = new ArrayList<Product>();
				} else if (tag.equals("product")) {
					product = new Product();
				} else {
					// if child elements
					event = reader.nextEvent();
					if (tag.equals("product-code")) {
						product.setProductCode(event.asCharacters().getData());
					} else if (tag.equals("product-name")) {
						product.setProductName(event.asCharacters().getData());
					} else if (tag.equals("description")) {
						product.setDescription(event.asCharacters().getData());
					} else if (tag.equals("price")) {
						product.setPrice(event.asCharacters().getData());
					}
				}
			} else if (event.isEndElement()) {
				tag = event.asEndElement().getName().getLocalPart();
				if (tag.equals("product")) {
					products.add(product);
				}
			}
		}
		return products;
	}
}
