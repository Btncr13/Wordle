import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> palabras = WordleFileManager.cargarPalabras("palabras.txt");
        WordleGame game = new WordleGame(palabras);
        
        String[] wordsArray = palabras.toArray(new String[0]);
        game.selectRandomWord(wordsArray); // Seleccionar la palabra secreta
        game.start(); // Iniciar el juego
    }
}