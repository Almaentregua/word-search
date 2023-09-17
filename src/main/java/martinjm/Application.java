package martinjm;

import martinjm.services.DictionaryService;
import martinjm.services.WordSearchService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        DictionaryService.loadDictionary();
        String lettersToUse = "valedae";
        char[] proibidas = Utils.quitarLetras(WordSearchService.letters, lettersToUse.toCharArray());

        List<String> dictionay = DictionaryService.getDictionay();

        dictionay.stream()
                .filter(word -> word.length() == 20)
                .filter(word -> WordSearchService.containLetter(word,'a'))
                .filter(word -> WordSearchService.containLetterInPosition(word, 'c',0))
                .forEach(System.out::println);


    }
}
