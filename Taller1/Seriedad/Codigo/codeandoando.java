//Integrante 1: Matías Nicolás Núñez González - 22.256.666-5 - Manugooo


package Codigo;

import java.io.File;
import java.util.Scanner;

public class codeandoando {
	public static void main(String[] args) {
		String[] usuarios = null;
		String[] contraseñas = null;
		String[] usuarioregistro;
		String[] fechas;
		String[] horas;
		String[] actividad;

		File archivo = new File("archivos/Usuarios.txt");
		try {
			// busco la dimensión de mis arreglos
			Scanner contador = new Scanner(archivo);
			int i = 0;

			while (contador.hasNextLine()) {
				contador.nextLine();
				i += 1;

			}
			contador.close();
//			System.out.println(i);

			// creación de arreglos
			usuarios = new String[i];
			contraseñas = new String[i];
			Scanner lectura = new Scanner(archivo);
			int j = 0;

			while (lectura.hasNextLine()) {
				String linea = lectura.nextLine();
				String[] partes = linea.split(";");
				usuarios[j] = partes[0];
				contraseñas[j] = partes[1];
				j += 1;
			}
			lectura.close();

//			for (int k = 0; k < i; k += 1) {
//				System.out.println(usuarios[k] + ";" + contraseñas[k]);
//			}
		} catch (Exception e) {
			System.out.println("Error en la lectura de archivo");
		}
		File archivo2 = new File("archivos/Registros.txt");
		try {
			// busco la dimensión de mis arreglos
			Scanner contador2 = new Scanner(archivo2);
			int i2 = 0;

			while (contador2.hasNextLine()) {
				contador2.nextLine();
				i2 += 1;

			}
			contador2.close();
//			System.out.println(i2);

			// creación de arreglos
			usuarioregistro = new String[i2];
			fechas = new String[i2];
			horas = new String[i2];
			actividad = new String[i2];
			Scanner lectura2 = new Scanner(archivo2);
			int j2 = 0;

			while (lectura2.hasNextLine()) {
				String linea2 = lectura2.nextLine();
				String[] partes2 = linea2.split(";");
				usuarioregistro[j2] = partes2[0];
				fechas[j2] = partes2[1];
				horas[j2] = partes2[2];
				actividad[j2] = partes2[3];
				j2 += 1;
			}
			lectura2.close();

//			for (int k2 = 0; k2 < i2; k2 +=1 ) {
//				System.out.println(usuarioregistro[k2] + ";" + fechas[k2] + ";" + horas[k2] + ";" + actividad[k2]);
//			}
		} catch (Exception e) {
			System.out.println("Error en la lectura de archivo");
		}
		// Inicio del menú
		System.out.println("1) Menu de Usuarios");
		System.out.println("2) Menu de Analisis");
		System.out.println("3) Salir");
		Scanner opcion = new Scanner(System.in);
		String eleccion = opcion.nextLine();
		while (!eleccion.equals("1") && !eleccion.equals("2") && !eleccion.equals("3")) {
			System.out.println("Error, Ingrese una opción válida:");
			eleccion = opcion.nextLine();
		}

		// Desarrollo de la opción 1

		if (eleccion.equals("1"))
			;
		{
			int posicionusuario = -1;
			Scanner entradausuario = new Scanner(System.in);
			String nomusuario = null;
			System.out.print("Usuario: ");
			boolean encontrado = false;
			while (!encontrado) {
				nomusuario = entradausuario.nextLine();
				encontrado = false;
				for (int l = 0; l < usuarios.length; l += 1) {
					if (usuarios[l].equals(nomusuario)) {
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					System.out.print("El usuario no existe en la base de datos, pruebe denuevo: ");
				}
			}
			for (int m = 0; m < usuarios.length; m += 1) {
				if (usuarios[m].equals(nomusuario)) {
					posicionusuario = m;
					break;
				}
			}
			Scanner entradacontraseña = new Scanner(System.in);
			String probarcontraseña;
			System.out.print("Contraseña: ");
			probarcontraseña = entradacontraseña.nextLine();
			while (!probarcontraseña.equals(contraseñas[posicionusuario])) {
				System.out.print("Contraseña incorrecta, pruebe denuevo: ");
				probarcontraseña = entradacontraseña.nextLine();
			}
			
			//Desarrollo menu de usuario
			System.out.println("Bienvenido" + nomusuario + "!");
			System.out.println("");
			System.out.println("Que deseas realizar?");
			System.out.println("1) Registrar actividad.");
			System.out.println("2) Modificar actividad.");
			System.out.println("3) Eliminar actividad.");
			System.out.println("4) Cambiar contraseña.");
			System.out.println("5) Salir.");
			

		}

	}
}
