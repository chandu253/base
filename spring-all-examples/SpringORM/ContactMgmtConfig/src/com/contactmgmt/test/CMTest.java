package com.contactmgmt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contactmgmt.entities.Contact;
import com.contactmgmt.service.ManageContactService;

public class CMTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/contactmgmt/common/application-context.xml");
		ManageContactService mcService = context.getBean("manageContactService", ManageContactService.class);
		
		/*Contact contact = new Contact();
		contact.setContactName("Blake");
		contact.setAddressLine1("Mithrivanam");
		contact.setAddressLine2("Ameerpet");
		contact.setCity("hyderabad");
		contact.setState("TS");
		contact.setZip(39484);
		contact.setCountry("India");
		contact.setMobileNumber("94849372");
		
		int contactNo = mcService.saveContact(contact);
		System.out.println("contact No : " + contactNo);*/
		
		/*List<Contact> contacts =mcService.getContacts("hyderabad");
		for(Contact contact: contacts) {
			System.out.println(contact);
		}*/
		
		List<Contact> contacts =mcService.getContactsByName("blake");
		for(Contact contact: contacts) {
			System.out.println(contact);
		}
	}
}











