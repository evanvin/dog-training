package com.haywood.dog.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.haywood.dog.config.SpringMongoConfig;
import com.haywood.dog.dao.Customer;
import com.haywood.dog.dao.TrainingSession;
import com.haywood.dog.forms.SessionForm;

@Component
public class CalendarService extends GenericService{
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CalendarService.class);
	
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	@Autowired
	private CustomerService customerService;
	
	
	public List<TrainingSession> getAllIncompleteTrainingSessions(){
		Criteria c1 = Criteria.where("isActive").is(true);
		Criteria c2 = Criteria.where("markedComplete").is(false);
		Query query = new Query(new Criteria().andOperator(c1,c2)).with(new Sort(Sort.Direction.ASC, "sessionTime"));
		return mongoOperation.find(query, TrainingSession.class);
	}
	
	public void saveTrainingSession(SessionForm form){
		TrainingSession session = new TrainingSession();
		
		if(form.getCustomerIds().size() > 0){
			List<Customer> customers = new ArrayList<Customer>();
			for(String s : form.getCustomerIds()){
				customers.add(customerService.findCustomer(s));
			}
			session.setCustomers(customers);
		}
		
		if(form.getSessionTime() != null){
			session.setSessionTime(form.getSessionTime());
		}
		
		session.setNotes(nullCheck(form.getNotes()));
		
		mongoOperation.save(session);
	}

}
