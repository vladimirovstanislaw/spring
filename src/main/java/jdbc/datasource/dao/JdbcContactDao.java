package jdbc.datasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jdbc.Contact;
import jdbc.ContactTelDetail;

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

	@Override
	public List<Contact> findAllWithDetail() {
		String sql = "select c.id, c.first_name,c.last_name, c.birth_date, t.id as contact_tel_id, t.tel_type, t.tel_number from contact c left join contact_tel_detail t on c.id = t.contact_id";

		return namedParameterJdbcTemplate.query(sql, new ContactWithDetailExtractor());
	}

	private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

		@Override
		public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Long, Contact> map = new HashMap<Long, Contact>();
			Contact contact = null;

			while (rs.next()) {
				Long id = rs.getLong("id");
				contact = map.get(id);

				if (contact == null) {
					contact = new Contact();
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					map.put(id, contact);
				}
				Long contactTelDetailId = rs.getLong("contact_tel_id");
				if (contactTelDetailId > 0) {
					ContactTelDetail contactTelDetail = new ContactTelDetail();
					contactTelDetail.setId(contactTelDetailId);
					contactTelDetail.setContactId(id);
					contactTelDetail.setTelType(rs.getString("tel_type"));
					contactTelDetail.setTelNumber(rs.getString("tel_number"));
					contact.getContactTelDetails().add(contactTelDetail);
				}
			}
			return new ArrayList<Contact>(map.values());
		}

	}

}
