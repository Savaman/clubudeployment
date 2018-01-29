package edu.ben.classconnect.daos.interfaces;

import java.util.ArrayList;

import edu.ben.classconnect.entities.Post;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;

public interface IPostDao extends IGenericDao<Post> {
	
	ArrayList<Post> getAllPostsForWall(Wall wall);
	
	ArrayList<Post> getAllPostsForUser(User user);
}
