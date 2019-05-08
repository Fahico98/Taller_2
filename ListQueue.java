
class ListQueue<AnyType>{
    
    private ListQueueNode<AnyType> front;
    private ListQueueNode<AnyType> back;
    
    /**
     * Construct the queue.
     */
    public ListQueue(){
        front = back = null;
    }
    
    /**
     * Get the least recently inserted item in the queue, does not alter
     * the queue.
     * @return the least recently inserted item in the queue.
     * @throws RuntimeException if the queue is empty.
     */
    public AnyType getFront(){
        if(isEmpty()){
            throw new RuntimeException( "ListQueue getFront" );
        }
        return front.data;
    }
    
    /**
     * Test if the queue is logically empty.
     */
    public boolean isEmpty(){
        return front == null;
    }
    
    /**
     * Make the queue logically empty.
     */
    public void makeEmpty(){
        front = null;
        back = null;
    }
    
    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue(AnyType x){
        if(isEmpty()){
            back = front = new ListQueueNode(x);
        }else{
            back = back.next = new ListQueueNode(x);
        }
    }
    
    /**
     * Return and remove the least recently inserted item from the queue.
     * @return the least recently inserted item in the queue.
     * @throws RuntimeException if the queue is empty.
     */
    public AnyType dequeue(){
        if(isEmpty()){
            throw new RuntimeException("ListQueue dequeue");
        }
        AnyType returnValue = front.data;
        front = front.next;
        return returnValue;
    }
    
    /**
     * @return a string whit all elements of the queue
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        ListQueueNode<AnyType> bufferNode = front;
        while(bufferNode != null){
            sb.append("\t").append(bufferNode.data).append("\n");
            bufferNode = bufferNode.next;
        }
        sb.append("]\n");
        return(new String(sb));
    }
}

class ListQueueNode<AnyType>{
    
    public AnyType data;
    public ListQueueNode next;
    
    public ListQueueNode(AnyType data){
        this(data, null);
    }
    
    public ListQueueNode(AnyType data, ListQueueNode<AnyType> n){
        this.data = data;
        this.next = n;
    }
}