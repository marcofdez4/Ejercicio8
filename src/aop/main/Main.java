package aop.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aop.configuration.ConfiguracionUsuarioAspecto;
import aop.funcionUsuarios.AccionesUsuario;
import aop.model.Usuario;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfiguracionUsuarioAspecto.class); 
		context.scan("aop.funcionUsuarios", "aop.aspectos", "aop.model");  
		context.refresh();
		AccionesUsuario ua = context.getBean(AccionesUsuario.class);
		
		Scanner sc = new Scanner(System.in);

		List<Usuario> users = new ArrayList<Usuario>();
		
		int menu = 99;
		while(menu!=0) {
			System.out
			.println("Ingrese una operacion:\n" + "1. Registrar usuario\n" +"2. Ver lista de usuarios\n"+ "3. Ver edades de la lista de usuarios\n" + "0. Salir");
			
			menu = sc.nextInt();
			switch (menu) {
			case 0:
				break;
			case 1:
				users.add(ua.registroDeUsuarios(sc)); 
				break;
			case 2:
				if(users.isEmpty()) {
					System.out.println("La lista esta vacía!");
				}
				else {
					System.out.println("La lista de usuario es:");
					for(Usuario u:users) {
						System.out.println(u.getUsername());
					}
				}
				break;
			case 3:
				if(users.isEmpty()) {
					System.out.println("La lista esta vacía!");
				}
				else {
					System.out.println("La lista de las edades de los usuarios es:");
					for(Usuario u:users) {
						System.out.println("-----------");
						System.out.println("El usuario "+u.getUsername()+"tiene "+ua.calculaEdad(u.getFechaNacimiento())+" anyos");
					}
					
				}
				break;
			default:
				System.out.println("numero erroneo, inserte otro numero de la lista");
			}	
			System.out.println("-------------------------------------------------");
		}
		
		sc.close();
		context.close();
		System.out.println("Fin del programa, tenga un buen dia!");
	}
}
