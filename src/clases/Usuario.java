package clases;

import java.sql.Date;
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
	
    private Usuario persona;
    
    private Set<Usuario> amigos = new HashSet<Usuario>();
	
	public Usuario(String login, String password, String nombre,
			String apellido, String email, Date ult_vez_online) {
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.ult_vez_online = ult_vez_online;
	}

	public Usuario getPersona() {
		return persona;
	}

	public void setPersona(Usuario persona) {
		this.persona = persona;
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
	
	
}