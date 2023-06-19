import java.util.ArrayList;

public class QuadraticProbing {
    String[] hashTable;
    int usedCells;

    QuadraticProbing(int size){
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

    public void reHashkeys(String word){
        usedCells = 0;
        ArrayList<String> s = new ArrayList<>();
        for(String str: hashTable){
            if(str!=null)
                s.add(str);
        }
        s.add(word);
        hashTable = new String[hashTable.length * 2];
        for(String str: s)
            insert(str);
    }

    public void insert(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75)
            reHashkeys(word);
        else{
            int index = modASCIIHashFxn(word);
            int counter=0;
            for(int i=index;i<index+hashTable.length;i++){
                int tableIndex = (i + (counter*counter))%hashTable.length;
                if(hashTable[tableIndex]==null){
                    hashTable[tableIndex]=word;
                    break;
                }else{
                    System.out.println("trying next cell");
                }
                counter++;
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
        int counter=0;
        for(int i=0;i<index+hashTable.length;i++){
            int tableIndex = (i+(counter*counter))%hashTable.length;
            if(hashTable[tableIndex]!=null && hashTable[tableIndex].equals(word)){
                System.out.println("found");
                return true;
            }
            counter++;
        }
        System.out.println("not found");
        return false;
    }

    public void delete(String word){
        if(search(word)){
            int index = modASCIIHashFxn(word);
            int counter=0;
            for(int i=0;i<index+ hashTable.length;i++){
                int tableIndex = (i+(counter*counter))%hashTable.length;
                if(hashTable[tableIndex]!=null && hashTable[tableIndex].equals(word)){
                    hashTable[tableIndex]=null;
                }
                counter++;
            }
        }
    }

    public static void main(String[] args) {
        QuadraticProbing q = new QuadraticProbing(5);
        q.insert("the");
        q.insert("quick");
        q.insert("brown");
        q.insert("fox");
        q.insert("over");
        q.printHashTable();
        q.search("brown");
        q.delete("brown");
        q.printHashTable();
    }
}
