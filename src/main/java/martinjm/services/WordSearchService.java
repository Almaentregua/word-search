package martinjm.services;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class WordSearchService {

    public static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    public static boolean containLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    public static boolean containLetterCount(String word, char letter, int total) {
        word = normalizeWord(word);
        int contador = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                contador++;
            }
        }
        return contador == total;
    }

    public static boolean containProhibitedLetters(String word, char[] letters) {
        word = normalizeWord(word);
        for (char letter : word.toCharArray()) {
            for (char letraProhibida : letters) {
                if (letter == letraProhibida) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containLetterInPosition(String word, char letter, int position){
        return word.charAt(position) == letter;
    }

    public static String normalizeWord(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}
