package com.aquicktour.resource;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Path;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aquicktour.dto.PackageInfo;
import com.aquicktour.dto.UpgradePackage;

@Path("/tour")
public class QuickTourInRegion extends QuickTour {

	@Override
	protected UpgradePackage readUpgradePackage(InputStream in) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document doc = null;
		UpgradePackage up = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(in);
			up = new UpgradePackage();
			Node root = doc.getFirstChild();
			NodeList children = root.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				String nodeName = node.getNodeName();
				String nodeValue = node.getFirstChild().getTextContent();
				if (nodeName.equals("order-no")) {
					up.setOrderNo(nodeValue);
				} else if (nodeName.equals("package-name")) {
					up.setPackageName(nodeValue);
				} else if (nodeName.equals("reason")) {
					up.setReason(nodeValue);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return up;
	}

	@Override
	protected String convertPackageInfo(PackageInfo packageInfo) {
		StringBuilder builder = new StringBuilder();
		builder.append("<package-info><order-no>").append(packageInfo.getOrderNo()).append("</order-no><package-name>")
				.append(packageInfo.getPackageName()).append("</package-name><status>").append(packageInfo.getStatus())
				.append("</status></package-info>");
		return builder.toString();
	}

}
