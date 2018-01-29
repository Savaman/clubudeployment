package edu.ben.classconnect.daos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.daos.interfaces.IUserDao;
import edu.ben.classconnect.entities.User;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserDao extends BaseDao<User> implements IUserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUserByUserName(String username) {
		List<User> users = new ArrayList<User>();

		Query<User> theQuery = getCurrentSession()
				.createQuery("select u from User u where u.userName =:username", User.class)
				.setParameter("username", username);

		users = theQuery.getResultList();

		if (users.size() > 0) {
			User u = users.get(0);

			System.out.println(u.getEmail());
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insertNewUser(User user) throws NullPointerException {

		if (!emailExists(user) && !userNameExists(user)) {

			user.setPassword(passwordEncoder.encode(user.getPassword()));

			getCurrentSession().save(user);
		} else {
			throw new NullPointerException();
		}

	}

	private boolean emailExists(User user) {
		List<User> users = new ArrayList<User>();

		Query<User> theQuery = getCurrentSession().createQuery("select u from User u where u.email =:email", User.class)
				.setParameter("email", user.getEmail());

		users = theQuery.getResultList();

		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private boolean userNameExists(User user) {
		List<User> userList = getCurrentSession()
				.createQuery("select u from User u where u.userName =:username", User.class)
				.setParameter("username", user.getUserName()).list();

		if (userList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
