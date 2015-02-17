package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		
		/*@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		*/
		
		/*
		
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
		
		//MetodoPago mdp = new MetodoPago();
		//session.save(mdp);
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
		
		
		tdc1.setCompra(compra1);
		dp1.setCompra(compra1);
		
		//session.save(tdc1);
		//session.save(dp1);
		
				
		
		
		
		
		
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
		
		//*session.save(promo1);
        //session.save(promo2);      
        session.save(empresa1); 
        
        compra1.setUsuario(uss1);
		compra1.setPromocion(promo1);
		uss1.getCompras().add(compra1);
		promo1.getCompras().add(compra1);
		
		compra2.setUsuario(uss2);
		compra2.setPromocion(promo2);
		uss2.getCompras().add(compra2);
		promo2.getCompras().add(compra2);
		
		compra3.setUsuario(uss3);
		compra3.setPromocion(promo1);
		uss3.getCompras().add(compra3);
		promo1.getCompras().add(compra3);				
		
		
		session.save(promo1);
        session.save(promo2);
		session.save(compra1);
		session.save(compra2);
		session.save(compra3);
		
        session.save(uss1);
		session.save(uss2);
		session.save(uss3);

        sub1.getPromociones().add(promo1);
        sub2.getPromociones().add(promo2);
        
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
        
        uss1.getComprasCompartidas().add(compra1);
        //compra1.getUsuariosCompartir().add(uss1);
        session.save(uss1);
        //session.save(compra1);
        
        Date fecha = new Date();
        FechaAsociada fecha1 = new FechaAsociada(fecha);
		FechaAsociada fecha2 = new FechaAsociada(new Date());
		FechaAsociada fecha3 = new FechaAsociada(new Date());
		
		
		promo1.getFechasAsociadas().add(fecha1);
		promo2.getFechasAsociadas().add(fecha2);
		promo2.getFechasAsociadas().add(fecha3);
		
		fecha1.setPromocion(promo1);
		fecha2.setPromocion(promo2);
		fecha3.setPromocion(promo2);
		session.save(promo1);
		session.save(promo2);
		session.save(fecha1);
		session.save(fecha2);
		session.save(fecha3);
		
        */
		
		
		/*promo1.getCiudades().add(ciudad1);
		List<Compra> list = new ArrayList<Compra>(promo1.getCompras());
		//System.out.println("Compras en Promociones = \n"+list.get(0).getCodigo_de_vale() + "  "+list.get(1).getCodigo_de_vale());
		*/
		
		
		
		/*
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		*/
		Main main = new Main();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		Telefono tlf1 = new Telefono(58, 239, 2487895);
		Telefono tlf2 = new Telefono(56, 287, 8527493);
		empresas.add(new Empresa("La Espetada C.A.", "Carretera Charallave Cua Km 5", 18, tlf1));
		empresas.add(new Empresa("Hermanos a la casta", "Avenida Valencia con Calle san Jose", 18, tlf2));
				
		main.agregarEmpresas(empresas,sessionFactory);
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria("Gastronomia y Bebidas", "Comida, postres, cocteles, y relacionados"));
		categorias.add(new Categoria("Moda y Accesorios", "Todo lo que desees de vestimenta y accesorios"));
		categorias.add(new Categoria("Eventos Sociales", "Reuniones programas entre personas de un rango social"));
		categorias.add(new Categoria("Viajes", "Muchos destinos para disfrutar de tu tiempo libre"));
		
		ArrayList<Subcategoria> subcategorias = new ArrayList<Subcategoria>();
		subcategorias.add(new Subcategoria("Bares y Restaurantes", "Bienestar y tranquilidad a la hora de comer"));
		subcategorias.add(new Subcategoria("Comida Rapida", "Una comida completa y en solo instantes"));
		subcategorias.add(new Subcategoria("Conferencias", "Reuniones dirigidas a publico especifico de un area particular"));
		subcategorias.add(new Subcategoria("Conciertos", "Entradas para los conciertos de artistas con mayor renombre y los recientes"));
		subcategorias.add(new Subcategoria("Playero", "La prendas que son mas utilizadas para la playa"));
		subcategorias.add(new Subcategoria("Zapatos", "El ultimo grito en cuenta al calzado maculino y femenino"));
		subcategorias.add(new Subcategoria("Hoteles", "Habitaciones singulares, familiares en los mejores lugares"));
		subcategorias.add(new Subcategoria("Parques Varios", "Los diferentes parques a nivel internacional"));
		
		main.agregarSubcategorias(subcategorias, categorias, sessionFactory);
		
		sessionFactory.close();
	}
	
	
	public void agregarEmpresas(ArrayList<Empresa> empresas,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = empresas.size();
		for (int i=0; i<tam; i++){
			session.save(empresas.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarCategorias(ArrayList<Categoria> categorias,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = categorias.size();
		for (int i=0; i<tam; i++){
			session.save(categorias.get(i));			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarSubcategorias(ArrayList<Subcategoria> subcategorias,
			                         ArrayList<Categoria> categorias, SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = subcategorias.size(); 
		int cat = 0;
		for (int i=0; i<tam; i++){			
			if ((i % 2 == 0) && i>=1){
				cat = cat+1;
			}
			categorias.get(cat).getSubcategorias().add(subcategorias.get(i));			
			session.save(categorias.get(cat));
			subcategorias.get(i).setCategoria(categorias.get(cat));
			session.save(subcategorias.get(i));	
			
			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	

}