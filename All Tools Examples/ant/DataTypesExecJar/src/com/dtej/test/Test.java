package com.dtej.test;

import java.sql.SQLException;

import com.dtej.dao.ProjectDao;

public class Test {
	public static void main(String[] args) throws SQLException {
		new ProjectDao().showProjects();
	}
}
