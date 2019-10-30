package spring.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jdbc.Contact;
import jdbc.ContactTelDetail;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

	private Log log = LogFactory.getLog(JdbcContactDao.class);

	private DataSource dataSource;

	private SelectAllContacts selectAllContacts;

	private SelectContactByFirstName selectContactByFirstName;

	private UpdateContact updateContact;

	private InsertContact insertContact;

	private InsertContactTelDetail insertContactTelDetail;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.selectAllContacts = new SelectAllContacts(dataSource);
		this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
		this.updateContact = new UpdateContact(dataSource);
		this.insertContact = new InsertContact(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public List<Contact> findAll() {

		return selectAllContacts.execute();
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", firstName);
		return selectContactByFirstName.executeByNamedParam(paramMap);
	}

	@Override
	public String findFirstNameById(Long id) {

		return null;
	}

	@Override
	public List<Contact> findAllWithDetail() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String sql = "select c.id, c.first_name, c.last_name, c.birth_date, t.id as contact_tel_id, t.tel_type, t.tel_number from contact c left join contact_tel_detail t on c.id=t.contact_id";
		return jdbcTemplate.query(sql, (ResultSet rs) -> {

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
		});
	}

	@Override
	public void insert(Contact contact) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();

		insertContact.updateByNamedParam(paramMap, keyHolder);
		contact.setId(keyHolder.getKey().longValue());

		log.info("New contact inserted with id: " + contact.getId());
	}

	@Override
	public void insertWithDetail(Contact contact) {
		insertContactTelDetail = new InsertContactTelDetail(dataSource);

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();

		insertContact.updateByNamedParam(paramMap, keyHolder);

		contact.setId(keyHolder.getKey().longValue());

		log.info("New contact inserted with id: " + contact.getId());

		List<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();

		if (contactTelDetails != null) {
			for (ContactTelDetail contactTelDetail : contactTelDetails) {
				paramMap = new HashMap<String, Object>();
				paramMap.put("contact_id", contact.getId());
				paramMap.put("tel_type", contactTelDetail.getTelType());
				paramMap.put("tel_number", contactTelDetail.getTelNumber());
				insertContactTelDetail.updateByNamedParam(paramMap);

			}
		}
		insertContactTelDetail.flush();
	}

	@Override
	public void update(Contact contact) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		paramMap.put("id", contact.getId());
		updateContact.updateByNamedParam(paramMap);

		log.info("Existing contact updated with id: " + contact.getId());
	}

}
