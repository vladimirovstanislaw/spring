package spring.jdbc;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import jdbc.Contact;
import jdbc.ContactTelDetail;

public class AnnotationJdbcDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/spring-jdbc-embded-db-app-context.xml");
		ctx.refresh();

		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

		List<Contact> contacts = contactDao.findAll();
		listContacts(contacts);

		List<Contact> contactsByName = contactDao.findByFirstName("Chris");
		listContacts(contactsByName);
	}

	public static void listContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
			System.out.println();
		}
	}
}
