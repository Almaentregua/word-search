package martinjm;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static char[] quitarLetras(char[] letras, char[] letrasARemover) {
        List<Character> listaLetras = new ArrayList<>();
        for (char letra : letras) {
            if (!contieneLetra(letra, letrasARemover)) {
                listaLetras.add(letra);
            }
        }

        char[] resultado = new char[listaLetras.size()];
        for (int i = 0; i < listaLetras.size(); i++) {
            resultado[i] = listaLetras.get(i);
        }

        return resultado;
    }

    public static boolean contieneLetra(char letra, char[] letrasARemover) {
        for (char letraARemover : letrasARemover) {
            if (letra == letraARemover) {
                return true;
            }
        }
        return false;
    }
}
