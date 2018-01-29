package edu.ben.classconnect.daos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.daos.interfaces.IWallDao;
import edu.ben.classconnect.entities.Wall;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class WallDao extends BaseDao<Wall> implements IWallDao {

	@Override
	public Wall getWallByName(String wallName) {

		List<Wall> walls = new ArrayList<Wall>();

		Query<Wall> theQuery = getCurrentSession()
				.createQuery("select u from Wall u where u.wallName =:wallName", Wall.class)
				.setParameter("wallName", wallName);

		walls = theQuery.getResultList();

		if (walls.size() > 0) {
			Wall u = walls.get(0);

			System.out.println(u.getWallName());
			return walls.get(0);
		} else {
			return null;
		}
	}

}
