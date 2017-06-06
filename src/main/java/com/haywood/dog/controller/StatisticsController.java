package com.haywood.dog.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haywood.dog.config.HaywoodConstants;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(StatisticsController.class);
	
	@RequestMapping(value = "/getstatistics", method = RequestMethod.GET)
	public ModelAndView calendarPageShow() {
		ModelAndView mav = new ModelAndView(HaywoodConstants.VIEW_STATISTICS);
		
		
		
		return mav;
	}
}
