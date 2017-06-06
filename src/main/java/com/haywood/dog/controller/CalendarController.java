package com.haywood.dog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.haywood.dog.config.HaywoodConstants;
import com.haywood.dog.dao.Customer;
import com.haywood.dog.dao.TrainingSession;
import com.haywood.dog.forms.CustomerForm;
import com.haywood.dog.forms.SessionForm;
import com.haywood.dog.service.CalendarService;
import com.haywood.dog.service.CustomerService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/getcalendar", method = RequestMethod.GET)
	public ModelAndView calendarPageShow() {
		ModelAndView mav = new ModelAndView(HaywoodConstants.VIEW_CALENDAR);
		
		//get list of future training sessions and sessions that have not been marked complete
		List<TrainingSession> trainingSessions = calendarService.getAllIncompleteTrainingSessions();
		mav.addObject("trainingSessions", trainingSessions);
		
		//get a list of all active non-graduated customers
		List<Customer> customers = customerService.getAllActiveNonGraduatedCustomers();
		mav.addObject("customers", customers);
		
		//send new customer form
		mav.addObject("sessionForm", new SessionForm());
		
		return mav;
	}

	@RequestMapping(value="/savesession", method = RequestMethod.POST)
	public ModelAndView saveCustomer(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("sessionForm")SessionForm sessionForm, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView(HaywoodConstants.REDIRECT_CALENDAR);
		calendarService.saveTrainingSession(sessionForm);
		return mav;
	}
	
	@RequestMapping(value="/getcustomersforchips", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> getCustomersForChips(HttpServletRequest request, HttpServletResponse response) {
		return customerService.getAllActiveNonGraduatedCustomers();
	}
	
}
