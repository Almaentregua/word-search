package martinjm.controller;

import martinjm.domain.WordSearchCriteria;
import martinjm.services.WordSearchService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class WordSearchController {
    private final WordSearchService wordSearchService;

    public WordSearchController(WordSearchService wordSearchService){
        this.wordSearchService=wordSearchService;
    }

    @PostMapping(value = "/word")
    public List<String> getWords(@RequestBody WordSearchCriteria wordSearchCriteria){
        return wordSearchService.getWords(wordSearchCriteria);
    }
}
