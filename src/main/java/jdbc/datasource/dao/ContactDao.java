package jdbc.datasource.dao;

import java.util.List;

import jdbc.Contact;

public interface ContactDao {

	String findLastNameById(Long id);

	String findFirstNameById(Long id);

	List<Contact> findAll();
}
