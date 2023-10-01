package martinjm.services;

import martinjm.Utils;
import martinjm.domain.LetterPosition;
import martinjm.domain.LetterTotal;
import martinjm.domain.WordSearchCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordSearchService {
    public List<String> getWords(WordSearchCriteria wordSearchCriteria){
        String lettersToUse = wordSearchCriteria.getLetters();
        char[] proibidas = Utils.quitarLetras(WordUtilsService.letters, lettersToUse.toCharArray());

        List<String> dictionary = DictionaryService.getDictionay();

        List<String> wordList = dictionary.stream()
                .filter(word -> word.length() == wordSearchCriteria.getLength())
                .filter(word -> !WordUtilsService.containProhibitedLetters(word, proibidas))
                .collect(Collectors.toList());

        if (!wordList.isEmpty() && wordSearchCriteria.getLetterPositions()!=null) {
            for (LetterPosition letterPosition: wordSearchCriteria.getLetterPositions()
            ) {
                if (!wordList.isEmpty()){
                    wordList = wordList.stream()
                            .filter(word ->  WordUtilsService.containLetterInPosition(word, letterPosition.getLetter(),letterPosition.getPosition()))
                            .collect(Collectors.toList());
                }
            }
        }

        if (!wordList.isEmpty() && wordSearchCriteria.getLetterTotals() != null){
            for (LetterTotal letterTotal: wordSearchCriteria.getLetterTotals()
            ) {
                if (!wordList.isEmpty()){
                    wordList = wordList.stream()
                            .filter(word ->  WordUtilsService.containLetterCount(word, letterTotal.getLetter(),letterTotal.getTotal()))
                            .collect(Collectors.toList());
                }
            }
        }
        return wordList;
    }
}