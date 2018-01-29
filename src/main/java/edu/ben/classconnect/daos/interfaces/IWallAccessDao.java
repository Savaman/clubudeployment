package edu.ben.classconnect.daos.interfaces;

import java.util.ArrayList;

import edu.ben.classconnect.entities.User;
import edu.ben.classconnect.entities.Wall;
import edu.ben.classconnect.entities.WallAccess;

public interface IWallAccessDao extends IGenericDao<WallAccess> {

	ArrayList<Wall> getUserAccessList(User user);

}
