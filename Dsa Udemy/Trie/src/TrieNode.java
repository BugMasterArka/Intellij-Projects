import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> children;
    boolean endOfString;

    TrieNode(){
        this.children = new HashMap<>();
        this.endOfString=true;
    }
}
