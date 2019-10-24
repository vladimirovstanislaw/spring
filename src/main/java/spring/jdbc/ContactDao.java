package spring.jdbc;

import java.util.List;

import jdbc.Contact;

public interface ContactDao {
	List<Contact> findAll();

	List<Contact> findByFirstName(String firstName);

	String findFirstNameById(Long id);

	List<Contact> findAllWithDetail();

	void insert(Contact contact);

	void insertWithDetail(Contact contact);

	void update(Contact contact);
}
