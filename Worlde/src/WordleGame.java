import java.util.ArrayList;
import java.util.Random;																						// Seleccionar palabras al azar
import java.util.Scanner;

public class WordleGame {
    private String secretWord;   																				// Palabra secreta
    private int remainingAttempts;   																			// Intentos restantes
    private ArrayList<String> triesHistory; 																	// Historial de palabras intentadas
    private static final int MAX_TRIES = 6;
    private static final int WORD_LENGTH = 5;
    
    public WordleGame(ArrayList<String> fileWords) {															// Constructor que recibe la lista de palabras
        this.secretWord = ""; 																					// Inicializamos la palabra secreta
        this.remainingAttempts = MAX_TRIES; 																	// Número máximo de intentos
        this.triesHistory = new ArrayList<>();
        
        fileWords.removeIf(word -> word.length() != WORD_LENGTH);
    }

    public void selectRandomWord(String[] words) { // Método único
        Random random = new Random(); // Crear un objeto Random
        int index = random.nextInt(words.length); // Obtener un índice aleatorio
        this.secretWord = words[index]; // Asignar la palabra secreta
    }

    private String getUserInput(Scanner scanner) {
        while (true) {
            System.out.print("Introduce una palabra: ");
            String palabra = scanner.nextLine().toLowerCase();

            // Validar la longitud de la palabra
            if (palabra.length() != WORD_LENGTH) {
                System.out.println("Error: La palabra debe tener " + WORD_LENGTH + " letras.");
            } else {
                return palabra; // Devuelve la palabra si cumple con la longitud
            }
        }
    }
    
    private void showTriesHistory() {
        if (triesHistory.isEmpty()) {
            System.out.println("Aún no has hecho ningún intento.");
        } else {
            System.out.println("Historial de intentos: " + triesHistory);
        }
    }
    	
    public void start() {   																					// Método principal del juego
    	Scanner scanner = new Scanner(System.in); 																// Para leer la entrada del usuario
    	String mensajeInicio = "¡Bienvenido a Wordle! Tienes " + remainingAttempts + " intentos.";
    	System.out.println(mensajeInicio);
    	WordleFileManager.guardarPartida(mensajeInicio, "partida.txt");
        
            while (remainingAttempts > 0) { 																	// Mientras queden intentos
            	String palabra = getUserInput(scanner); 														// Usar el método para obtener y validar la entrada

                if (palabra.equals(secretWord)) { 																// Si es correcta
                	String mensajeGanador = "¡Felicidades! Has adivinado la palabra: " + secretWord;
                	System.out.println(mensajeGanador);
                	WordleFileManager.guardarPartida(mensajeGanador, "partida.txt");
                    break;
                } else { 																						// Si no es correcta
                	triesHistory.add(palabra); 																	// Añadir al historial
                    remainingAttempts--; 																		// Reducir intentos
                    String mensajeIntento = "Intento: " + palabra + " | Feedback: " + 
                    		WordleFeedback.feedBackString(palabra, secretWord) + 
                    		" | Intentos restantes: " + remainingAttempts;
                    System.out.println(mensajeIntento);
                    WordleFileManager.guardarPartida(mensajeIntento, "partida.txt");
                    showTriesHistory(); 																		// Mostrar el historial de intentos
                }
            }

            if (remainingAttempts == 0) {
            	String mensajePerdedor = "¡Has perdido! La palabra secreta era: " + secretWord;
            	System.out.println(mensajePerdedor);
            	WordleFileManager.guardarPartida(mensajePerdedor, "partida.txt");
                showTriesHistory(); // Mostrar el historial de intentos
            }
            
            
            scanner.close(); 																					// Cerrar el Scanner
    }									
}