import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> palabras = WordleFileManager.cargarPalabras("palabras.txt");	// Carga la lista de palabras desde un archivo
        WordleGame game = new WordleGame(palabras);										// Crea una instancia del juego con las palabras cargadas
        
        String[] wordsArray = palabras.toArray(new String[0]);							// Convierte la lista de palabras en un array
        game.selectRandomWord(wordsArray); 												// Selecciona una palabra aleatoria como palabra secreta
        game.start(); 																	// Iniciar el juego
    }
}
