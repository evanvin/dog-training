package com.haywood.dog.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.haywood.dog.config.SpringMongoConfig;
import com.haywood.dog.dao.User;

@Component
public class AuthenticationService {

	public final String SALT = "DOG-SALT-TEXT";
	
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	
	
	public String generateHash(String input) {
		input = SALT + input;		
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash.toString();
	}
	
	
	public User userExists(String username){
		Query searchUserQuery = new Query(Criteria.where("username").is(username));
		return mongoOperation.findOne(searchUserQuery, User.class);
	}
	
	//public Boolean login(String username)
}
