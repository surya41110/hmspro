package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Doctor addDoctor(Doctor doct) {
		System.out.println(doct);
		Session ses = sf.openSession();
		ses.save(doct);
		
		ses.beginTransaction().commit();
		ses.close();
		return doct;
	}

	@Override
	public Doctor getDoctorByid(int id) {
		Session ses = sf.openSession();
		Doctor doc = ses.load(Doctor.class, id);
		//ses.close();
		return doc;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		Session ses = sf.openSession();
		String getAllDoctors = "from Doctor d";
		Query q = ses.createQuery(getAllDoctors);
		return q.list();		
	}

	@Override
	public List<Doctor> searchDoctor(String docName, String criteria) {
		Session ses = sf.openSession();
		//String getDoctorsByname="from Doctor d where lower(d.name) like lower(concat('%', :docName,'%'))";
		Query qry = ses.createQuery("from Doctor as d where d."+criteria+" like ?");
		qry.setString(0,"%"+docName+"%");
		return qry.list();
	}

	@Override
	public Doctor updateDoctor(Doctor doc) {
		Session ses = sf.openSession();
		ses.update(doc);
		ses.beginTransaction().commit();
		ses.close();
		return doc;
	}
	
	@Override
	public void deleteDoctor(int id) {
		Session ses = sf.openSession();
		Transaction tx=ses.beginTransaction();
		Doctor doc= ses.get(Doctor.class, id);
		System.out.println(doc+"    doc  in dao");
		ses.delete(doc);
		tx.commit();
		ses.close();
	}

}
