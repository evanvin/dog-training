package com.haywood.dog.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haywood.dog.config.HaywoodConstants;
import com.haywood.dog.forms.LoginForm;
import com.haywood.dog.service.AuthenticationService;



@Controller
public class BaseController {

	@Autowired
	private AuthenticationService authenticationService;
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		
		/*		
		

		
		String password = "P@$$";
		password = authenticationService.generateHash(password);
		
		User user = new User("admin", password, "Haywood");

		// save
		mongoOperation.save(user);

		// now user object got the created id.
		System.out.println("1. user : " + user);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is("mkng"));

		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoOperation.updateFirst(searchUserQuery,
	                         Update.update("password", "new password"),User.class);

		// find the updated user object
		User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
		//mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());

		*/

		
		return new ModelAndView(HaywoodConstants.VIEW_LOGIN, "loginForm", new LoginForm());
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		//TODO: do security
		return new ModelAndView(HaywoodConstants.VIEW_HOME);
	}
	

}
