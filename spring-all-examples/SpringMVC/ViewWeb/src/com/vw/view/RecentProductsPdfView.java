package com.vw.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.vw.dto.Product;

public class RecentProductsPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> products = null;
		
		products = (List<Product>) model.get("products");
		Table table = new Table(2);
		table.addCell("Product No");
		table.addCell("Product Name");
		for(Product product : products) {
			table.addCell(String.valueOf(product.getProductNo()));
			table.addCell(product.getProductName());
		}
		document.add(table);
	}

}










