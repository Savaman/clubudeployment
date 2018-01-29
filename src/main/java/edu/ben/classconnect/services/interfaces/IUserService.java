package edu.ben.classconnect.services.interfaces;

import edu.ben.classconnect.entities.User;

public interface IUserService {
	
	boolean registerNewUserAccount(User user);
	
	void deactivateUserAccount(User user);

}
