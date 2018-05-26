package com.vw.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.vw.dto.Product;

public class RecentProductsXlsView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Product> products = null;
		HSSFSheet wSheet = null;

		products = (List<Product>) model.get("products");
		wSheet = wBook.createSheet("products");
		for (int row = 0; row < products.size(); row++) {
			HSSFRow hssfRow = wSheet.createRow(row);
			HSSFCell cell0 = hssfRow.createCell(0);
			HSSFCell cell1 = hssfRow.createCell(1);
			cell0.setCellValue(products.get(row).getProductNo());
			cell1.setCellValue(products.get(row).getProductName());
		}
	}

}





