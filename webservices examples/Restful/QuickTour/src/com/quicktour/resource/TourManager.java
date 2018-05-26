package com.quicktour.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.quicktour.dto.NewPackage;
import com.quicktour.dto.PackageInfo;

@Path("/tour")
public class TourManager {
	protected Map<String, PackageInfo> userPackages;

	public TourManager() {
		userPackages = new ConcurrentHashMap<>();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput newPackage(InputStream in) throws Exception {
		NewPackage nPackage = null;
		PackageInfo packageInfo = null;
		PackageInfoStreamingOutput piOutput = null;

		try {
			nPackage = readNewPackage(in);
			// business logic
			packageInfo = new PackageInfo();
			packageInfo.setPackageName(nPackage.getPackageName());
			packageInfo.setAmount(3535);
			packageInfo.setComments("granted");
			packageInfo.setStatus("processed");
			packageInfo.setOrderNo(UUID.randomUUID().toString());
			// store in database
			userPackages.put(packageInfo.getOrderNo(), packageInfo);

			piOutput = new PackageInfoStreamingOutput(packageInfo);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw e;
		}
		return piOutput;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getPackageDetails(@QueryParam("order-no") String orderNo) {
		PackageInfo packageInfo = null;
		PackageInfoStreamingOutput piOutput = null;

		if (userPackages.containsKey(orderNo)) {
			packageInfo = userPackages.get(orderNo);
			piOutput = new PackageInfoStreamingOutput(packageInfo);
		}
		return piOutput;
	}

	private NewPackage readNewPackage(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		NewPackage nPackage = null;
		Document doc = null;

		nPackage = new NewPackage();
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		doc = builder.parse(in);
		Node rootNode = doc.getFirstChild();
		NodeList children = rootNode.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			String nodeName = child.getNodeName();
			String nodeValue = child.getFirstChild().getTextContent();

			if (nodeName.equals("package-name")) {
				nPackage.setPackageName(nodeValue);
			} else if (nodeName.equals("person")) {
				nPackage.setPerson(nodeValue);
			} else if (nodeName.equals("mobile")) {
				nPackage.setMobile(nodeValue);
			} else if (nodeName.equals("email-address")) {
				nPackage.setEmailAddress(nodeValue);
			}
		}
		return nPackage;
	}

	private final class PackageInfoStreamingOutput implements StreamingOutput {
		private PackageInfo packageInfo;

		public PackageInfoStreamingOutput(PackageInfo packageInfo) {
			this.packageInfo = packageInfo;
		}

		@Override
		public void write(OutputStream os) throws IOException, WebApplicationException {
			StringBuffer buffer = null;

			buffer = new StringBuffer();
			buffer.append("<package-info>").append("<package-name>").append(packageInfo.getPackageName())
					.append("</package-name>").append("<amount>").append(packageInfo.getAmount()).append("</amount>");
			if (packageInfo.getComments() != null) {
				buffer.append("<comments>").append(packageInfo.getComments()).append("</comments>");
			}
			if (packageInfo.getOrderNo() != null) {
				buffer.append("<order-no>").append(packageInfo.getOrderNo()).append("</order-no>");
			}
			if (packageInfo.getStatus() != null) {
				buffer.append("<status>").append(packageInfo.getStatus()).append("</status>");
			}
			buffer.append("</package-info>");
			os.write(buffer.toString().getBytes());
			os.close();
		}

	}
}
