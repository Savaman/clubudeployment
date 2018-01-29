package edu.ben.classconnect.daos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.ben.classconnect.entities.Notification;

@Transactional
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NotificationDao extends BaseDao<Notification> {

}
