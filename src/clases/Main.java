package clases;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) 
	{
		//Student_Info student1 = new Student_Info();
		//student1.setName("Fabiana");
		
        //Student_Info student2 = new Student_Info();
		//student2.setName("Krisvely");
				
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ValePromocion vale1= new ValePromocion(1234, "Este es un vale", "jose@gmail.com", true, null);
		Compra compra1 = new Compra(3, 8547, null);
		
		compra1.setVale(vale1);
		vale1.setCompra(compra1);

		session.save(vale1);
		
		Usuario uss1 = new Usuario("pedro345", "123456", "pedrito", "Rodrigues" , "pedrRod@gmail.com" , null);
		
		Usuario uss2 = new Usuario("ramon", "123456", "raaamen", "umnte" , "sdddRod@gmail.com" , null);
		Usuario uss3 = new Usuario("Josefino", "123456", "josefo", "camyt" , "podr@gmail.com" , null);
		
		uss2.setPersona(uss1);
		uss3.setPersona(uss1);
		
		session.save(uss1);
        session.save(uss2);
        session.save(uss3);
		
        
        
        
		
		//session.save(compra1);
		
		//session.save(student1);
		//session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}