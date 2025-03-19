import java.util.ArrayList;
import java.util.Random;																						// Seleccionar palabras al azar
import java.util.Scanner;

public class WordleGame {
    private String secretWord;   																				// Palabra secreta
    private int remainingAttempts;   																			// Intentos restantes
    private ArrayList<String> triesHistory; 																	// Historial de palabras intentadas
    private static final int MAX_TRIES = 6;																		// Número máximo de intentos
    private static final int WORD_LENGTH = 5;																	// Longitud de la palabra en el juego
 
    public WordleGame(ArrayList<String> fileWords) {															// Constructor que recibe la lista de palabras
        this.secretWord = ""; 																					// Inicializamos la palabra secreta
        this.remainingAttempts = MAX_TRIES; 																	// Asigna el número máximo de intentos
        this.triesHistory = new ArrayList<>();																	// Inicializa el historial de intentos
        
        fileWords.removeIf(word -> word.length() != WORD_LENGTH);												// Filtra las palabras que no tienen la longitud adecuada
    }

    public void selectRandomWord(String[] words) { 																// Metodo que elecciona una palabra aleatoria de la lista.
        Random random = new Random(); 																			// Crea un objeto Random
        int index = random.nextInt(words.length); 																// Obtener un índice aleatorio para elegir palabra
        this.secretWord = words[index]; 																		// Asigna la palabra secreta
    }

    private String getUserInput(Scanner scanner) {																// Obtiene la entrada del usuario y valida que tenga la longitud adecuada
        while (true) {
            System.out.print("\nIntroduce una palabra: ");
            String palabra = scanner.nextLine().toLowerCase();													// Convierte la entrada a minúsculas

            if (palabra.length() != WORD_LENGTH) {																// Verifica la longitud de la palabra
                System.out.println("\u001B[31mError: La palabra debe tener " + WORD_LENGTH + " letras.\u001B[0m");
            } else {
                return palabra; 																				// Devuelve la palabra si cumple con la longitud
            }
        }
    }
    
    private void showTriesHistory() {																			//Muestra el historial de intentos previos
    	  if (triesHistory.isEmpty()) {
              System.out.println("Aún no has hecho ningún intento.");
          } else {
        	  for (String palabra : triesHistory) {
                  System.out.println(WordleFeedback.feedBackString(palabra, secretWord)); // Aplica los colores del Wordle
              }
          }
    }	
    public void start() {   																					// Método principal del juego
    	 
    	Scanner scanner = new Scanner(System.in); 																// Para leer la entrada del usuario
    	String mensajeInicio = "\u001B[32m¡ ¡ ¡ ¡ ¡ ¡Bienvenido a Wordle! ! ! ! ! !\u001B[0m \nTienes " + remainingAttempts + " intentos.";
    	System.out.println(mensajeInicio);
    	WordleFileManager.guardarPartida(mensajeInicio, "partida.txt");
    	
            while (remainingAttempts > 0) { 																	// Mientras queden intentos
            	String palabra = getUserInput(scanner); 														// Usar el método para obtener y validar la entrada

                if (palabra.equals(secretWord)) { 																// Si es correcta
                	String mensajeGanador = "\n\u001B[32m¡ ¡ ¡ ¡ ¡ ¡Felicidades! ! ! ! ! ! \nHas adivinado la palabra: \u001B[0m" + secretWord;
                	System.out.println(mensajeGanador);
                	WordleFileManager.guardarPartida(mensajeGanador, "partida.txt");							// Guarda el resultado en un archivo
                    break;
                } else { 																						// Si no es correcta
                	triesHistory.add(palabra); 																	// Añadir al historial
                    remainingAttempts--; 																		// Reducir intentos
                    String mensajeIntento = WordleFeedback.feedBackString(palabra, secretWord) + 
                    		"\nIntentos restantes: " + remainingAttempts;
                  // System.out.println(mensajeIntento);
                    WordleFileManager.guardarPartida(mensajeIntento, "partida.txt");
                    System.out.println("\nIntentos restantes: " + remainingAttempts);
                    
                    showTriesHistory(); 																		// Mostrar el historial de intentos
                }
            }
            if (remainingAttempts == 0) {																		// Si se acaban los intentos
            	String mensajePerdedor = "¡Has perdido! La palabra secreta era: " + secretWord;
            	System.out.println(mensajePerdedor);
            	WordleFileManager.guardarPartida(mensajePerdedor, "partida.txt");								// Guarda el resultado en el archivo
                showTriesHistory(); 																			// Muestra el historial de intentos
            }
        scanner.close(); 																					// Cerrar el Scanner para liberar recursos
    }									
}
