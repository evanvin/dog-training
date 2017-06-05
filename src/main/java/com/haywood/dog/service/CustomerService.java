package com.haywood.dog.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.haywood.dog.config.SpringMongoConfig;
import com.haywood.dog.dao.Customer;
import com.haywood.dog.forms.CustomerForm;

@Component
public class CustomerService extends GenericService{

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	
	public List<Customer> getAllActiveCustomers() {
		logger.debug(">>> getAllActiveCustomers:ENTERED");		
		Query query = new Query(Criteria.where("isActive").is(true));
		logger.debug(">>> getAllActiveCustomers:EXITED");		
		return mongoOperation.find(query, Customer.class);
	}
	
	public Customer convertFormToCustomer(CustomerForm form){
		Customer customer = new Customer();		
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		customer.setPetName(form.getPetName());
		customer.setEmail(form.getEmail());
		customer.setPhone(form.getPhone());
		customer.setAddressOne(nullCheck(form.getAddressOne()));
		customer.setAddressTwo(nullCheck(form.getAddressTwo()));
		customer.setCity(nullCheck(form.getCity()));
		customer.setZip(nullCheck(form.getZip()));
		customer.setState(nullCheck(form.getState()));
		customer.setPetDOB(nullCheck(form.getPetDOB()));
		customer.setPetDesc(nullCheck(form.getPetDesc()));
		customer.setNotes(nullCheck(form.getNotes()));
		customer.setService(nullCheck(form.getService()));
		if(form.getId() == null || form.getId().equals("")){
			customer.setId(null);
		}
		else{
			customer.setId(form.getId());
		}
		return customer;
	}
	
	
	public void saveOrUpdateCustomer(Customer customer){
		logger.debug(">>> saveOrUpdateCustomer:ENTERED");
		mongoOperation.save(customer);
	}

	public void deactivateCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.updateFirst(query, Update.update("isActive", false), Customer.class);
	}

	public Customer findCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoOperation.findOne(query, Customer.class);
	}

	public CustomerForm getCustomerFormFromCustomer(String id) {
		CustomerForm form = new CustomerForm();
		Customer c = findCustomer(id);
		form.setFirstName(c.getFirstName());
		form.setLastName(c.getLastName());
		form.setPetName(c.getPetName());
		form.setEmail(c.getEmail());
		form.setPhone(c.getPhone());
		form.setAddressOne(nullCheck(c.getAddressOne()));
		form.setAddressTwo(nullCheck(c.getAddressTwo()));
		form.setCity(nullCheck(c.getCity()));
		form.setZip(nullCheck(c.getZip()));
		form.setState(nullCheck(c.getState()));
		form.setPetDOB(nullCheck(c.getPetDOB()));
		form.setPetDesc(nullCheck(c.getPetDesc()));
		form.setNotes(nullCheck(c.getNotes()));
		form.setService(nullCheck(c.getService()));
		form.setId(c.getId());
		return form;
	}

	public void graduateCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.updateFirst(query, Update.update("graduatedDate", new Date()), Customer.class);
		mongoOperation.updateFirst(query, Update.update("graduated", true), Customer.class);
	}

}
