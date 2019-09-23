
import java.util.HashMap;

public enum Keyword {
    PLACEHOLDER("placeholder"),
    CSC210("csc210"),
    CSC220("csc220"),
    CSC340("csc340"),
    VERB("verb"),
    BOOK("book"),
    BOOKABLE("bookable"),
    CONJUNCTION("conjunction"),
    INTERJECTION("interjection"),
    ADJECTIVE("adjective");

    private String word;
    public static HashMap<String, Keyword> mapIt = new HashMap<>();

    private Keyword(String word) {
        this.word = word;
    }

    public String get() {
        return this.word;
    }

    static {
        for (Keyword key : Keyword.values()) {
            mapIt.put(key.get(), key);
        }
    }

    public static Keyword searchByWord(String word) {
        if (word != null) {
            return mapIt.get(word);
        } else {
            return null;
        }
    }

}
