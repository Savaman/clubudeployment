package edu.ben.classconnect.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.WallAccess;

public class WallAccessUtil {

	public static List<User> convertWallAccessToUserList(Set<WallAccess> list) {

		List<User> users = new ArrayList<User>();
		User user;

		for (WallAccess wallAccess : list) {
			user = new User();
			user = wallAccess.getUser();
			users.add(user);
		}

		return users;
	}
}
