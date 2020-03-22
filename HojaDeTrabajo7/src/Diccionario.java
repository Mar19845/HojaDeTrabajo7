
import java.util.LinkedHashMap;

/**
 *
 * @author Juan Marroquin
 * @param <K>
 * @param <V>
 */
public class Diccionario<K, V> {

    private LinkedHashMap<K, V> dictionaryMap = new LinkedHashMap<>();

    public Diccionario() {
    }

    public void addEntry(K english, V spanish) {
        dictionaryMap.put(english, spanish);

    }

    /**
     * Checks if a word is in the dictionary
     *
     * @param englishWord word in English
     * @return boolean if it contains the word
     */
    public boolean containsWord(K englishWord) {
        if (dictionaryMap.containsKey(englishWord)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the word in Spanish from an English word
     *
     * @param englishWord word in english
     * @return the word in Spanish
     */
    public V getSpanishWord(K englishWord) {
        return dictionaryMap.get(englishWord);
    }
}
