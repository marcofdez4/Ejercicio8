package aop.model;

import java.time.LocalDate;

public class Usuario extends Persona{

	private String username;
	private String email;
	
	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String username, String email) {
		super(nombre, apellido, fechaNacimiento);
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
