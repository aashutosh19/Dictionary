
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();
        HashMap<String, ArrayList<DataSource>> mapValue = dictionary.getMap();
        while (true) {
            System.out.print("Search: ");
            Scanner stdin = new Scanner(System.in);
            String searchKey = stdin.nextLine();
            while (searchKey.isEmpty()) {
                System.err.println("Can't be empty key");
                System.out.println("Search: ");
                searchKey = stdin.nextLine();
            }
            searchKey = searchKey.toLowerCase();
            searchKey = searchKey.trim();
            System.out.println("|");
            String[] keys = searchKey.split(" ");
            if (keys.length == 1) {
                if (keys[0].toLowerCase().equals("!q")) {
                    break;
                }
                ArrayList<DataSource> source = dictionary.searchKeyWordOnly(keys[0]);
                if (source != null) {
                    for (DataSource data : source) {
                        System.out.println(data.getMapper().getKey().get() + " ["
                                + data.getMapper().getValue().getWord() + "]" + "  : " + data.getDefinition());
                    }
                }
            }

            if (keys.length == 2) {
                if (Keyword.mapIt.containsKey(keys[0].toLowerCase()) && (Voice.mapIt.containsKey(keys[1].toLowerCase())
                        || keys[1].toLowerCase().equals("distinct"))) {
                    ArrayList<DataSource> source = dictionary.searchKeyAndVoice(keys);
                    for (DataSource data : source) {
                        System.out.println(data.getMapper().getKey().get() + " ["
                                + data.getMapper().getValue().getWord() + "]" + "  : " + data.getDefinition());
                    }
                } else {
                    System.err.println("<2nd argument must be a part of speech or distinct>");
                }
            }

            if (keys.length == 3) {
                if (Keyword.mapIt.containsKey(keys[0].toLowerCase()) && (Voice.mapIt.containsKey(keys[1].toLowerCase())
                        && keys[2].toLowerCase().equals("distinct"))) {
                    ArrayList<DataSource> source = dictionary.searchKeyVoiceDictinct(keys);
                    for (DataSource data : source) {
                        System.out.println(data.getMapper().getKey().get() + " ["
                                + data.getMapper().getValue().getWord() + "]" + "  : " + data.getDefinition());
                    }
                } else {
                    System.err.println(
                            "<1st argument must be distinct, 2nd argument must be part of a voice, 3nd argument must be distinct>");
                }
            }

            System.out.println("|");
        }
        System.out.println(" ");
        System.out.println("-----THANK YOU------");
    }
}
