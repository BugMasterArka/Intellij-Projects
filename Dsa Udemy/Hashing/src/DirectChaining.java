import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;

    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int size){
        int total=0;
        for(int i=0;i<word.length();i++){
            total+=word.charAt(i);
        }
        return total%size;
    }

    public void insert(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(hashTable[index]==null){
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(word);
        }else{
            hashTable[index].add(word);
        }
    }

    public boolean search(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(hashTable[index]!=null && hashTable[index].contains(word)){
            System.out.println("found");
            return true;
        }
        System.out.println("not found");
        return false;
    }

    public void delete(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(search(word)){
            hashTable[index].remove(word);
            if(hashTable[index].isEmpty())
                hashTable[index]=null;
        }
    }

    public void printHashTable(){
        System.out.println("------------HashTable------------");
        for(int i=0;i<hashTable.length;i++){
            System.out.print("      Index "+i+" : ");
            System.out.println(hashTable[i]);
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        DirectChaining d = new DirectChaining(12);
        d.insert("I");
        d.insert("am");
        d.insert("a");
        d.insert("good");
        d.insert("boy");
        d.printHashTable();
        d.search("a");
        d.delete("am");
        d.printHashTable();
    }
}
