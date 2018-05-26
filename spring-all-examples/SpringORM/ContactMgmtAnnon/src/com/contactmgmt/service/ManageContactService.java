package com.contactmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contactmgmt.dao.ContactDao;
import com.contactmgmt.entities.Contact;

@Service
public class ManageContactService {
	@Autowired
	private ContactDao contactDao;

	@Transactional(readOnly = false)
	public int saveContact(Contact contact) {
		return contactDao.saveContact(contact);
	}

	@Transactional(readOnly = true)
	public List<Contact> getContacts(String city) {
		return contactDao.getContacts(city);
	}

	@Transactional(readOnly = true)
	public List<Contact> getContactsByName(String contactName) {
		return contactDao.getContactsByName(contactName);
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
