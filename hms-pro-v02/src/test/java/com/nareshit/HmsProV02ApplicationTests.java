package com.nareshit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HmsProV02ApplicationTests {

	
	@Test
	public void contextLoads() {
	}

	
	
	/*@Test
	public void testDoctorCreation() {
	
		User user =  new User();
		
		user.setFname("ram123");
		user.setLname("john");
		
		Session ses = sf.openSession();
		ses.save(user);
		ses.beginTransaction().commit();
		
		Doctor admin = new Doctor();
		admin.setFname("Ram1234");
		admin.setLname("simple123");
		admin.setEmail("ram123@email.com");
		admin.setPassword("testUser");
		admin.setStatus(true);
		admin.setConpassword("testUser");
		
		admin = docDao.addDoctor(admin);
		System.out.println("&&&&&&&&:\t"+admin.getId());
		
	}*/
}
