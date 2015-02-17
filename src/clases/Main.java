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
		
		
		
		
		Usuario uss1 = new Usuario("pedro345", "123456", "pedrito", "Rodrigues" , "pedrRod@gmail.com" , null);
		
		Usuario uss2 = new Usuario("ramon", "123456", "raaamen", "umnte" , "sdddRod@gmail.com" , null);
		Usuario uss3 = new Usuario("Josefino", "123456", "josefo", "camyt" , "podr@gmail.com" , null);
		
		uss1.getAmigos().add(uss2);
		uss1.getAmigos().add(uss3);
		
		UsuarioRedSocial urs1 = new UsuarioRedSocial("pedro123" );
		UsuarioRedSocial urs2 = new UsuarioRedSocial("pedro893" );
		UsuarioRedSocial urs3 = new UsuarioRedSocial("ram123" );
		UsuarioRedSocial urs4 = new UsuarioRedSocial("josef503" );
		
		uss1.getURSocial().add(urs1);
		uss1.getURSocial().add(urs2);
		uss2.getURSocial().add(urs3);
		uss1.getURSocial().add(urs4);
		
		urs1.setUsuario(uss1);
		urs2.setUsuario(uss1);
		urs3.setUsuario(uss2);		
		urs4.setUsuario(uss1);
		
		session.save(uss1);
		session.save(urs1);
        session.save(urs2);
        
        session.save(uss2);
        session.save(urs3);   
        
        session.save(uss3);
        session.save(urs4);
         
        Telefono tlf = new Telefono(1001,414,2484727);
		Empresa empresa1 = new Empresa("Cines Unidos", "Cotiza", 5, tlf);
		session.save(empresa1);
		
		//session.save(ubgeo);
		UbicacionGeografica ubgeo = new UbicacionGeografica(1.0, 40.0, 85.0);
		UbicacionGeografica ubgeo2 = new UbicacionGeografica(1.0, 40.0, 75.0);
		Promocion promo1 = new Promocion("2X1", 100, 50, "www.cinesunidos.com", null,ubgeo);
		Promocion promo2 = new Promocion("2X1", 100, 50, "www.cinesunidos.com", null,ubgeo2);
		
		
		Subcategoria sub1 = new Subcategoria("Cine", "Boletos, combos y demas");
		Subcategoria sub2 = new Subcategoria("Teatro", "Tomaaaa papaaaa");
		Categoria cat1 = new Categoria("Entretenimiento", "Todo la diversion aqui");
		Ciudad ciudad1 = new Ciudad("Atlanta", "VZLA");
		session.save(ciudad1);
		
		/*MetodoPago mdp = new MetodoPago();
		session.save(mdp);*/
		TDC tdc1 = new TDC(1235704,"BCV",485,"VISA");
		TDC tdc2 = new TDC(1264234,"BCV",147,"VISA");
		TDC tdc3 = new TDC(1234024,"BCV",625,"MASTERCARD");
		
		uss1.getTdcs().add(tdc1);
		tdc1.setUsuario(uss1);
		
		uss2.getTdcs().add(tdc2);
		tdc2.setUsuario(uss2);
		
		uss3.getTdcs().add(tdc3);
		tdc3.setUsuario(uss3);
		
		
		
		session.save(tdc1);
		session.save(tdc2);
		session.save(tdc3);
		
		DineroPromocion dp1 = new DineroPromocion(1234);
		DineroPromocion dp2 = new DineroPromocion(124539);
		DineroPromocion dp3 = new DineroPromocion(13237);
		uss1.setDinProm(dp1);
		dp1.setUsuario(uss1);
		
		uss2.setDinProm(dp2);
		dp2.setUsuario(uss2);
		
		uss3.setDinProm(dp3);
		dp3.setUsuario(uss3);
		
		session.save(uss1);
		session.save(uss2);
		session.save(uss3);
		session.save(dp1);
		session.save(dp2);
		session.save(dp3);
		
		uss1.setDinProm(dp1);
		dp1.setUsuario(uss1);
		
		ValePromocion vale1= new ValePromocion(1, "Este es un vale", "jose@gmail.com", true, null);
		ValePromocion vale2= new ValePromocion(1, "Este es un vale", "jose@gmail.com", true, null);
		ValeRegalo vale3= new ValeRegalo(1, "Este es un vale", "jose@gmail.com", true, null,null);
		
		Compra compra1 = new Compra(3, 8532247, null);
		Compra compra2 = new Compra(67, 834547, null);
		Compra compra3 = new Compra(98, 854744, null);
		
		compra1.setVale(vale1);
		vale1.setCompra(compra1);

		compra2.setVale(vale3);
		vale3.setCompra(compra2);
		
		compra3.setVale(vale2);
		vale2.setCompra(compra3);
		
		
		compra1.setMetodoPagos(tdc1);
		compra2.setMetodoPagos(tdc2);
		compra3.setMetodoPagos(dp3);
		
		session.save(compra1);
		session.save(compra2);
		session.save(compra3);
		tdc1.setCompra(compra1);
		dp1.setCompra(compra1);
		/*
		session.save(tdc1);
		session.save(dp1);
		*/
		
		ciudad1.getPromociones().add(promo1);
		ciudad1.getPromociones().add(promo2);
        
		
		
		sub1.setCategoria(cat1);
		sub2.setCategoria(cat1);
		
		cat1.getSubcategorias().add(sub1);
		cat1.getSubcategorias().add(sub2);
		session.save(cat1);
		session.save(sub1);
        session.save(sub2);
        
        empresa1.getPromociones().add(promo1);
		empresa1.getPromociones().add(promo2);
		
		promo1.setEmpresa(empresa1);
		promo2.setEmpresa(empresa1);
       
        promo1.setSubcategoria(sub1);
        promo2.setSubcategoria(sub1);
		
		session.save(promo1);
        session.save(promo2);      
        session.save(empresa1);        
		
        
        sub1.getPromociones().add(promo1);
        sub2.getPromociones().add(promo2);
        
        
        
        session.save(promo1);
        session.save(promo2);
        session.save(sub1);
        session.save(sub2);
        session.save(cat1);
        session.save(ciudad1);
        session.save(empresa1);
		
        ciudad1.getUsuarios().add(uss1);
        ciudad1.getUsuarios().add(uss2);
        ciudad1.getUsuarios().add(uss3);
        
        uss1.getCategorias().add(cat1);
        uss2.getCategorias().add(cat1);
        uss3.getCategorias().add(cat1);
        
        
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		promo1.getCiudades().add(ciudad1);
		//System.out.println("Ciudades = "+promo1.getCiudades() + " La ciudad es "+ ciudad1.toString() );
	}

}