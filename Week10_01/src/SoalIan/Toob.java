package SoalIan;

import java.util.Stack;

public class Toob {
    Stack <Integer> stack = new Stack<>();
    boolean sealedornot = false;
    boolean sdhsealed = false;

    public Stack<Integer> getStack() {
        return stack;
    }

    public Integer getStackIndex(int a) {
        return stack.get(a);
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void sealed(){
        this.sealedornot = true;
    }

    public void sdhsealed(){
        this.sdhsealed = true;
    }

    public void pushStack(int inttoadd){
        stack.push(inttoadd);
    }

    public void popStack(){
        stack.pop();
    }

    public int getPopStack(){
        return stack.pop();
    }

    public int peekStack(){
        return stack.peek();
    }

    public boolean checkEmpty(){
        return stack.isEmpty();
    }

    public boolean checkSealed(){
        return sealedornot;
    }

    public boolean checksdhSealed(){
        return this.sdhsealed;
    }

    public int getSize(){
        return stack.size();
    }

}
