import java.util.ArrayList;
import java.util.Arrays;

public class LinearProbing {
    String[] hashTable;
    int usedCells;

    LinearProbing(int size){
        hashTable = new String[size];
        usedCells = 0;
    }

    public int modASCIIHashFxn(String word){
        int total=0;
        for(int i=0;i<word.length();i++){
            total+=word.charAt(i);
        }
        return total%hashTable.length;
    }

    public double getLoadFactor(){
        return usedCells * (1.0/hashTable.length);
    }

    public void reHashKeys(String word){
        usedCells = 0;
        ArrayList<String> s = new ArrayList<>();
        for(String str: hashTable){
            if(str!=null)
                s.add(str);
        }
        s.add(word);
        hashTable = new String[hashTable.length*2];
        for(String str: s){
            insert(str);
        }
    }

    public void insert(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75)
            reHashKeys(word);
        else{
            int index = modASCIIHashFxn(word);
            for(int i=index;i<index+hashTable.length;i++){
                int tableIndex = i%hashTable.length;
                if(hashTable[tableIndex]==null){
                    hashTable[tableIndex]=word;
                    break;
                }else
                    System.out.println("trying next cell");
            }
        }
        usedCells++;
    }

    public void printHashTable(){
        System.out.println("----------Hashtable----------");
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Index "+i+" : "+hashTable[i]);
        }
        System.out.println("-----------------------------");
    }

    public boolean search(String word){
        int index = modASCIIHashFxn(word);
        for(int i=index;i<index+hashTable.length;i++){
            int tableIndex = i%hashTable.length;
            if(hashTable[tableIndex]!=null && hashTable[tableIndex].equals(word)){
                System.out.println("found");
                return true;
            }
        }
        System.out.println("not found");
        return false;
    }

    public void delete(String word){
        if(search(word)){
            int index = modASCIIHashFxn(word);
            for(int i=0;i<index+hashTable.length;i++){
                int tableIndex = i%hashTable.length;
                if(hashTable[tableIndex]!=null && hashTable[tableIndex].equals(word)){
                    hashTable[tableIndex]=null;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        LinearProbing l = new LinearProbing(12);
        l.insert("the");
        l.insert("quick");
        l.insert("brown");
        l.insert("fox");
        l.insert("over");
        l.printHashTable();
        l.search("fox");
        l.delete("fox");
        l.printHashTable();
    }


}
