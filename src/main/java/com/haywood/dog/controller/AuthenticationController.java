package com.haywood.dog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haywood.dog.config.HaywoodConstants;
import com.haywood.dog.dao.User;
import com.haywood.dog.forms.LoginForm;
import com.haywood.dog.service.AuthenticationService;



@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;

	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("loginForm")LoginForm loginForm, BindingResult result, Model model) {
    	logger.debug(">>> doLogin:ENTERED");
    	ModelAndView mav = new ModelAndView(HaywoodConstants.VIEW_HOME);
    	
    	if (result.hasErrors()) {
    		for(FieldError err : result.getFieldErrors()){
    			mav.addObject(err.getField()+"ErrorClass", "invalid");
    			mav.addObject(err.getField()+"Error", "Please enter a " + err.getField());
    		}
    		logger.debug(">>> doLogin:EXITED WITH ERRORS");
    		mav.setViewName(HaywoodConstants.VIEW_LOGIN);
    		return mav;
        }
    	
    	
    	User user = authenticationService.userExists(loginForm.getUsername());
    	String saltedPass = authenticationService.generateHash(loginForm.getPassword());
    	
    	if(user == null || !saltedPass.equals(user.getPassword())){
    		mav.addObject("loginError", "Username or password is incorrect");
    		mav.setViewName(HaywoodConstants.VIEW_LOGIN);
    		return mav;
    	}
    	
    	mav.addObject("usersName", user.getName());
    	logger.debug(">>> doLogin:EXITED");
    	return mav;
	}
}
