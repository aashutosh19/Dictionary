
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    ArrayList<DataSource> source;
    HashMap<String, ArrayList<DataSource>> map;

    public Dictionary() {
        this.source = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public HashMap<String, ArrayList<DataSource>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<DataSource>> map) {
        this.map = map;
    }

    public void loadDictionary() {
        System.out.println("! Loading data");
        System.out.println("! Loading completed");
        System.out.println("");
        System.out.println("-------DICTIONARY 340 JAVA-----------");
        System.out.println("");
        for (Keyword keyword : Keyword.values()) {
            switch (keyword) {
                case PLACEHOLDER:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "to be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADVERB), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.CONJUNCTION), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.INTERJUNCTION), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.PREPOSITION), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.PRONOUN), "To be updated"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.VERB), "To be updated"));
                    map.put(Keyword.PLACEHOLDER.get(), source);
                    source = new ArrayList<>();
                    break;
                case CSC210:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "Comfortable with Objects and Classes"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "Ready for CSC 220"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Intro to Java"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "To learn Java"));
                    map.put(Keyword.CSC210.get(), source);
                    source = new ArrayList<>();
                    break;
                case CSC220:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "Ready to create complex data structure"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Data Structures"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.VERB), "To create data structures"));
                    map.put(Keyword.CSC220.get(), source);
                    source = new ArrayList<>();
                    break;
                case CSC340:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE),
                            "= C++ version of CSC210 + CSC220 + more"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "A CS upper division curse"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Many hours outside of class"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Programming Methodology"));
                    map.put(Keyword.CSC340.get(), source);
                    source = new ArrayList<>();
                    break;
                case VERB:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.VERB), "Verb is a group of words that expresses"));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Verb is a word or group of words that expresses an action (such as eat), an event\\n\"\r\n"
                            + "                + \"(such as happen) or a state (such as exist)."));
                    map.put(Keyword.VERB.get(), source);
                    source = new ArrayList<>();
                    break;
                case ADJECTIVE:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Adjective is a word that describes a person or thing, for example big, red and clever in a big house, red wine and a clever idea."));
                    map.put(Keyword.ADJECTIVE.get(), source);
                    source = new ArrayList<>();
                    break;
                case BOOK:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "A set of pages."));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "A written work published in printed or electronic form."));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.VERB), "To arrange for someone to have a seat on a plane."));
                    source.add(new DataSource(new Mapper<>(keyword, Voice.VERB), "To arrange something on a particular date."));
                    map.put(Keyword.BOOK.get(), source);
                    source = new ArrayList<>();
                    break;
                case BOOKABLE:
                    source.add(
                            new DataSource(new Mapper<>(keyword, Voice.ADJECTIVE), "Can be ordered in advance."));
                    map.put(Keyword.BOOKABLE.get(), source);
                    source = new ArrayList<>();
                    break;
                case CONJUNCTION:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Conjunction is a word that joins words, phrases or sentences, for example 'and', 'but', 'or'."));
                    map.put(Keyword.CONJUNCTION.get(), source);
                    source = new ArrayList<>();
                    break;
                case INTERJECTION:
                    source.add(new DataSource(new Mapper<>(keyword, Voice.NOUN), "Interjection is a short sound, word or phrase spoken suddenly to express an emotion. Oh!, Look out! and Ow! are interjections."));
                    map.put(Keyword.INTERJECTION.get(), source);
                    source = new ArrayList<>();
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayList<DataSource> searchKeyWordOnly(String key) {
        if (map.containsKey(key.toLowerCase())) {
            return map.get(key);
        } else {
            System.err.print("<Not found>");
            System.out.println();
            return null;
        }
    }

    public ArrayList<DataSource> searchKeyAndVoice(String[] keys) {

        ArrayList<DataSource> originalData = map.get(keys[0]);
        ArrayList<DataSource> searchData = new ArrayList<>();
        HashMap<String, DataSource> distinctMap = new HashMap<>();
        if (keys[1].toLowerCase().equals("distinct")) {
            for (DataSource data : originalData) {
                distinctMap.put(data.getMapper().getValue().getWord(), data);
            }
            for (DataSource data : distinctMap.values()) {
                searchData.add(data);
            }
        } else {
            for (DataSource data : originalData) {
                if (data.getMapper().getValue().getWord().equals(keys[1].toLowerCase())) {
                    searchData.add(data);
                }
            }
        }

        return searchData;
    }

    public ArrayList<DataSource> searchKeyVoiceDictinct(String[] keys) {
        ArrayList<DataSource> originalData = map.get(keys[0]);
        ArrayList<DataSource> searchData = new ArrayList<>();

        for (DataSource data : originalData) {
            if (data.getMapper().getValue().getWord().equals(keys[1].toLowerCase())) {
                searchData.add(data);
            }
        }
        return searchData;
    }
}
