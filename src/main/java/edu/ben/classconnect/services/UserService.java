package edu.ben.classconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ben.classconnect.daos.interfaces.IUserDao;
import edu.ben.classconnect.daos.interfaces.IUserRoleDao;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.UserRoles;
import edu.ben.classconnect.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userRepo;

	@Autowired
	IUserRoleDao roleRepo;

	@Override
	public boolean registerNewUserAccount(User user) {

		try {
			roleRepo.addRoleToUser(user, UserRoles.STUDENT);

			userRepo.insertNewUser(user);

			return true;
		} catch (NullPointerException e) {
			System.out.println("UserService-Error while registering new user");
			return false;

		}

	}

	@Override
	public void deactivateUserAccount(User user) {

	}

}
