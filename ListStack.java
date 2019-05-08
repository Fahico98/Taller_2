
class ListStack<T>{
    
    private ListStackNode<T> topStack = null;
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise. 
     */
    public boolean isEmpty(){
        return(topStack == null);
    }
    
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty(){
        topStack = null;
    }
    
    /**
    * Insert a new item into the stack.
    * @param x the item to insert.
    */
    public void push(T x){
        topStack = new ListStackNode(x, topStack);
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("ListStack pop");
        }
        topStack = topStack.next;
    }
    
    /**
    * Get the most recently inserted item in the stack, does not alter
    * the stack.
    * @return the most recently inserted item in the stack.
    * @throws RuntimeException if the stack is empty.
    */
    public T top(){
        if(isEmpty()){
            throw new RuntimeException( "ListStack top" );
        }
        return(topStack.data);
    }
    
    /**
     * Return and remove the most recently inserted item from the stack.
     * @return the most recently inserted item in the stack.
     * @throws RuntimeException if the stack is empty.
     */
    public T topAndPop(){
        if(isEmpty()){
            throw new RuntimeException( "ListStack topAndPop" );
        }
        T topItem = topStack.data;
        topStack = topStack.next;
        return topItem;
    }
    
    /**
     * @return a string whit all elements of the stack
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        ListStackNode<T> bufferNode = topStack;
        while(bufferNode != null){
            sb.append("\t").append(bufferNode.data).append("\n");
            bufferNode = bufferNode.next;
        }
        sb.append("]\n");
        return(new String(sb));
    }
}

class ListStackNode<AnyType>{
    
    public AnyType data;
    public ListStackNode next;
    
    public ListStackNode(AnyType data){
        this(data, null);
    }
    
    public ListStackNode(AnyType data, ListStackNode<AnyType> n){
        this.data = data;
        this.next = n;
    }
}