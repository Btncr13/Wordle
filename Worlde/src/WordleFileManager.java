import java.io.*; 																		// Para trabajar con archivos
import java.nio.charset.StandardCharsets;
import java.util.*; 																	// Para trabajar con listas (ArrayList)

public class WordleFileManager {
	
	public static ArrayList<String> cargarPalabras(String nombreArchivo) {   			// Método que carga palabras desde un archivo y las devuelve como una lista
    	
		ArrayList<String> palabras = new ArrayList<>();   								// Crea una lista vacía para guardar las palabras
    	
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {   // Abre el archivo con BufferedReader para leer línea por línea
        	String linea;   															// Variable para guardar cada línea del archivo
        	
        	while ((linea = br.readLine()) != null) {   								// Lee una palabra. Si no es nula, sigue leyendo
        		palabras.add(linea.trim().toLowerCase());  								// Añade la palabra a la lista en minúsculas y sin espacios extra
        	}
        } catch (IOException e) {   													// Si ocurre un error al leer el archivo, muestra un mensaje en la consola
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return palabras;  																// Devuelve la lista con las palabras cargadas
    }
	
    public static void guardarPartida(String texto, String nombreArchivo) {				// Método para guardar texto en un archivo
    
    	 try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo, true), StandardCharsets.UTF_8))) {
    	        String textoSinColores = texto.replaceAll("\u001B\\[[;\\d]*m", ""); 	// Elimina códigos ANSI
    	        writer.write(textoSinColores);
    	        writer.newLine();
    	    } catch (IOException e) {
    	        System.out.println("\u001B[31m❌ Error al guardar la partida: " + e.getMessage() + "\u001B[0m");
    	    }
    	}
}
