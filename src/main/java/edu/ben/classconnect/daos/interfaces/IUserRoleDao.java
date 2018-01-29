package edu.ben.classconnect.daos.interfaces;

import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.UserRole;
import edu.ben.classconnect.entities.UserRoles;

public interface IUserRoleDao extends IGenericDao<UserRole> {
	void addRoleToUser(User user, UserRoles roleType);
}
