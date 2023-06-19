import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public Stack getLastStack(){
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);
    }

    public void push(int value){
        Stack last = getLastStack();
        if(last!=null && !last.isFull()){
            last.push(value);
        }else{
            Stack newStack = new Stack(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop(){
        Stack last = getLastStack();
        if(last!=null){
            int result = last.pop();
            if(last.size==0)
                stacks.remove(stacks.size()-1);
            return result;
        }else
            throw new EmptyStackException();
    }

    public int leftShift(int index, boolean removeTop){
        Stack stack = stacks.get(index);
        int removedItem;
        if(removeTop)
            removedItem = stack.pop();
        else
            removedItem = stack.removeBottom();

        if(stack.size==0)
            stacks.remove(index);
        else if(stacks.size() > index+1){
            int v = leftShift(index+1,false);
            stack.push(v);
        }
        return removedItem;
    }

    public int popAt(int index){
        return leftShift(index,true);
    }
}
