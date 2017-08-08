package ir.m7.androidframework.lib.app;

/**
 * Created by hoven on 7/23/16.
 */
public class FragmentStack {
    public static int maxSize;
    public static Class[] stackArray;
    public static int top;

    public FragmentStack(int s) {
        maxSize = s;
        stackArray = new Class[maxSize];
        top = -1;
    }

    public static void push(Class j) {
        stackArray[++top] = j;
    }

    public static Class pop() {
        return stackArray[top--];
    }

    public static Class peek() {
        return stackArray[top];
    }

    public static void main(String[] args) {
        FragmentStack theStack = new FragmentStack(10);
//        theStack.push(10);
//        theStack.push(20);
//        theStack.push(30);
//        theStack.push(40);
//        theStack.push(50);
        while (!theStack.isEmpty()) {
            Class value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }


}
