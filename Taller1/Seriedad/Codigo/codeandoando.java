//Integrante 1: Matías Nicolás Núñez González - 22.256.666-5 - Manugooo
package Codigo;

import java.io.File;
import java.util.Scanner;

public class codeandoando {
	public static void main(String[] args) {
		String[] usuarios = null;
		String[] contraseñas = null;
		String[] usuarioregistro = null;
		String[] fechas;
		String[] horas = null;
		String[] actividad = null;
		String[] actividades = new String[300];
		int[] horasporactividad = new int[300];
		int j2 = 0;
		int contadoreleccion2 = 0;
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
		if (eleccion.equals("1")) {
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
			// Desarrollo menu de usuario
			System.out.println("Bienvenido " + nomusuario + "!");
			System.out.println("");
			System.out.println("Que deseas realizar?");
			System.out.println("1) Registrar actividad.");
			System.out.println("2) Modificar actividad.");
			System.out.println("3) Eliminar actividad.");
			System.out.println("4) Cambiar contraseña.");
			System.out.println("5) Salir.");
			Scanner entradamenu = new Scanner(System.in);
			String eleccionmenu = entradamenu.nextLine();
			while (!eleccionmenu.equals("1") && !eleccionmenu.equals("2") && !eleccionmenu.equals("3")
					&& !eleccionmenu.equals("4") && !eleccionmenu.equals("5")) {
				System.out.println("Error, Ingrese una opción válida:");
				eleccionmenu = entradamenu.nextLine();
			}

			if (eleccionmenu.equals("5")) {
				System.out.println("Has salido del programa exitosamente");
				System.exit(0);
			}
		}
		if (eleccion.equals("2")) {
			while (true) {
				System.out.println("");
				System.out.println("Bienvenido al menú de analisis!");
				System.out.println(" ");
				System.out.println("1) Actividad más realizada");
				System.out.println("2) Actividad más realizada por cada usuario");
				System.out.println("3) Usuario con mayor procastinación");
				System.out.println("4) Ver todas las actividades");
				System.out.println("5) Salir");
				Scanner entradaeleccion2 = new Scanner(System.in);
				String eleccion2 = entradaeleccion2.nextLine();
				while (!eleccion2.equals("1") && !eleccion2.equals("2") && !eleccion2.equals("3") && !eleccion2.equals("4")
						&& !eleccion2.equals("5")) {
					System.out.println("Error, Ingrese una opción válida:");
					eleccion2 = entradaeleccion2.nextLine();
				}
				// En esta parte ya comienzo a trabajar con las listas paralelas de actividades
				// y cuntas veces se repiten, para sacar la más realizada
				if (eleccion2.equals("1")) {
					for (int i3 = 0; i3 < j2; i3 += 1) {
						String actividadactual = actividad[i3];
						boolean encontrado = false;
						for (int k = 0; k < contadoreleccion2; k += 1) {
							if (actividades[k].equals(actividadactual)) {
								horasporactividad[k] += Integer.parseInt(horas[k]);
								encontrado = true;
								break;
							}
						}
						if (!encontrado) {
							actividades[contadoreleccion2] = actividadactual;
							horasporactividad[contadoreleccion2] = Integer.parseInt(horas[i3]);
							contadoreleccion2 += 1;
						}
					}
					int max = horasporactividad[0];
					String actividadmax = actividades[0];
					for (int i = 1; i < contadoreleccion2; i += 1) {
						if (horasporactividad[i] > max) {
							max = horasporactividad[i];
							actividadmax = actividades[i];
						}
					}
					System.out.println("La actividad más realizada es: " + actividadmax);
				}
				if (eleccion2.equals("2")) {
					System.out.println("Actividades más realizadas por cada usuario: ");
					System.out.println("");
					// ahora comienzo con mi desarrollo para la opcion 2
					for (int o = 0; o < usuarios.length; o += 1) {
						String usuarioactual = usuarios[o];
						String[] actividadesusuario = new String[j2];
						int[] horasusuario = new int[j2];
						int[] contadorusuario = new int[j2];
						int actividadesunicas = 0;
		
						for (int p = 0; p < j2; p += 1) {
							if (usuarioregistro[p].equals(usuarioactual)) {
								String actividadactual = actividad[p];
								int añadirhoras = Integer.parseInt(horas[p]);
								boolean encontrado = false;
								for (int q = 0; q < actividadesunicas; q += 1) {
									if (actividadesusuario[q].equals(actividadactual)) {
										horasusuario[q] += añadirhoras;
										encontrado = true;
										break;
									}
								}
									if (!encontrado) {
										actividadesusuario[actividadesunicas] = actividadactual;
										horasusuario[actividadesunicas] = añadirhoras;
										actividadesunicas += 1;
									}
							}
						}
						if (actividadesunicas > 0) {
							int maxhoras = horasusuario[0];
							String actividadmaxusuario = actividadesusuario[0];
							for (int r = 1; r < actividadesunicas; r += 1) {
								if (horasusuario[r] > maxhoras) {
									maxhoras = horasusuario[r];
									actividadmaxusuario = actividadesusuario[r];
								}
							}
							System.out.println("* " + usuarioactual + " -> " + actividadmaxusuario + " -> con  " + maxhoras
									+ " horas registradas");
						}
					}
				}
				if (eleccion2.equals("5")) {
					System.out.println("Has salido del programa exitosamente");
					System.exit(0);
				}
			}
		}
		if (eleccion.equals("3")) {
			System.out.println("Has salido del programa exitosamente");
			System.exit(0);
			}
		}
}