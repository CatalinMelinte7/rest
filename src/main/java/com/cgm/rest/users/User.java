package com.cgm.rest.users;

import java.util.List;

public class User {

	private String username;
	private String password;
	private String email;
	private List<String> friends;
	private List<String> messages;
	
	public User() {
		
	}
	public User(String u, String p, String e) {
		username = u;
		password = p;
		email = e;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	public void addFriend(String friendName) {
		this.friends.add(friendName);
	}
}
