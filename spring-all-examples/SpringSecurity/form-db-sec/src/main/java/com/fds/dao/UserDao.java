package com.fds.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fds.bo.Role;
import com.fds.bo.User;

@Repository
public class UserDao {
	private final String SQL_GET_USER_DETAILS = "select u.*, r.* from users u inner join roles r on u.role_id = r.role_id where u.username = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User findUser(String username) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_DETAILS, new Object[] { username }, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User user = new User();
				user.setUserNo(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				Role role = new Role(rs.getInt("role_id"), rs.getString("role_nm"));
				user.setUserRole(role);
				return user;
			}
		});
	}
}
