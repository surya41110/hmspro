package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Permission;
import com.nareshit.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Role addRole(Role role) {
		Session ses = sf.openSession();
		ses.save(role);
		ses.beginTransaction().commit();
		ses.close();
		return role;
	}

	@Override
	public Role getRoleByid(int id) {
		Session ses = sf.openSession();
		Role Role = ses.load(Role.class, id);
		//ses.close();
		return Role;
	}

	@Override
	public List<Role> getAllRoles() {
		Session ses = sf.openSession();
		String getAllRoles = "from Role d";
		Query q = ses.createQuery(getAllRoles);
		return q.list();		
	}

	@Override
	public List<Role> searchRole(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role updateRole(Role Role) {
		Session ses = sf.openSession();
		ses.update(Role);
		ses.beginTransaction().commit();
		ses.close();
		return Role;
	}
	
	@Override
	public Role getRoleByName(String name) {
		Session ses = sf.openSession();
		String hql = "from Role p where p.role=:name";
		Query q = ses.createQuery(hql);
		q.setParameter("name", name);
		return (Role) q.uniqueResult();
	}

}
