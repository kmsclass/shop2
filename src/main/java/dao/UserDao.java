package dao;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import logic.User;

public class UserDao {
	private NamedParameterJdbcTemplate template;
	private RowMapper<User> mapper = 
		    new BeanPropertyRowMapper<User>(User.class);

	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insert(User user) {
		//파라미터 :userid => user 객체의 userid 프로퍼티로 설정
		//파라미터와 user 객체의 프로퍼티를 연결하여 설정
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into useraccount "
+"(userid, username, password,birthday, phoneno, postcode,address,email)"
+" values (:userid,:username,:password,:birthday,:phoneno,:postcode,:address,:email)";
        template.update(sql, param);		
	}

	public User selectOne(String userid) {
		Map<String,String> param = new HashMap<>();
		param.put("userid", userid);
		return template.queryForObject 
		("select * from useraccount where userid=:userid",param,mapper);
	}
}
