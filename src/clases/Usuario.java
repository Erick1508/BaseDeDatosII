package clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// falta el atributo multivaluado
public class Usuario {
	//id
	private String login;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private int veces_accedidas;
	private Date ult_vez_online;
	
	// asociacion 1-* con TDC
	private Set<TDC> tdcs = new HashSet<TDC>(0);
	
	//asociacion 1-1 con dinero Promocion
	private DineroPromocion DinProm;
	
	// asociacion *->* es_amigo
	private Set<Usuario> usuarios = new HashSet<Usuario>();
    private Set<Usuario> amigos = new HashSet<Usuario>();
	
    // asociacion *->* con ciudad
    private Set<Ciudad> ciudades = new HashSet<Ciudad>();
    
    // asociacion *->* con Categoria
    private Set<Categoria> categorias = new HashSet<Categoria>();
    
    // asociacion 1->1..* con UsuarioRedSocial
    private Set<UsuarioRedSocial> URSocial = new HashSet<UsuarioRedSocial>(0);
    
	// asociacion adquiere, es la clase asociacion con Compra
    private Set<Compra> compras = new HashSet<Compra>();
    
    // asociacion *-* con Compra
    private Set<Compra> ComprasCompartidas = new HashSet<Compra>();
    
	public Usuario(String login, String password, String nombre,
			String apellido, String email, Date ult_vez_online) {
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.ult_vez_online = ult_vez_online;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVeces_accedidas() {
		return veces_accedidas;
	}

	public void setVeces_accedidas(int veces_accedidas) {
		this.veces_accedidas = veces_accedidas;
	}

	public Date getUlt_vez_online() {
		return ult_vez_online;
	}

	public void setUlt_vez_online(Date ult_vez_online) {
		this.ult_vez_online = ult_vez_online;
	}

	public Set<Ciudad> getCiudades() {
		return ciudades;
	}
	
	public void setCiudades(Set<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<UsuarioRedSocial> getURSocial() {
		return URSocial;
	}

	public void setURSocial(Set<UsuarioRedSocial> uRSocial) {
		URSocial = uRSocial;
	}

	public DineroPromocion getDinProm() {
		return DinProm;
	}

	public void setDinProm(DineroPromocion dinProm) {
		DinProm = dinProm;
	}

	public Set<TDC> getTdcs() {
		return tdcs;
	}

	public void setTdcs(Set<TDC> tdcs) {
		this.tdcs = tdcs;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Set<Compra> getComprasCompartidas() {
		return ComprasCompartidas;
	}

	public void setComprasCompartidas(Set<Compra> comprasCompartidas) {
		ComprasCompartidas = comprasCompartidas;
	}
	
	
}
