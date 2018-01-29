package edu.ben.classconnect.daos.interfaces;

import edu.ben.classconnect.entities.User;

public interface IUserDao extends IGenericDao<User> {

	User getUserByUserName(String userName);

	void insertNewUser(User user) throws NullPointerException;

}
