package com.cgm.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.rest.users.ListUsers;
import com.cgm.rest.users.User;

@Controller
public class LoginController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getLogin(Map model) throws Exception{
		User user = (User) model.get("user");
		
		if(user == null || user.getUsername() == null) {
			model.put("user", new User());
		}
		return new ModelAndView("login");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	protected ModelAndView login(@ModelAttribute("user") User user, HttpServletRequest request){
		
		List<User> userList = ListUsers.users;
		
		for(User u : userList) {
			if(user.getUsername().equals(u.getUsername())) {
				if(user.getPassword().equals(u.getPassword())) {
					request.getSession().setAttribute("LOGGEDIN_USER", user);
					return new ModelAndView("redirect:/loginsuccess");
				}
			}
		}
		
		Map model = new HashMap();
		model.put("message", "Username or Password wrong!");
		
		return new ModelAndView("login", model);
	}
	
	@RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getLoginSuccess() {
		return new ModelAndView("loginsuccess");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getLogout(HttpServletRequest request) {
		request.getSession().setAttribute("LOGGEDIN_USER", null);
		return new ModelAndView("redirect:/");
	}
}
