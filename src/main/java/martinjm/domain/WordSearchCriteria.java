package martinjm.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class WordSearchCriteria {
    private int length;
    private String letters;
    private List<LetterPosition> letterPositions;
    private List<LetterTotal> letterTotals;
}
