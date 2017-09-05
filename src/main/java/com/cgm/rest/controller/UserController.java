package com.cgm.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.rest.users.ListUsers;
import com.cgm.rest.users.User;

@Controller
public class UserController {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	protected @ResponseBody ModelAndView getUsers() throws Exception {
			Map model = new HashMap();
			model.put("users", ListUsers.users);
			return new ModelAndView("friends", model);
	}
	/*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/friends", method = RequestMethod.POST)
	protected ModelAndView follow(@ModelAttribute("friend") User friend, HttpServletRequest request, Map model) {
		model.put("friends", new User());
		return new ModelAndView("redirect:/main", model);
	}
	*/
	
	private List<String> friendsMessages(List<String> friends){
		List<String> messages = new ArrayList<String>();
		for(String friend : friends) {
			for(User user : ListUsers.users) {
				if(user.getUsername().equals(friend)) {
					messages.addAll(user.getMessages());
				}
			}
		}
		return messages;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getUserMessages(HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute("LOGGEDIN_USER");
		List<User> users = ListUsers.users;
		if(user != null) {
			Map model = new HashMap();
			model.put("username", user.getUsername());
			for(User u : users) {
				if(u.getUsername().equals(user.getUsername())) {
					model.put("messages", u.getMessages());
					model.put("friends", u.getFriends());
					model.put("friendsMessages", friendsMessages(u.getFriends()));
				}
			}
			return new ModelAndView("main", model);
		} else {
			return new ModelAndView("main");
		}
	}
}
