package clases;

import java.util.Set;

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
		
		Empresa empresa1 = new Empresa("Cines Unidos", "Cotiza", 1010, 0414123456, 5);
		session.save(empresa1);
		
		Promocion promo1 = new Promocion("2X1", 100, 50, "www.cinesunidos.com", null, 14569.0, 45.0, 150.0);
		Promocion promo2 = new Promocion("2X1", 100, 50, "www.cinesunidos.com", null, 14569.0, 45.0, 150.0);
		
		
		promo1.setEmpresa(empresa1);
		promo2.setEmpresa(empresa1);
		
		empresa1.getPromociones().add(promo1);
		empresa1.getPromociones().add(promo2);
		
		session.save(empresa1);
		session.save(promo1);
        session.save(promo2);
        
      /*  Set<Promocion> prom = null;
        prom.add(promo1);
        prom.add(promo2);
        empresa1.setPromociones(prom);
		session.save(empresa1);*/
		
		//session.save(compra1);
		
		//session.save(student1);
		//session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}