package org.apache.commons.beanutils;

import java.util.List;

public class User {
	private String username;
	private String password;
	private String email;
    private List<User> friends;

	public String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    public List<User> getFriends() {
        return friends;
    }

    void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
