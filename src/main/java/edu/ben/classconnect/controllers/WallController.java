package edu.ben.classconnect.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ben.classconnect.controllers.security.interfaces.IAuthenticationFacade;
import edu.ben.classconnect.entities.Wall;
import edu.ben.classconnect.services.interfaces.IWallSecurityService;

@Controller
@RequestMapping("/wall")
public class WallController extends BaseController {

	@Autowired
	IAuthenticationFacade auth;

	@Autowired
	IWallSecurityService access;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewWall(@RequestParam("wallName") String wallName, HttpServletRequest request) {

		System.out.println("before authentication");

		if (access.userHasWallAccess(auth.getAuthentication(), wallName)) {
			System.out.println("Inside if statement");
			Wall wall = access.getWall(wallName);

			request.setAttribute("wall", wall);

			request.setAttribute("posts", access.getWallPosts(wall));

			return "wall";

		} else {

			addToMessage("Access Denied.");
			request.setAttribute("message", getMessage());

			return "access-denied";
		}
	}

	@PostMapping("/create")
	public String createWall() {

		return "redirect:/";
	}
}
