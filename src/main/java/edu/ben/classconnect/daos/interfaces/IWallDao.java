package edu.ben.classconnect.daos.interfaces;

import edu.ben.classconnect.entities.Wall;

public interface IWallDao extends IGenericDao<Wall> {

	Wall getWallByName(String wallName);
}
