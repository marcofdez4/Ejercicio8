package aop.funcionUsuarios;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import aop.model.Usuario;

@Component
public class AccionesUsuario {

	public Usuario registroDeUsuarios(Scanner sc) {
		System.out.println("Ingresando usuario...");
		System.out.println("Nombre: ");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Apellido: ");
		String apellido = sc.nextLine();
		System.out.println("fecha nacimiento (dd/mm/YYYY): ");
		Boolean fechaCorrecta = false;
		LocalDate fecha = null;
		while(!fechaCorrecta) {
			String fechaNacimiento = sc.nextLine();
			String[] fechaArray = fechaNacimiento.split("/");
			try {
				fecha = LocalDate.of(Integer.valueOf(fechaArray[2]), 
						Integer.valueOf(fechaArray[1]), Integer.valueOf(fechaArray[0]));
				fechaCorrecta=true;
			} 
			catch(Exception e) {
				continue;
			}
			
		}
		System.out.println("nombre de usuario: ");
		String username = sc.nextLine();
		System.out.println("email: ");
		String email = sc.nextLine();
		
		Usuario user = new Usuario(nombre, apellido, fecha, username, email);
		return user;
	}
	
	public Integer calculaEdad(LocalDate fecha) {
		Long edad = ChronoUnit.YEARS.between(fecha, LocalDate.now());
		return edad.intValue();
	}
}
