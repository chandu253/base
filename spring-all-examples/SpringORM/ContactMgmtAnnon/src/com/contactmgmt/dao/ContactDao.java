package com.contactmgmt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.contactmgmt.entities.Contact;

@Repository
public class ContactDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int saveContact(Contact contact) {
		int contactNo = 0;

		contactNo = (int) hibernateTemplate.save(contact);
		return contactNo;
	}

	public List<Contact> getContacts(String city) {
		return (List<Contact>) hibernateTemplate.find("from Contact c where c.city like ?", city);
	}

	public List<Contact> getContactsByName(String name) {
		return (List<Contact>) hibernateTemplate.findByNamedQuery("byContactName", name);
	}

}
