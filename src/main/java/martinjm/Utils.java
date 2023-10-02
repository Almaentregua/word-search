package martinjm;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static char[] removeLetters(char[] letters, char[] lettersToRemove) {
        List<Character> listaLetras = new ArrayList<>();
        for (char letra : letters) {
            if (!containLetter(letra, lettersToRemove)) {
                listaLetras.add(letra);
            }
        }

        char[] resultado = new char[listaLetras.size()];
        for (int i = 0; i < listaLetras.size(); i++) {
            resultado[i] = listaLetras.get(i);
        }

        return resultado;
    }

    public static boolean containLetter(char letter, char[] letters) {
        for (char letterInLetters : letters) {
            if (letter == letterInLetters) {
                return true;
            }
        }
        return false;
    }
}
