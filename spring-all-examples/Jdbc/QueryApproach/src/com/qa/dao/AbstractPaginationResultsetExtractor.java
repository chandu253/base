package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class AbstractPaginationResultsetExtractor implements ResultSetExtractor<Object> {
	protected int pageNo;
	protected int pageSize;

	public AbstractPaginationResultsetExtractor(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Object> records = null;
		int startIndex = 0;
		int endIndex = 0;
		int record = 1;

		startIndex = (pageSize * (pageNo - 1)) + 1;
		endIndex = (startIndex + pageSize) - 1;
		records = new ArrayList<Object>(); 
		
		while(rs.next() && record <= endIndex) {
			if(record >= startIndex && record <= endIndex) {
				Object data = mapRow(rs);
				records.add(data);
			}
			record++;
		}

		return records;
	}

	protected abstract Object mapRow(ResultSet rs) throws SQLException;

}
