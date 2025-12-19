# 🧩 Wordle Logic (Java CLI)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![CLI](https://img.shields.io/badge/Console-4EAA25?style=for-the-badge&logo=gnu-bash&logoColor=white)
![Logic](https://img.shields.io/badge/Algorithm-00599C?style=for-the-badge&logo=c&logoColor=white)

Recreación de la lógica del popular juego **Wordle** desarrollada íntegramente en Java Nativo. 

Este proyecto se centra en la **algoritmia pura**: no utiliza interfaz gráfica (GUI), sino que funciona a través de la consola de comandos (CLI), priorizando el rendimiento y la lógica de validación de caracteres.

---

## 📸 Demo (Consola)

![Captura del Juego](images/wordle-java.jpg)

---

## 🧠 Características Técnicas

* **Lógica de Comparación de Strings:** Algoritmo que compara la entrada del usuario con la palabra oculta letra por letra.
* **Gestión de Estados (Colores ANSI):**
    * 🟢 **Verde:** Letra correcta en posición correcta.
    * 🟡 **Amarillo:** Letra correcta en posición incorrecta.
    * ⚪ **Gris:** Letra no existe en la palabra.
* **Bucle de Juego:** Control de intentos (Max 6) y condiciones de victoria/derrota.
* **Input/Output:** Uso de la clase `java.util.Scanner` para la captura de datos y validación de longitud de palabras (5 letras).

---

## 🛠️ Cómo ejecutarlo

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Btncr13/Wordle.git
    ```
2.  **Compilar:**
    Navega a la carpeta `src` y compila los archivos.
    ```bash
    javac Main.java
    ```
3.  **Ejecutar:**
    ```bash
    java Main
    ```

---

## 👤 Autor

**César** - *Desarrollador Full Stack en formación*
[LinkedIn](https://www.linkedin.com/in/cesarbetancorcano/) | [Portfolio](https://btncr13.github.io/portfolio/)
