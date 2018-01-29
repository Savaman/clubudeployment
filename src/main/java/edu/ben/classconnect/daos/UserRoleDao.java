package edu.ben.classconnect.daos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.daos.interfaces.IUserRoleDao;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.UserRole;
import edu.ben.classconnect.entities.UserRoles;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserRoleDao extends BaseDao<UserRole> implements IUserRoleDao {

	@Override
	public void addRoleToUser(User user, UserRoles roleType) throws NullPointerException {

		UserRole userRole = getUserRoleByEnum(roleType);

		user.setUserRole(userRole);
		

	}

	public UserRole getUserRoleByEnum(UserRoles role) {

		List<UserRole> userRoles = new ArrayList<UserRole>();

		Query<UserRole> theQuery = getCurrentSession()
				.createQuery("select u from UserRole u where u.role =:role", UserRole.class)
				.setParameter("role", role.toString().toUpperCase());

		userRoles = theQuery.getResultList();

		if (userRoles.isEmpty()) {
			return null;
		} else {
			return userRoles.get(0);
		}
	}

}
