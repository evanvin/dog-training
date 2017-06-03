package com.haywood.dog.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
		return customer;
	}
	
	
	public void saveCustomer(Customer customer){
		logger.debug(">>> saveCustomer:ENTERED");
		mongoOperation.save(customer);
	}

}
