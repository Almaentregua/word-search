package martinjm.services;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryService {
    public static String dictionayLocationFile = "diccionario.txt";
    @Getter
    private static List<String> dictionay = new ArrayList<>();

    public static void loadDictionary(){
        try (BufferedReader br = new BufferedReader(new FileReader(dictionayLocationFile))) {
            String word;
            while ((word = br.readLine()) != null) {
                dictionay.add( word);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
