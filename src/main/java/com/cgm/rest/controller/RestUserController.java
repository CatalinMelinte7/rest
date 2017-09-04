package com.cgm.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.rest.users.ListUsers;
import com.cgm.rest.users.User;

@RestController
public class RestUserController {

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	protected User getUser(@PathVariable int id) throws Exception {
		return ListUsers.getUsers().get(id-1);
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	protected List<String> getMessages() throws Exception{
		return ListUsers.getMessages();
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public User postMessage(@RequestBody String content, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		System.out.println(user.getUsername() + " --- " + content);
		return user;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ModelAndView findUser(@RequestBody String username) {
		List<User> userList = ListUsers.getUsers();
		String user = username.substring(1, username.length() - 1);
		for(int counter = 0; counter < userList.size(); counter++) {
			if(user.equals(userList.get(counter).getUsername())) {
				return new ModelAndView("redirect:/user/" + counter);
			}
		}
		return new ModelAndView("redirect:/");
	}
}
