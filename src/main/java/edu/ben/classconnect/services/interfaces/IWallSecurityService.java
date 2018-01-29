package edu.ben.classconnect.services.interfaces;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;

import edu.ben.classconnect.entities.Post;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;

public interface IWallSecurityService {

	int giveUserWallAccess(User u, Wall wall);

	boolean userHasWallAccess(Authentication auth, String wallName);

	int removeUserWallAccess(User u, Wall wall);

	Wall getWall(String wallName);

	ArrayList<Post> getWallPosts(Wall wall);

}
