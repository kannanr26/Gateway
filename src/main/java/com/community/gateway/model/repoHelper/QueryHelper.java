package com.community.gateway.model.repoHelper;

import java.util.List;
/* import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service*/
public class QueryHelper {

	/*@Autowired
	SessionFactory hibernateSessionFactory;
	
	@Autowired
	Session hibernateSession;*/

	public List<Long> getPincode() {
		// TODO Auto-generated method stub
	/*	List pincode;
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();  
		Session session = sf.openSession();
		session.beginTransaction();
		Query pincodeQuery = hibernateSession.createQuery("select pinoe from city");
		pincode = pincodeQuery.getResultList();
		session.getTransaction().commit();
			
		//closing the session
		session.close();
		return pincode;*/
		return null;
	}
	
	
	
}
