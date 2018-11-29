package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.User;


@Repository
public class ManageuserDaoImpl implements ManageUserDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public User authenticateUser(String username, String password) {
		Session ses = sf.openSession();
		String hql = "from User u where u.fname =:fname and u.password=:password";
		Query q = ses.createQuery(hql);
		q.setParameter("fname", username);
		q.setParameter("password", password);
		
		User user = (User) q.uniqueResult();
		return user;
		
		
	}
	
	@Override
	public User getUserByUserName(String username) {
		Session ses = sf.openSession();
		String hql = "from User u where u.fname =:fname";
		Query q = ses.createQuery(hql);
		q.setParameter("fname", username);
		User user = (User) q.uniqueResult();
		if(user != null) {
			
		}
		return user;
		
		
	}
	
	@Override
	public User addUser(User User) {
		Session ses = sf.openSession();
		
		User user =  new User();
		user.setFname("ram123");
		user.setLname("john");
		ses.save(user);
		
		ses.save(User);
		ses.beginTransaction().commit();
		return User;
	}

	@Override
	public User getUserByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
