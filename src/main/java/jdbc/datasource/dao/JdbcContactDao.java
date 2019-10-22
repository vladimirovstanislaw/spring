package jdbc.datasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jdbc.Contact;

public class JdbcContactDao implements ContactDao, InitializingBean {

	private DataSource dataSource;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		NamedParameterJdbcTemplate jdbcTemaple = new NamedParameterJdbcTemplate(dataSource);

		MySQLErrorCodesTranslator errorTranslator = new MySQLErrorCodesTranslator();
		this.namedParameterJdbcTemplate = jdbcTemaple;

	}

	@Override
	public String findLastNameById(Long id) {

		return null;

	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}
		if (namedParameterJdbcTemplate == null) {
			throw new BeanCreationException("Null NamedParameterJdbcTemplate on ContactDao");
		}
	}

	@Override
	public String findFirstNameById(Long id) {
		String sql = "select last_name from contact where id = :contactId";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("contactId", id);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);

	}

	@Override
	public List<Contact> findAll() {
		String sql = "select id, first_name, last_name,birth_date from contact";
		return namedParameterJdbcTemplate.query(sql, new ContactMapper());
	}

	private static final class ContactMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}

	}

}
