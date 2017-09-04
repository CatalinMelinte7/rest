package com.cgm.rest.users;

import java.util.ArrayList;
import java.util.List;

public class ListUsers {
	
	public static List<User> getUsers() {
		List<String> friends = new ArrayList<String>();
		List<String> messages = new ArrayList<String>();
		
		List<User> users = new ArrayList<User>();
		User u1 = new User("test", "testpass", "test@yahoo.com");
		User u2 = new User("test123", "test123", "test123@gmail.com");
		User u3 = new User("asdasd", "asdasd", "asdasd@hotmail.ro");
		
		friends.add("test");
		friends.add("test123");
		u1.setFriends(friends);
		u2.setFriends(friends);
		u3.setFriends(friends);
		
		messages.add("First Message");
		messages.add("Second message");
		messages.add("Third message");
		u1.setMessages(messages);
		u2.setMessages(messages);
		u3.setMessages(messages);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		return users;
	}
	
	public static List<String> getMessages(){
		List<User> users = getUsers();
		List<String> messages = new ArrayList<String>();
		for(User u: users) {
			messages.addAll(u.getMessages());
		}
		return messages;
	}
	
}
