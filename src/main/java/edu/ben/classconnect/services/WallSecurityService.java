package edu.ben.classconnect.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import edu.ben.classconnect.daos.interfaces.IPostDao;
import edu.ben.classconnect.daos.interfaces.IUserDao;
import edu.ben.classconnect.daos.interfaces.IWallDao;
import edu.ben.classconnect.entities.Post;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;
import edu.ben.classconnect.services.interfaces.IWallSecurityService;
import edu.ben.classconnect.utils.WallAccessUtil;

@Service
public class WallSecurityService implements IWallSecurityService {

	@Autowired
	IWallDao wallRepo;

	@Autowired
	IUserDao userRepo;

	@Autowired
	IPostDao postRepo;

	@Override
	public int giveUserWallAccess(User u, Wall wall) {

		return 0;
	}

	@Override
	public boolean userHasWallAccess(Authentication auth, String wallName) {

		User user = userRepo.getUserByUserName(auth.getName());

		Wall wall = wallRepo.getWallByName(wallName);

		return WallAccessUtil.convertWallAccessToUserList(wall.getMembers()).contains(user);
	}

	@Override
	public int removeUserWallAccess(User u, Wall wall) {
		return 0;

	}

	@Override
	public Wall getWall(String wallName) {
		return wallRepo.getWallByName(wallName);

	}

	@Override
	public ArrayList<Post> getWallPosts(Wall wall) {
		return postRepo.getAllPostsForWall(wall);
	}

}
