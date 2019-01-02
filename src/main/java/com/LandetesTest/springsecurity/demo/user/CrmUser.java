package com.LandetesTest.springsecurity.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.LandetesTest.springsecurity.demo.validation.FieldMatch;
import com.LandetesTest.springsecurity.demo.validation.ValidEmail;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match") })

//For our registration form, we are creating a user class with custom details for the
//CRM project. It will have the username, password, first name, last name and email.
//We are also adding annotations for validating the fields

public class CrmUser {

	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String userName;

	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String password;

	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String matchingPassword;

	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String firstName;

	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String lastName;

	@ValidEmail
	@NotNull(message = "campo requerido")
	@Size(min = 1, message = "campo requerido")
	private String email;

	public CrmUser() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
