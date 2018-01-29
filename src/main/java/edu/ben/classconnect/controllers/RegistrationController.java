package edu.ben.classconnect.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.dtos.UserDTO;
import edu.ben.classconnect.services.interfaces.IUserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	IUserService service;

	@GetMapping("/")
	public String showForm(Model theModel) {

		theModel.addAttribute("user", new UserDTO());

		return "registration";
	}

	@PostMapping("/")
	public String processForm(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		} else {
			if (createUserAccount(userDTO)) {
				return "registration-success";
			} else {
				return "registration";
			}
		}
	}

	private boolean createUserAccount(UserDTO userDTO) {
		User user = new User();

		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setCreatedBy("System");
		user.setUpdatedBy("System");
		user.setActive(1);
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());

		return service.registerNewUserAccount(user);
	}

}
