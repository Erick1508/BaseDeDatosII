package clases;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class Main {
	
	public static void main(String[] args) 
	{
		
		Main main = new Main();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		/********************************************************************************
		 * DECLARACION DE VARIABLES PARA LLENAR LA BD									*
		 ********************************************************************************/
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();		
		ArrayList<Subcategoria> subcategorias = new ArrayList<Subcategoria>();						
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();			
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<UsuarioRedSocial> usuariosRedSocials = new ArrayList<UsuarioRedSocial>();
		
		//ArrayList<TDC> tdcs = new ArrayList<TDC>();		
		//ArrayList<DineroPromocion> dinPromo = new ArrayList<DineroPromocion>();
		ArrayList<MetodoPago> metodoPago = new ArrayList<MetodoPago>(); 
		
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		ArrayList<FechaAsociada> fechasAsoc = new ArrayList<FechaAsociada>();		
		ArrayList<Compra> compras = new ArrayList<Compra>();
		ArrayList<ValePromocion> valesPromos = new ArrayList<ValePromocion>();
		ArrayList<ValeRegalo> valesRegalos = new ArrayList<ValeRegalo>();
		/********************************************************************************
		 * FIN DE DECLARACIONES															*
		 ********************************************************************************/
				
		/********************************************************************************
		 * SETEANDO DATOS A ALMACENAR EN LA BD											*
		 ********************************************************************************/
		llenarArreglos(empresas, subcategorias, categorias, ciudades, usuarios,
				  	   usuariosRedSocials,metodoPago, promociones, compras,
				  	   valesPromos, valesRegalos,fechasAsoc);
		setearAmigos(usuarios);
		setearRedesSocialesAUsuarios(usuarios, usuariosRedSocials);
		setearMetodoDePagoAUsuarios(usuarios, metodoPago);		
		setearSubcategoriasACategorias(subcategorias, categorias);
		setearCategoriasUsuarios(usuarios, categorias);
		setearCiudadAUsuarios(usuarios, ciudades);
		setearEmpresasAPromociones(empresas, promociones);
		setearSubcategoriasAPromociones(subcategorias, promociones);
		setearCiudadAPromociones(promociones, ciudades);
		setearFechasAPromociones(fechasAsoc, promociones);
		setearValesConCompras(valesPromos, valesRegalos, compras);
		setearMetodoPagosConCompras(compras, metodoPago, usuarios);		
		setearUsuariosConCompras(compras, usuarios);
		setearPromocionesConCompras(compras, promociones);
		setearCompartidosConCompras(compras, usuarios);

		/********************************************************************************
		 * INSERTANDO A LA BD LOS DATOS DESEADOS										*
		 ********************************************************************************/		
		main.agregarEmpresas(empresas,sessionFactory);
		main.agregarCategorias(categorias, sessionFactory);	
		main.agregarSubcategorias(subcategorias, sessionFactory);		
		main.agregarCiudades(ciudades, sessionFactory);
		main.agregarUsuarios(usuarios, sessionFactory);
		main.agregarRedesSocialesAUsuarios(usuariosRedSocials, sessionFactory);
		main.agregarMetodoPago(metodoPago, sessionFactory);
		main.agregarPromocion(promociones, sessionFactory);	
		main.agregarFechasAsocAPromociones(fechasAsoc, sessionFactory);		
		main.agregarCompras(compras, sessionFactory);
		
		/********************************************************************************
		 * CONSULTAS LA BASE DE DATOS GENERADA											*
		 ********************************************************************************/				
		consulta1(sessionFactory);
		consulta2(sessionFactory);
		consulta3(sessionFactory);
				
		sessionFactory.close();
	}
	
	/********************************************************************************
	 * METODOS DE CONSULTAS HQL  													*
	 * EN LA BD																		*
	 ********************************************************************************/
	//USUARIOS QUE COMPRAN PROMOCIONES QUE SE LE COMPARTIERON
	public static void consulta1(SessionFactory sessionFactory){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
        
		Query query = 
				session.createQuery("select comp.usuario "
								  + "from Compra comp join comp.promocion p1, "
								       + "Compra comp2 join comp2.promocion p2 "
								  + "where p1.promocion_id = p2.promocion_id and "
								        + "comp.fechaCompra > comp2.fechaCompra and "
								        + "comp.usuario in "
								                   + "(from comp2.usuariosCompartir)");
		
	    
		//Guardando en la lista todas las tuplas recibidas en el query	
		List uss = query.list(); 
		System.out.println("\n");
		System.out.println("USUARIOS QUE COMPRAN PROMOCIONES QUE SE LES COMPARTIERON");
		System.out.println("--------------------------------------------------------");
		System.out.println("| LOGIN USUARIOS                                        |");
		System.out.println("--------------------------------------------------------");
		//Iterando sobre todas las tuplas almacenadas en la lista
    	for (Iterator iterator = uss.iterator(); iterator.hasNext();) {
    		Usuario us = (Usuario) iterator.next(); 
    		System.out.println("| "+us.getLogin()
    							+"                                  |");
    		//us.getUsuariosCompartir().
    	}
    	
    	System.out.println("--------------------------------------------------------");
    	
    	transaction.commit();
		session.close();
	}
	
	//CANTIDAD DE PROMOCIONES ADQUIRIDAS POR UNA CATEGORIA ESPECIFICA.
	public static void consulta2(SessionFactory sessionFactory){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
				
		Query query2 = 
				session.createQuery("select cat, count(cat) "
								  + "from Compra comp "
								  	   + "join comp.promocion p "
								  	   + "join p.subcategoria subcat "
								  	   + "join subcat.categoria cat "
								  + "group by cat ");
    	
		List<Object[]> obj2 = (List<Object[]>)query2.list(); 
		System.out.println("\n");
		System.out.println("CANTIDAD DE PROMOCIONES ADQUIRIDAS POR UNA CATEGORIA ESPECIFICA");
		System.out.println("--------------------------------------------------------");
		System.out.println("| NOMBRE CATEGORIA : CANTIDAD                          |");
		System.out.println("--------------------------------------------------------");		
		for(Object[] objects : obj2){
	        Categoria categ = (Categoria)objects[0];
	        Long cant = (Long)objects[1];
	        System.out.println("| "+categ.getNombreCategoria()+" : " + cant 
	        					+"                                  |");
	    }
    	System.out.println("--------------------------------------------------------");    	 
    	
    	
    	transaction.commit();
		session.close();
	}
	
	//TOTAL DE VENTAS POR CADA EMPRESA EN EL PORTAL
	public static void consulta3(SessionFactory sessionFactory){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		
		Query query = 
				session.createQuery("select emp, sum(comp.montoDeCompra) "
								  + "from Compra comp "
								  	   + "join comp.promocion p1 "
								  	   + "join p1.empresa emp "
								  + "group by emp " );
		
	    
		//Guardando en la lista todas las tuplas recibidas en el query	
		List<Object[]> obj = (List<Object[]>)query.list(); 
		System.out.println("\n");
		System.out.println("TOTAL DE VENTAS POR CADA EMPRESA EN EL PORTAL");
		System.out.println("--------------------------------------------------------");
		System.out.println("| NOMBRE EMPRESA : TOTAL VENTAS                        |");
		System.out.println("--------------------------------------------------------");	
		for(Object[] objects : obj){
	        Empresa emp = (Empresa)objects[0];
	        Double sum = (Double)objects[1];
	        System.out.println("| "+emp.getNombreEmpresa()+" : " + sum
							   +"                                  |");	        
	    }	
    	System.out.println("--------------------------------------------------------");
    	
    	transaction.commit();
		session.close();
	}
	
	
	/********************************************************************************
	 * METODOS DE SETEO DE DATOS PARA 												*
	 * AGREGAR A LA BD																*
	 ********************************************************************************/
	@SuppressWarnings("deprecation")
	public static void llenarArreglos(ArrayList<Empresa> empresas,ArrayList<Subcategoria> subcategorias,
									  ArrayList<Categoria> categorias,ArrayList<Ciudad> ciudades, ArrayList<Usuario> usuarios,
									  ArrayList<UsuarioRedSocial> usuariosRedSocials, ArrayList<MetodoPago> metodoPago, 
									  ArrayList<Promocion> promociones,
									  ArrayList<Compra> compras, ArrayList<ValePromocion> valesPromos,
									  ArrayList<ValeRegalo> valesRegalos, ArrayList<FechaAsociada> fechasAsoc){
					
		/*
		 * ARREGLO DE EMPRESAS
		 * */
		Telefono tlf1 = new Telefono(58, 239, 2487895);
		Telefono tlf2 = new Telefono(56, 287, 8527493);
		Telefono tlf3 = new Telefono(58, 212, 7842569);
		Telefono tlf4 = new Telefono(33, 874, 1036987);
		Telefono tlf5 = new Telefono(31, 342, 0142043);
		empresas.add(new Empresa("La Espetada C.A.", "Carretera Charallave Cua Km 5", 18, tlf1));
		empresas.add(new Empresa("AGUI C.A.", "Edificio Carlo Andres, calle 12 con avenida Miranda", 28, tlf3));				
		empresas.add(new Empresa("Zara", "C.C. Grandes Tiendas, piso 2, local 15", 36, tlf4));
		empresas.add(new Empresa("Aerolineas LissandraX", "Oficina central en calle 4 edifico Perez Perez piso 1", 22, tlf5));
		empresas.add(new Empresa("Hermanos a la casta", "Avenida Valencia con Calle san Jose", 14, tlf2));
		
		/*
		 * ARREGLO DE CATEGORIAS
		 * */
		categorias.add(new Categoria("Gastronomia y Bebidas", "Comida, postres, cocteles, y relacionados"));
		categorias.add(new Categoria("Moda y Accesorios", "Todo lo que desees de vestimenta y accesorios"));
		categorias.add(new Categoria("Eventos Sociales", "Reuniones programas entre personas de un rango social"));
		categorias.add(new Categoria("Viajes", "Muchos destinos para disfrutar de tu tiempo libre"));
		
		/*
		 * ARREGLO DE SUBCATEGORIAS
		 * */
		subcategorias.add(new Subcategoria("Bares y Restaurantes", "Bienestar y tranquilidad a la hora de comer"));
		subcategorias.add(new Subcategoria("Comida Rapida", "Una comida completa y en solo instantes"));
		subcategorias.add(new Subcategoria("Playero", "La prendas que son mas utilizadas para la playa"));
		subcategorias.add(new Subcategoria("Zapatos", "El ultimo grito en cuenta al calzado maculino y femenino"));
		subcategorias.add(new Subcategoria("Conferencias", "Reuniones dirigidas a publico especifico de un area particular"));
		subcategorias.add(new Subcategoria("Conciertos", "Entradas para los conciertos de artistas con mayor renombre y los recientes"));
		subcategorias.add(new Subcategoria("Hoteles", "Habitaciones singulares, familiares en los mejores lugares"));
		subcategorias.add(new Subcategoria("Parques Varios", "Los diferentes parques a nivel internacional"));
		
		/*
		 * ARREGLO DE CIUDADES
		 * */
		ciudades.add(new Ciudad("Madrid", "Espana"));
		ciudades.add(new Ciudad("Caracas", "Venezuela"));
		ciudades.add(new Ciudad("Roma", "Italia"));
		ciudades.add(new Ciudad("Lisboa", "Portugal"));
		ciudades.add(new Ciudad("Bogota", "Colombia"));
		
		/*
		 * ARREGLO DE USUARIOS
		 * */
		usuarios.add(new Usuario("pedrito1", "pedro1789", "Pedro", "Perez", "pedro@gmail.com", new Date())); // 2 urs
		usuarios.add(new Usuario("rosagerman2", "185rosa_", "Rosa", "German", "rosGerm@gmail.com", new Date())); // 3
		usuarios.add(new Usuario("cBautista", "7c8b2ut", "Carlos", "Bautista", "bautistaC@gmail.com", new Date())); // 1
		usuarios.add(new Usuario("martinezJose", "mjose164", "Jose", "Martinez", "josemart@gmail.com", new Date())); // 2
		usuarios.add(new Usuario("homerSim", "simp50n", "Homero", "Simpson", "daug@gmail.com", new Date())); // 3
		
		/*
		 * ARREGLO DE USUARIOS RED SOCIAL
		 * */
		//pedro
		usuariosRedSocials.add(new UsuarioRedSocial("pedro56"));
		usuariosRedSocials.add(new UsuarioRedSocial("@pedro5"));
		//rosa
		usuariosRedSocials.add(new UsuarioRedSocial("rosGer"));
		usuariosRedSocials.add(new UsuarioRedSocial("@rositaG"));
		usuariosRedSocials.add(new UsuarioRedSocial("rosa21"));
		//bautista
		usuariosRedSocials.add(new UsuarioRedSocial("@bautistaC12"));
		//jose
		usuariosRedSocials.add(new UsuarioRedSocial("@mart1"));
		usuariosRedSocials.add(new UsuarioRedSocial("joseM"));
		// homero
		usuariosRedSocials.add(new UsuarioRedSocial("hsimp"));
		usuariosRedSocials.add(new UsuarioRedSocial("@daugHomer"));
		usuariosRedSocials.add(new UsuarioRedSocial("simpsonsHom"));
		
		/*
		 * ARREGLO DE Tarjetas De Credito 
		 * */
		metodoPago.add(new MetodoPago(145878253, "BBVA", 354, "VISA"));
		metodoPago.add(new MetodoPago(785214630, "Bicentenario", 278, "MASTER CARD"));
		metodoPago.add(new MetodoPago(874145369, "Mercantil", 894, "VISA"));
		metodoPago.add(new MetodoPago(147214523, "BOD", 145, "VISA"));
		metodoPago.add(new MetodoPago(365874125, "Bancaribe", 214, "MASTER CARD"));		
		metodoPago.add(new MetodoPago(854723624, "Mercantil", 778, "VISA"));
		metodoPago.add(new MetodoPago(365339837, "BBVA", 325, "VISA"));
		metodoPago.add(new MetodoPago(778142578, "Bicentenario", 134, "MASTER CARD"));
		
		/*
		 * ARREGLO DE DINERO DE PROMOCION
		 * */
		metodoPago.add(new MetodoPago(0.0));
		metodoPago.add(new MetodoPago(0.0));
		metodoPago.add(new MetodoPago(0.0));
		metodoPago.add(new MetodoPago(0.0));
		metodoPago.add(new MetodoPago(0.0));
		
		
		/*
		 * Ubicaciones Geograficas de las promociones
		 * */
		UbicacionGeografica ubgeo1 = new UbicacionGeografica(78.5, 47, 12.3);
		UbicacionGeografica ubgeo2 = new UbicacionGeografica(18.5, 85.1, 17.9);
		UbicacionGeografica ubgeo3 = new UbicacionGeografica(23.7, 51.2, 19.8);
		UbicacionGeografica ubgeo4 = new UbicacionGeografica(35.5, 96, 65.6);
		UbicacionGeografica ubgeo5 = new UbicacionGeografica(41.1, 40.5, 42.6);
		UbicacionGeografica ubgeo6 = new UbicacionGeografica(68.2, 47, 12.3);
		UbicacionGeografica ubgeo7 = new UbicacionGeografica(17.4, 58.7, 92.3);
		UbicacionGeografica ubgeo8 = new UbicacionGeografica(77.7, 7, 11.6);
		UbicacionGeografica ubgeo9 = new UbicacionGeografica(28.5, 37.8, 52.4);
		UbicacionGeografica ubgeo10 = new UbicacionGeografica(9.4, 76.5, 82.9);
		
		/*
		 * ARREGLO DE FECVHASASOC
		 * */
		//promo1 y 2
		fechasAsoc.add(new FechaAsociada(new Date(115, 2, 16, 23, 59, 0)));
		fechasAsoc.add(new FechaAsociada(new Date(115, 3, 20, 23, 59, 0)));
		//promo3
		fechasAsoc.add(new FechaAsociada(new Date(115, 8, 15, 23, 59, 0)));
		fechasAsoc.add(new FechaAsociada(new Date(115, 8, 16, 23, 59, 0)));
		fechasAsoc.add(new FechaAsociada(new Date(115, 8, 17, 23, 59, 0)));
		fechasAsoc.add(new FechaAsociada(new Date(115, 8, 18, 19, 0, 0)));
		//promo4
		fechasAsoc.add(new FechaAsociada(new Date(115, 5, 13, 23, 59, 0)));
		fechasAsoc.add(new FechaAsociada(new Date(115, 5, 15, 23, 59, 0)));
		//las demas
		fechasAsoc.add(new FechaAsociada(new Date(115,6,5,20,0,0)));
		fechasAsoc.add(new FechaAsociada(new Date(115,2,27,17,0,0)));
		fechasAsoc.add(new FechaAsociada(new Date(115,11,1,23,59,0)));
		fechasAsoc.add(new FechaAsociada(new Date(115,7,31,18,0,0)));
		fechasAsoc.add(new FechaAsociada(new Date(115,3,15,23,59,0)));
		fechasAsoc.add(new FechaAsociada(new Date(115,4,1,23,59,0)));
		
		/*
		 * ARREGLO DE PROMOCIONES
		 * */
		promociones.add(new Promocion("promo1", 5280, 3800.50, "www.laespetada.com/promo", new Date(115, 2, 16, 23, 59, 23), ubgeo1));
		promociones.add(new Promocion("promo2", 3590, 2999.99, "www.laespetada.com/promo", new Date(115, 3, 20, 23, 59, 0), ubgeo2));
		// AGREGAR FECHAS ASOCIADAS 4 AL PROMO 3 Y 2 AL PROMO 4
		promociones.add(new Promocion("promo3", 6210, 4800.90, "www.aguieventos.co.ve", new Date(115, 8, 18, 19, 0, 0), ubgeo3));
		promociones.add(new Promocion("promo4", 9000, 4500, "www.aguieventos.co.ve", new Date(115, 5, 15, 23, 59, 0), ubgeo4));
		promociones.add(new Promocion("promo5", 2500, 1100.20, "zara.jimbo.com/descuentos", new Date(115,6,5,20,0,0), ubgeo5));
		promociones.add(new Promocion("promo6", 1500, 799.99, "zara.jimbo.com/descuentos", new Date(115,2,27,17,0,0), ubgeo6));		
		promociones.add(new Promocion("promo7", 3640, 2420.36, "lisandrax-airlines.com", new Date(115,11,1,23,59,0), ubgeo7));		
		promociones.add(new Promocion("promo8", 2340, 1799.40, "lisandrax-airlines.com", new Date(115,7,31,18,0,0), ubgeo8));		
		promociones.add(new Promocion("promo9", 3150.35, 2499.49, "www.hnoscasta.org", new Date(115,3,15,23,59,0), ubgeo9));		
		promociones.add(new Promocion("promo10", 4320, 3600.89, "www.hnoscasta.org", new Date(115,4,1,23,59,0), ubgeo10));
		
		/*
		 * ARREGLO DE COMPRAS
		 * */		
		//compras 0-9 promo con compra, todas con ValesPromo
		compras.add(new Compra(2, 2*3800.50, new Date(115, 1, 28, 15, 47, 3)));		
		compras.add(new Compra(1, 2999.99, new Date(115, 2, 8, 10, 50, 30)));		
		compras.add(new Compra(4, 4*4800.90, new Date(115, 3, 11, 12, 28, 0)));
		compras.add(new Compra(1, 4500, new Date(115, 2, 27, 9, 43, 10)));		
		compras.add(new Compra(3, 3*1100.20, new Date(115, 5, 30, 11, 3, 57)));		
		compras.add(new Compra(1, 799.99, new Date(115, 2, 20, 21, 30, 7)));
		compras.add(new Compra(2, 2*2420.36, new Date(115, 8, 16, 18, 38, 12)));
		compras.add(new Compra(1, 1799.40, new Date(115, 4, 3, 6, 5, 16)));
		compras.add(new Compra(1, 2499.49, new Date(115, 1, 28, 13, 49, 17)));
		compras.add(new Compra(3, 3*3600.89, new Date(115, 2, 11, 14, 19, 40)));
		// compras 10-14 promo con compra, todas valesRegalo
		compras.add(new Compra(1, 3800.50, new Date(115, 2, 10, 11, 27, 30)));				
		compras.add(new Compra(1, 4800.90, new Date(115, 6, 30, 16, 58, 0)));
		compras.add(new Compra(1, 1100.20, new Date(115, 4, 14, 8, 16, 5)));		
		compras.add(new Compra(1, 2420.36, new Date(115, 8, 9, 8, 40, 12)));
		compras.add(new Compra(1, 2499.49, new Date(115, 1, 26, 15, 58, 37)));
				
		/*
		 * ARREGLO DE VALES PROMOCIONES
		 * */			
		// 0-9
		valesPromos.add(new ValePromocion(2, "este es un vale de la primera (1) compra", "juanju@gmail.com", false, new Date(115, 2, 16, 23, 59, 23)));
		valesPromos.add(new ValePromocion(1, "este es un vale de la segunda (2) compra", "pedro@gmail.com", false, new Date(115, 3, 20, 23, 59, 0)));
		valesPromos.add(new ValePromocion(4, "este es un vale de la tercera (3) compra", "rosGerm@gmail.com", false, new Date(115, 8, 18, 19, 0, 0)));
		valesPromos.add(new ValePromocion(1, "este es un vale de la cuarta (4) compra", "daug@gmail.com", false, new Date(115, 5, 15, 23, 59, 0)));
		valesPromos.add(new ValePromocion(3, "este es un vale de la quinta (5) compra", "bautistaC@gmail.com", false, new Date(115,6,5,20,0,0)));
		valesPromos.add(new ValePromocion(1, "este es un vale de la sexta (6) compra", "josemart@gmail.com", false, new Date(115,2,27,17,0,0)));
		valesPromos.add(new ValePromocion(2, "este es un vale de la septima (7) compra", "Rodigrez1342@gmail.com", false, new Date(115,11,1,23,59,0)));
		valesPromos.add(new ValePromocion(1, "este es un vale de la octava (8) compra", "daug@gmail.com", false, new Date(115,7,31,18,0,0)));
		valesPromos.add(new ValePromocion(1, "este es un vale de la novena (9) compra", "HernanGuedez@gmail.com", false, new Date(115,3,15,23,59,0)));
		valesPromos.add(new ValePromocion(3, "este es un vale de la decima (10) compra", "Rubyhornan1274@gmail.com", false, new Date(115,4,1,23,59,0)));
		// 10-14
		valesRegalos.add(new ValeRegalo(1, "este es un vale Regalo de la compra (11)", "pedro@gmail.com", false, new Date(115, 2, 16, 23, 59, 23),new Date(115, 2, 17, 2, 0, 0)));
		valesRegalos.add(new ValeRegalo(1, "este es un vale Regalo de la compra (12)", "rosGerm@gmail.com", false, new Date(115, 8, 18, 19, 0, 0),new Date(115, 8, 1, 0, 0, 0)));
		valesRegalos.add(new ValeRegalo(1, "este es un vale Regalo de la compra (13)", "CasemIro45@gmail.com", false, new Date(115,6,5,20,0,0),new Date(115, 5, 2, 8, 0, 0)));
		valesRegalos.add(new ValeRegalo(1, "este es un vale Regalo de la compra (14)", "RubenCarmona87@gmail.com", false, new Date(115,11,1,23,59,0),new Date(115, 10, 20, 12, 0, 0)));
		valesRegalos.add(new ValeRegalo(1, "este es un vale Regalo de la compra (15)", "nuestracasaDe52@gmail.com", false, new Date(115,3,15,23,59,0),new Date(115, 2, 1, 0, 0, 0)));
		
		
	}
	
	public static void setearAmigos(ArrayList<Usuario> usuarios){		
		usuarios.get(0).getAmigos().add(usuarios.get(1));
		usuarios.get(0).getAmigos().add(usuarios.get(2));
		usuarios.get(0).getAmigos().add(usuarios.get(3));
		usuarios.get(0).getAmigos().add(usuarios.get(4));
		
		usuarios.get(1).getAmigos().add(usuarios.get(3));
		usuarios.get(1).getAmigos().add(usuarios.get(4));
		
		usuarios.get(2).getAmigos().add(usuarios.get(4));
	}
	
	public static void setearRedesSocialesAUsuarios(ArrayList<Usuario> usuarios, ArrayList<UsuarioRedSocial> usuariosRedSocials){
				
		int tam = usuariosRedSocials.size();
		int uss = 0;
		for (int i=0; i<tam; i++){
			if ((i == 2) || (i==5) || (i==6) || (i==8)){
			uss+=1;
			}
			usuarios.get(uss).getURSocial().add(usuariosRedSocials.get(i));
			usuariosRedSocials.get(i).setUsuario(usuarios.get(uss));
						
		}
	}
	
	public static void setearMetodoDePagoAUsuarios(ArrayList<Usuario> usuarios, ArrayList<MetodoPago> metodoPago){
		
		int tam = metodoPago.size(); //8tdcs
		int uss = 0;
		for (int i=0; i<tam; i++){
			if (i<8){
				if ((i == 1) || (i==3) || (i==5) || (i==6) ){
					uss+=1;
				}
				usuarios.get(uss).getTdcs().add(metodoPago.get(i));
				metodoPago.get(i).setUsuarioTDC(usuarios.get(uss));
				if (i == 7) uss = 0;
			} else {
				usuarios.get(uss).getTdcs().add(metodoPago.get(i));
				metodoPago.get(i).setUsuarioDP(usuarios.get(uss));
			}	
		}
	}
	
	/****/public static void setearCategoriasUsuarios(ArrayList<Usuario> usuarios, ArrayList<Categoria> categorias){
				
		//usuario0
		usuarios.get(0).getCategorias().add(categorias.get(0));
		usuarios.get(0).getCategorias().add(categorias.get(1));
		usuarios.get(0).getCategorias().add(categorias.get(3));		
		/*categorias.get(0).getUsuarios().add(usuarios.get(0));
		categorias.get(1).getUsuarios().add(usuarios.get(0));
		categorias.get(3).getUsuarios().add(usuarios.get(0));
		*/
		//usuario1
		usuarios.get(1).getCategorias().add(categorias.get(2));
	//	categorias.get(2).getUsuarios().add(usuarios.get(1));
		
		//usuario2
		usuarios.get(2).getCategorias().add(categorias.get(0));
		usuarios.get(2).getCategorias().add(categorias.get(2));
		/*categorias.get(0).getUsuarios().add(usuarios.get(2));
		categorias.get(2).getUsuarios().add(usuarios.get(2));
		*/
		//usuario3
		usuarios.get(3).getCategorias().add(categorias.get(1));
		usuarios.get(3).getCategorias().add(categorias.get(2));
		usuarios.get(3).getCategorias().add(categorias.get(3));
		/*categorias.get(1).getUsuarios().add(usuarios.get(3));
		categorias.get(2).getUsuarios().add(usuarios.get(3));
		categorias.get(3).getUsuarios().add(usuarios.get(3));
		*/
		//usuario4
		usuarios.get(4).getCategorias().add(categorias.get(0));
		//categorias.get(0).getUsuarios().add(usuarios.get(4));

	}

	public static void setearSubcategoriasACategorias(ArrayList<Subcategoria> subcategorias, ArrayList<Categoria> categorias){
		
		int tam = subcategorias.size(); 
		int cat = 0;
		for (int i=0; i<tam; i++){			
			if ((i % 2 == 0) && i>=1){
				cat = cat+1;
			}
			categorias.get(cat).getSubcategorias().add(subcategorias.get(i));						
			subcategorias.get(i).setCategoria(categorias.get(cat));						
			
		}
	}
	
	/****/public static void setearCiudadAUsuarios(ArrayList<Usuario> usuarios, ArrayList<Ciudad> ciudades){
		
		//usuario0
		usuarios.get(0).getCiudades().add(ciudades.get(0));
		usuarios.get(0).getCiudades().add(ciudades.get(1));
		//ciudades.get(0).getUsuarios().add(usuarios.get(0));
		//ciudades.get(1).getUsuarios().add(usuarios.get(0));
		
		//usuario1
		usuarios.get(1).getCiudades().add(ciudades.get(1));
		usuarios.get(1).getCiudades().add(ciudades.get(2));
		//ciudades.get(1).getUsuarios().add(usuarios.get(1));
		//ciudades.get(2).getUsuarios().add(usuarios.get(1));
		
		//usuario2
		usuarios.get(2).getCiudades().add(ciudades.get(2));
		usuarios.get(2).getCiudades().add(ciudades.get(3));
		//ciudades.get(2).getUsuarios().add(usuarios.get(2));
		//ciudades.get(3).getUsuarios().add(usuarios.get(2));
		
		//usuario3
		usuarios.get(3).getCiudades().add(ciudades.get(3));
		usuarios.get(3).getCiudades().add(ciudades.get(4));
		//ciudades.get(3).getUsuarios().add(usuarios.get(3));
		//ciudades.get(4).getUsuarios().add(usuarios.get(3));
				
		//usuario4
		usuarios.get(4).getCiudades().add(ciudades.get(4));
		usuarios.get(4).getCiudades().add(ciudades.get(0));
		//ciudades.get(4).getUsuarios().add(usuarios.get(4));
		//ciudades.get(0).getUsuarios().add(usuarios.get(4));

	}
	
	public static void setearSubcategoriasAPromociones(ArrayList<Subcategoria> subcategorias, ArrayList<Promocion> promociones){
		
		int tam = promociones.size(); 
		int cat = 0;
		for (int i=0; i<tam; i++){			
			if (i == 8){
				cat = 0;
			}
			promociones.get(i).setSubcategoria(subcategorias.get(cat));	
			subcategorias.get(cat).getPromociones().add(promociones.get(i));
			cat++;
			
		}
	}
	
	public static void setearEmpresasAPromociones(ArrayList<Empresa> empresas, ArrayList<Promocion> promociones){
		
		int tam = promociones.size(); 
		int cat = 0;
		for (int i=0; i<tam; i++){			
			if (i==2 || i==4 || i==6 || i==8){
				cat = cat+1;
			}					
			empresas.get(cat).getPromociones().add(promociones.get(i));
			promociones.get(i).setEmpresa(empresas.get(cat));
		}
	}
	
	/****/public static void setearCiudadAPromociones(ArrayList<Promocion> promociones, ArrayList<Ciudad> ciudades){
		
		//SEGUN ESTO CADA PROMOCION TIENE 2 CIUDADES
		int tam=promociones.size();
		int maxciudades=ciudades.size();
		for (int i=0;i<tam;i++){
			
			promociones.get(i).getCiudades().add(ciudades.get(i % maxciudades));
			promociones.get(i).getCiudades().add(ciudades.get((i+1) % maxciudades));
			//promociones.get(i).getCiudades().add(ciudades.get((i+2) % maxciudades));
		}
		
		

	}
	/*METODOS MARCADOS CON ** ES PORQUE QUIZAS REQUIEREN AGREGARLE A LOS OBJETOS DESPUES DE SER INSERTADOS EN LA BD*/
	
	public static void setearFechasAPromociones(ArrayList<FechaAsociada> fechasAsoc, ArrayList<Promocion> promociones){
		
		int tam = fechasAsoc.size(); //8tdcs
		int prom = 0;
		for (int i=0; i<tam; i++){
			
			
			fechasAsoc.get(i).setPromocion(promociones.get(prom));
			promociones.get(prom).getFechasAsociadas().add(fechasAsoc.get(i));
			if (i >= 2 && i<=4){
				prom--;
			}
			if (i==6){
				prom = 2;
			}
			prom++;
		}
	}
	
	public static void setearValesConCompras(ArrayList<ValePromocion> valesPromos, ArrayList<ValeRegalo> valesRegalos,
											 ArrayList<Compra> compras){
		
		int tam = compras.size(); //8tdcs
		int regalo = 0;
		for (int i=0; i<tam; i++){
			if (i<10){
				compras.get(i).setVale(valesPromos.get(i));
				valesPromos.get(i).setCompra(compras.get(i));
			} else {
				compras.get(i).setVale(valesRegalos.get(regalo));
				valesRegalos.get(regalo).setCompra(compras.get(i));
				regalo++;
			}
			
		}
	}

	/****/public static void setearMetodoPagosConCompras(ArrayList<Compra> compras, ArrayList<MetodoPago> metodoPago, ArrayList<Usuario> usuarios){

		int tam = compras.size(); //8tdcs
		int tarjeta = 0;
		int uss = 0;
		for (int i=0; i<tam; i++){
			if (i % 3 == 0 && i>=1) uss++; 
			
			List<MetodoPago> list = new ArrayList<MetodoPago>(usuarios.get(uss).getTdcs());
			compras.get(i).setMetodoPagos(list.get(tarjeta));
		}
	}

	public static void setearUsuariosConCompras(ArrayList<Compra> compras, ArrayList<Usuario> usuarios){

		int tam = compras.size(); //8tdcs
		int uss = 0;
		for (int i=0; i<tam; i++){
			
			if (i % 3 == 0 && i>=1) uss++; 
			
			compras.get(i).setUsuario(usuarios.get(uss));
			usuarios.get(uss).getCompras().add(compras.get(i));
			
		}
	}
	
	public static void setearPromocionesConCompras(ArrayList<Compra> compras, ArrayList<Promocion> promociones){

		int tam = compras.size(); //8tdcs
		int prom = 0;
		for (int i=0; i<tam; i++){
			
			if (i == 10) prom=0; 
			if (i == 11) prom=2;
			if (i == 12) prom=4;
			if (i == 13) prom=6;
			if (i == 14) prom=8;			
			
			compras.get(i).setPromocion(promociones.get(prom));
			promociones.get(prom).getCompras().add(compras.get(i));
			prom++;
		}
	}
	
	public static void setearCompartidosConCompras(ArrayList<Compra> compras, ArrayList<Usuario> usuarios){
		
		// USUARIOS QUE COMPRARON UNA PROMOCION COMPARTIDA
		compras.get(0).getUsuariosCompartir().add(usuarios.get(3));
		compras.get(2).getUsuariosCompartir().add(usuarios.get(3));
		
		compras.get(12).getUsuariosCompartir().add(usuarios.get(1));
		compras.get(13).getUsuariosCompartir().add(usuarios.get(2));
		
		compras.get(14).getUsuariosCompartir().add(usuarios.get(2));
				
		// COMPRAS QUE FUERON COMPARTIDAS Y SE IGNORARON
		compras.get(0).getUsuariosCompartir().add(usuarios.get(2));
		compras.get(0).getUsuariosCompartir().add(usuarios.get(4));
		
		compras.get(1).getUsuariosCompartir().add(usuarios.get(1));
		
		compras.get(2).getUsuariosCompartir().add(usuarios.get(1));
		compras.get(2).getUsuariosCompartir().add(usuarios.get(4));
		
		
		compras.get(3).getUsuariosCompartir().add(usuarios.get(0));
		compras.get(3).getUsuariosCompartir().add(usuarios.get(4));
		
		compras.get(4).getUsuariosCompartir().add(usuarios.get(0));
		compras.get(4).getUsuariosCompartir().add(usuarios.get(3));
		
		compras.get(6).getUsuariosCompartir().add(usuarios.get(4));
		compras.get(8).getUsuariosCompartir().add(usuarios.get(4));
		compras.get(7).getUsuariosCompartir().add(usuarios.get(0));
		
		compras.get(9).getUsuariosCompartir().add(usuarios.get(0));
		compras.get(9).getUsuariosCompartir().add(usuarios.get(1));
		compras.get(10).getUsuariosCompartir().add(usuarios.get(1));
		compras.get(11).getUsuariosCompartir().add(usuarios.get(0));
		compras.get(11).getUsuariosCompartir().add(usuarios.get(1));
		
		compras.get(12).getUsuariosCompartir().add(usuarios.get(2));
		compras.get(13).getUsuariosCompartir().add(usuarios.get(0));
		compras.get(13).getUsuariosCompartir().add(usuarios.get(1));
		compras.get(14).getUsuariosCompartir().add(usuarios.get(1));
		
		/*usuarios.get(3).getComprasCompartidas().add(compras.get(0));
		usuarios.get(3).getComprasCompartidas().add(compras.get(2));

		usuarios.get(1).getComprasCompartidas().add(compras.get(12));
		usuarios.get(2).getComprasCompartidas().add(compras.get(13));
		
		usuarios.get(2).getComprasCompartidas().add(compras.get(14));
		*/
		

	}
	
	
	/********************************************************************************
	 * METODOS DE AGREGACION A LA BD 												*
	 * SE USAN SESIONES																*
	 ********************************************************************************/
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
	
	public void agregarCategorias(ArrayList<Categoria> categorias, SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = categorias.size(); 
		for (int i=0; i<tam; i++){						
			session.save(categorias.get(i));	
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void agregarSubcategorias(ArrayList<Subcategoria> subcategorias, SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = subcategorias.size(); 
		for (int i=0; i<tam; i++){						
			session.save(subcategorias.get(i));	
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarCiudades(ArrayList<Ciudad> ciudades,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = ciudades.size();
		for (int i=0; i<tam; i++){
			session.save(ciudades.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarUsuarios(ArrayList<Usuario> usuarios,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = usuarios.size();
		for (int i=0; i<tam; i++){
			session.save(usuarios.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
		
	public void agregarRedesSocialesAUsuarios(ArrayList<UsuarioRedSocial> usuariosRedSocials,
											  SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = usuariosRedSocials.size();
		for (int i=0; i<tam; i++){			
			session.save(usuariosRedSocials.get(i));					
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarMetodoPago(ArrayList<MetodoPago> metodoPago,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = metodoPago.size();
		for (int i=0; i<tam; i++){
			session.save(metodoPago.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarFechasAsocAPromociones(ArrayList<FechaAsociada> fechasAsoc, SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = fechasAsoc.size();
		for (int i=0; i<tam; i++){			
			session.save(fechasAsoc.get(i));					
		}
		
		session.getTransaction().commit();
		session.close();
	
	}
	
	public void agregarPromocion(ArrayList<Promocion> promociones,SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = promociones.size();
		for (int i=0; i<tam; i++){
			session.save(promociones.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarVales(ArrayList<ValePromocion> valesPromos, ArrayList<ValeRegalo> valesRegalos,
							 SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = valesPromos.size();
		for (int i=0; i<tam; i++){
			session.save(valesPromos.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		tam = valesRegalos.size();
		for (int i=0; i<tam; i++){
			session.save(valesRegalos.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		session.getTransaction().commit();
		session.close();

	}
	
	public void agregarCompras(ArrayList<Compra> compras, SessionFactory sessionFactory){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int tam = compras.size();
		for (int i=0; i<tam; i++){
			session.save(compras.get(i));
			//System.out.println("Empresa = \n"+empresas.get(i).getNombreEmpresa());			
		}
		
		
		session.getTransaction().commit();
		session.close();
	
	}

	
}
