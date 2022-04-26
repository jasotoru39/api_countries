package main;

import java.io.*;
import java.util.*;

public class Fichero {

	public static void main(String[] args) {

		crearArchivo("directorio", "fichero");
		buscarTexto("fichero", "Perro");
	}

	public static void crearArchivo(String directorio, String fichero) {

		File folder = new File("src/" + directorio);
		File file = new File("src/" + directorio + "/" + fichero + ".txt");

		ArrayList<String> lista = new ArrayList<>();

		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");

		Collections.shuffle(lista);

		if (!(folder.exists())) {
			folder.mkdir();
		// System.out.println("El directorio se ha creado");

			try {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < lista.size(); i++) {
					bw.write(lista.get(i) + "\r\n");
				}
				bw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al escribir el archivo " + e.getMessage());
			}
		} else {
			System.out.println("Error al crear el directorio");
		}
	}

	public static void buscarTexto(String nombreArchivo, String texto) {

		File f = new File("src/directorio/" + nombreArchivo + ".txt");

		String linea = "";
		int contador = 0;

		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				while ((linea = br.readLine()) != null) {
					if (linea.equals(texto)) {
						contador++;
					}
				}
				br.close();
				System.out.println("Cantidad de repeticiones del texto -> " + contador);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en la lectura del archivo" + e.getMessage());
			}
		} else {
			System.out.println("El fichero ingresado no existe");
		}
	}
}
