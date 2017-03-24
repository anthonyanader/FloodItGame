public class GameStack implements Stack <DotInfo>{

    private int sizeOfStack;
    private DotInfo dotStack [];
    private DotInfo data;
    private int top;

    public GameStack(int size){

        this.sizeOfStack = size;
        dotStack = new DotInfo[sizeOfStack * sizeOfStack];
        top = -1;
    }

    public boolean isEmpty(){

        return (top == -1);
    }

    public DotInfo peek(){

        return dotStack[top];
    }

    public DotInfo pop(){

        data = dotStack[top];
        top--;

        return data;
    }

    public void push(DotInfo dot) {
        top++;
        dotStack[top] = dot;
    }

}

// we can definitely add checkers to each method to throw errors