package edu.ben.classconnect.daos;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.daos.interfaces.IPostDao;
import edu.ben.classconnect.entities.Post;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PostDao extends BaseDao<Post> implements IPostDao {

	@Override
	public ArrayList<Post> getAllPostsForWall(Wall wall) {
		
		ArrayList<Post> posts = new ArrayList<Post>();

		Query<Post> theQuery = getCurrentSession()
				.createQuery("select u from Post u where u.wall =:wall", Post.class)
				.setParameter("wall", wall);

		posts = (ArrayList<Post>) theQuery.getResultList();
		
		return posts;
	}

	@Override
	public ArrayList<Post> getAllPostsForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
