package com.asf.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asf.bo.ConsignmentBo;
import com.asf.bo.ContactBo;
import com.asf.dao.ConsignmentDao;
import com.asf.dto.Consignment;
import com.asf.form.ConsignmentForm;

@Service
public class ConsignmentService {
	@Autowired
	private ConsignmentDao consignmentDao;

	@Transactional(readOnly = false)
	public Consignment createConsignment(ConsignmentForm form) {
		ContactBo fromContact;
		ContactBo toContact;
		ConsignmentBo consignmentBo = null;
		Consignment consignment = null;
		int consignmentNo = 0;

		fromContact = new ContactBo();
		fromContact.setContactName(form.getFromContactName());
		fromContact.setAddressLine1(form.getFromAddressLine1());
		fromContact.setAddressLine2(form.getFromAddressLine2());
		fromContact.setCity(form.getFromCity());
		fromContact.setState(form.getFromState());
		fromContact.setZip(form.getFromZip());
		fromContact.setCountry(form.getFromCountry());
		fromContact.setMobile(form.getFromMobile());

		toContact = new ContactBo();
		toContact.setContactName(form.getToContactName());
		toContact.setAddressLine1(form.getToAddressLine1());
		toContact.setAddressLine2(form.getToAddressLine2());
		toContact.setCity(form.getToCity());
		toContact.setState(form.getToState());
		toContact.setZip(form.getToZip());
		toContact.setCountry(form.getToCountry());
		toContact.setMobile(form.getToMobile());

		consignmentBo = new ConsignmentBo();
		consignmentBo.setConsignmentDate(new Date());
		consignmentBo.setDescription(form.getDescription());
		consignmentBo.setShipmentType(form.getShipmentType());
		consignmentBo.setWeight(form.getWeight());
		consignmentBo.setAmount(form.getAmount());
		consignmentBo.setFromContact(fromContact);
		consignmentBo.setToContact(toContact);

		consignmentNo = consignmentDao.createConsignment(consignmentBo);
		consignment = new Consignment();
		consignment.setConsignmentNo(consignmentNo);
		consignment.setEstimatedDeliveryDate(new Date());
		consignment.setMessage("Your consignment has been accepted");

		return consignment;
	}

}
