package com.dt.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTraversalTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder
				.parse(new File("D:\\Work\\WebServices\\Master\\WS20170614\\Work\\DomTraversal\\resources\\po.xml"));
		printNode(doc);
	}

	private static void printNode(Node node) {
		switch (node.getNodeType()) {
		case Node.DOCUMENT_NODE:
			printNode(node.getFirstChild());
			break;
		case Node.ELEMENT_NODE:
			System.out.print("<" + node.getNodeName() + ">");
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				printNode(child);
			}
			System.out.println("</" + node.getNodeName() + ">");
			break;
		case Node.TEXT_NODE:
			System.out.print(node.getNodeValue());
			break;
		}
	}
}




