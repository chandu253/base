package com.si.test;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.si.bean.Product;
import com.si.readers.ProductExtractor;

public class SITest {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		ProductExtractor extractor = new ProductExtractor();
		List<Product> products = extractor.extractProducts(
				"D:\\Work\\WebServices\\Master\\WS20170614\\Work\\StaxIterator\\resource\\products.xml");
		System.out.println(products);
	}
}
