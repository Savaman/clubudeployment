package edu.ben.classconnect.controllers.security.interfaces;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
	Authentication getAuthentication();
}
