package edu.ben.classconnect.daos;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.daos.interfaces.IWallAccessDao;
import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;
import edu.ben.classconnect.entities.WallAccess;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class WallAccessDao extends BaseDao<WallAccess> implements IWallAccessDao {

	@Override
	public ArrayList<Wall> getUserAccessList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
