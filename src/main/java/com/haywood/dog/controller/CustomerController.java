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
import org.springframework.web.servlet.ModelAndView;

import com.haywood.dog.config.HaywoodConstants;
import com.haywood.dog.dao.Customer;
import com.haywood.dog.forms.CustomerForm;
import com.haywood.dog.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getcustomers", method = RequestMethod.GET)
	public ModelAndView customerPageShow() {
		ModelAndView mav = new ModelAndView(HaywoodConstants.VIEW_CUSTOMER);
		
		//get current list of customers that are still active
		List<Customer> customers = customerService.getAllActiveCustomers();
		mav.addObject("customers", customers);
		
		//send new customer form
		mav.addObject("customerForm", new CustomerForm());
		
		return mav;
	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveCustomer(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("customerForm")CustomerForm customerForm, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView(HaywoodConstants.REDIRECT_CUSTOMER);
		customerService.saveCustomer(customerService.convertFormToCustomer(customerForm));
		return mav;
	}
	
	
}
