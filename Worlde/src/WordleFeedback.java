public class WordleFeedback {

    																			// Códigos ANSI para colores en la consola
    public static final String ANSI_RESET = "\u001B[0m";    					// Restablece color
    public static final String ANSI_GREEN = "\u001B[32m";  						// Verde
    public static final String ANSI_YELLOW = "\u001B[33m";  					// Amarillo
    public static final String ANSI_GRAY = "\u001B[90m";   						// Gris

    private static String applyColor(char letter, String color) {				// Aplica color a una letra y restablece color al final
        return color + letter + ANSI_RESET; 									
    }

    public static String feedBackString(String guess, String secretWord) {	    // Revisa cada letra de la palabra que se ha escrito 
        StringBuilder feedback = new StringBuilder(); 							// Objeto para construir la cadena de feedback
        boolean[] usedInSecret = new boolean[secretWord.length()]; 				// Array para rastrear letras ya usadas en la palabra secreta
        
        for (int i = 0; i < guess.length(); i++) { 								// Itera sobre cada letra de la palabra ingresada
            char letter = guess.charAt(i);										// Obtiene la letra actual

            if (letter == secretWord.charAt(i)) { 								// Si la letra está en la posición correcta
                feedback.append(applyColor(letter, ANSI_GREEN));				// La marca verde 
                usedInSecret[i] = true; 										// Indica que la posicion ha sido usada
            } else {
                boolean found = false;											// Verificar si la letra está en otra posición
                for (int j = 0; j < secretWord.length(); j++) {					// Recorre la palabra secreta
                    if (!usedInSecret[j] && secretWord.charAt(j) == letter) {	// Si encuentra la letra en otra posición
                        feedback.append(applyColor(letter, ANSI_YELLOW));		// La marca como amarilla
                        usedInSecret[j] = true; 								// Marca esa posición como usada
                        found = true;
                        break;													// Sale del bucle para no marcar más
                    }
                }

                if (!found) {													// Si la letra no está en la palabra secreta
                    feedback.append(applyColor(letter, ANSI_GRAY));				// La marca como gris
                }
            }
        }
      
        return feedback.toString(); 											// Devuelve la cadena de feedback coloreada
    }
}
