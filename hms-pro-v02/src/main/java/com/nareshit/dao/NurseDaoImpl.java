package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Nurse;

@Repository
public class NurseDaoImpl implements NurseDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Nurse addNurse(Nurse nurse) {
		System.out.println(nurse);
		Session ses = sf.openSession();
		ses.save(nurse);
		
		ses.beginTransaction().commit();
		ses.close();
		return nurse;
	}

	@Override
	public Nurse getNurseByid(int id) {
		Session ses = sf.openSession();
		Nurse nur = ses.load(Nurse.class, id);
		//ses.close();
		return nur;
	}

	@Override
	public List<Nurse> getAllNurses() {
		Session ses = sf.openSession();
		String getAllNurses = "from Nurse d";
		Query q = ses.createQuery(getAllNurses);
		return q.list();		
	}

	@Override
	public List<Nurse> searchNurse(String nurName, String criteria) {
		Session ses = sf.openSession();
		//String getNursesByname="from Nurse d where lower(d.name) like lower(concat('%', :nurName,'%'))";
		Query qry = ses.createQuery("from Nurse as d where d."+criteria+" like ?");
		qry.setString(0,"%"+nurName+"%");
		return qry.list();
	}

	@Override
	public Nurse updateNurse(Nurse nur) {
		Session ses = sf.openSession();
		ses.update(nur);
		ses.beginTransaction().commit();
		ses.close();
		return nur;
	}
	
	@Override
	public void deleteNurse(int id) {
		Session ses = sf.openSession();
		Transaction tx=ses.beginTransaction();
		Nurse nur= ses.get(Nurse.class, id);
		System.out.println(nur+"    nur  in dao");
		ses.delete(nur);
		tx.commit();
		ses.close();
	}

}
