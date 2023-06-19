import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int usedCells;

    DoubleHashing(int size){
        hashTable = new String[size];
        usedCells = 0;
    }

    public double getLoadFactor(){
        return usedCells * (1.0/hashTable.length);
    }

    public int modASCIIHashFxn(String word){
        int total=0;
        for(int i=0;i<word.length();i++)
            total+=word.charAt(i);
        return total%hashTable.length;
    }

    public int getSumofAllDigits(int sum){
        int value=0;
        while(sum>0){
            value=sum%10;
            sum=sum/10;
        }
        return value;
    }

    public int secondHashFxn(String word){
        int total = 0;
        for(int i=0;i<word.length();i++){
            total+=word.charAt(i);
        }
        while(total>hashTable.length){
            total = getSumofAllDigits(total);
        }
        return total%hashTable.length;
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
        for(String str: s)
            insert(str);
    }

    public void insert(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75)
            reHashKeys(word);
        else{
            int x = modASCIIHashFxn(word);
            int y = secondHashFxn(word);
            for(int i=0;i<hashTable.length;i++){
                int tableIndex = (x+(i*y))%hashTable.length;
                if(hashTable[tableIndex]==null){
                    hashTable[tableIndex]=word;
                    break;
                }else{
                    System.out.println("trying next cell");
                }
            }
        }
        usedCells++;
    }

    public boolean search(String word){
        int x = modASCIIHashFxn(word);
        int y = secondHashFxn(word);
        for(int i=0;i<hashTable.length;i++){
            int tableIndex = (x+(i*y))%hashTable.length;
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
            int x = modASCIIHashFxn(word);
            int y = secondHashFxn(word);
            for(int i=0;i<hashTable.length;i++){
                int tableIndex = (x+(i*y))%hashTable.length;
                if(hashTable[tableIndex]!=null && hashTable[tableIndex].equals(word)){
                    hashTable[tableIndex]=null;
                    return;
                }
            }
        }
    }

    public void printHashTable(){
        System.out.println("----------Hashtable----------");
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Index "+i+" : "+hashTable[i]);
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        DoubleHashing d = new DoubleHashing(13);
//        size 5 error
//        d.insert("the");
//        d.insert("quick");
//        d.insert("brown");
//        d.insert("fox");
//        d.insert("over");
//        d.printHashTable();
//        d.search("brown");
//        d.delete("brown");
//        d.printHashTable();

        d.insert("the");
        d.insert("quick");
        d.insert("brown");
        d.insert("fox");
        d.insert("over");
        d.insert("lazy");
        d.printHashTable();
    }
}
