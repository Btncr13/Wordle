public class WordleFeedback {

    // Códigos ANSI para colores en la consola
    public static final String ANSI_RESET = "\u001B[0m";    // Restablece color
    public static final String ANSI_GREEN = "\u001B[32m";   // Verde (letra en posición correcta)
    public static final String ANSI_YELLOW = "\u001B[33m";  // Amarillo (letra en palabra, pero en mala posición)
    public static final String ANSI_GRAY = "\u001B[90m";    // Gris (letra no está en la palabra)

    private static String applyColor(char letter, String color) {
        return color + letter + ANSI_RESET; 									// Aplica color y luego lo restablece
    }

    public static String feedBackString(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder(); 							// Construcción directa del feedback
        boolean[] usedInSecret = new boolean[secretWord.length()]; 				// Rastrea letras usadas en la palabra secreta

        for (int i = 0; i < guess.length(); i++) { 								// Paso 1: Construir el feedback letra por letra
            char letter = guess.charAt(i);

            if (letter == secretWord.charAt(i)) { 								// Letra en posición correcta (verde)
                feedback.append(applyColor(letter, ANSI_GREEN));	
                usedInSecret[i] = true; 										// Marcar posición como usada
            } else {
                boolean found = false;											// Verificar si la letra está en otra posición (amarillo)
                for (int j = 0; j < secretWord.length(); j++) {
                    if (!usedInSecret[j] && secretWord.charAt(j) == letter) {
                        feedback.append(applyColor(letter, ANSI_YELLOW));
                        usedInSecret[j] = true; 								// Marcar como usada
                        found = true;
                        break;
                    }
                }

                if (!found) {													// Si no se encuentra, marcar como gris
                    feedback.append(applyColor(letter, ANSI_GRAY));
                }
            }
        }
       

        return feedback.toString(); 											// Devolver el feedback completo
    }
}
