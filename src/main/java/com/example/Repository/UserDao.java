package com.example.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User> USER_ROW_MAPPER
	= (rs,i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setAddress(rs.getString("address"));
		return user;
	};
	
	

}
