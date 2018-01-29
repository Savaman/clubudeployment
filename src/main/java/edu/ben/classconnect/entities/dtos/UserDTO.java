package edu.ben.classconnect.entities.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.ben.classconnect.utils.validators.annotations.PasswordMatch;
import edu.ben.classconnect.utils.validators.annotations.ValidEmail;

@PasswordMatch
public class UserDTO {

	@NotNull(message = "Username is required.")
	@Size(min = 5, message = "Your username must be atleast 5 characters.")
	private String userName;

	@NotNull(message = "First name is required.")
	@Size(min = 1, message = "Your first name must be atleast 1 character.")
	private String firstName;

	@NotNull(message = "Last name is required.")
	@Size(min = 1, message = "Your last name must be atleast 1 character.")
	private String lastName;

	@ValidEmail
	@NotNull(message = "Email is required.")
	@Size(min = 5, message = "Your email must be apart of edu domain.")
	private String email;

	@NotNull(message = "Password is required.")
	@Size(min = 5, message = "Your password must be atleast 8 characters.")
	private String password;

	@NotNull(message = "Confirm is required.")
	private String confirmPassword;

	@NotNull(message = "Please don't change the html loser.")
	private String userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
