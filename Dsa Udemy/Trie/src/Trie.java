public class Trie {
    public TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String s){
        TrieNode cur = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            TrieNode node = cur.children.get(ch);
            if(node==null){
                node = new TrieNode();
                cur.children.put(ch,node);
            }
            cur=node;
        }
        cur.endOfString=true;
    }

    public boolean search(String s){
        TrieNode cur = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            TrieNode node = cur.children.get(ch);
            if(node==null){
                System.out.println("not found");
                return false;
            }
            cur = node;
        }
        if(!cur.endOfString){
            System.out.println("not found");
            return false;
        }
        System.out.println("found");
        return true;
    }

    public boolean delete(TrieNode parentNode, String word, int index){
        char ch=word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canBeDeleted;

        if(currentNode.children.size()>1){
            delete(currentNode,word,index+1);
            return false;
        }

        if(index == word.length()-1){
            if(currentNode.children.size()>=1){
                currentNode.endOfString=false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfString){
            delete(currentNode,word,index+1);
        }

        canBeDeleted = delete(currentNode, word, index+1);

        if (canBeDeleted){
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }
    }

    public void delete(String word){
        if(search(word))
            delete(root,word,0);
        else
            System.out.println("word not found");
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("APPLE");
        t.insert("ALAS");
        t.insert("API");
        t.insert("APIS");
        t.search("API");
        t.delete("API");
        t.search("API");
    }
}
