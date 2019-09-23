
import java.util.HashMap;

public enum Voice {
    ADJECTIVE("adjective"),
    ADVERB("adverb"),
    CONJUNCTION("conjunction"),
    INTERJUNCTION("interjunction"),
    NOUN("noun"),
    PREPOSITION("preposition"),
    PRONOUN("pronoun"),
    VERB("verb");

    private String word;
    public static HashMap<String, Voice> mapIt = new HashMap<>();

    private Voice(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    static {
        for (Voice voice : Voice.values()) {
            mapIt.put(voice.getWord(), voice);
        }
    }

    public static Voice searchByword(String word) {
        return mapIt.get(word);
    }

}
