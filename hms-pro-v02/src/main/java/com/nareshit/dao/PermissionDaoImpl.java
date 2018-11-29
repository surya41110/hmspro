package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Permission;

@Repository
public class PermissionDaoImpl implements PermissionDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Permission addPermission(Permission perm) {
		Session ses = sf.openSession();
		ses.save(perm);
		ses.beginTransaction().commit();
		ses.close();
		return perm;
	}

	@Override
	public Permission getPermissionByid(int id) {
		Session ses = sf.openSession();
		Permission Permission = ses.load(Permission.class, id);
		//ses.close();
		return Permission;
	}

	@Override
	public List<Permission> getAllPermissions() {
		Session ses = sf.openSession();
		String getAllPermissions = "from Permission d";
		Query q = ses.createQuery(getAllPermissions);
		return q.list();		
	}

	@Override
	public List<Permission> searchPermission(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission updatePermission(Permission permission) {
		Session ses = sf.openSession();
		ses.update(permission);
		ses.beginTransaction().commit();
		ses.close();
		return permission;
	}

	@Override
	public Permission getPermissionByName(String name) {
		Session ses = sf.openSession();
		String hql = "from Permission p where p.permission=:permission";
		Query q = ses.createQuery(hql);
		q.setParameter("permission", name);
		return (Permission) q.uniqueResult();
	}

}
