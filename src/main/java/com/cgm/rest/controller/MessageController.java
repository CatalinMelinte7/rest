package com.cgm.rest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.rest.users.Message;

@Controller
public class MessageController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/newmessage", method = RequestMethod.GET)
	protected ModelAndView getMessage(Map model) throws Exception {
		Message message = (Message) model.get("newmessage");
		
		if(message == null || message.getTxt() == null) {
			model.put("newmessage", new Message());
		}
		
		return new ModelAndView("newmessage", model);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/newmessage", method = RequestMethod.POST)
	protected ModelAndView setMesssage(@ModelAttribute("message") Message message, HttpServletRequest request, Map model) {
		model.put("newmessage", new Message());
		return new ModelAndView("redirect:/main", model);
	}
}
