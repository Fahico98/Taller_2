
import java.io.*;
import java.util.ArrayList;

public class Game_of_Two_Stacks {
    
    public static void main(String[] arguments) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList output = new ArrayList();
        int g = Integer.parseInt(br.readLine());
        for (int i = 0; i < g; i++){
            String[] xnm = br.readLine().split(" ");
            int n = Integer.parseInt(xnm[0]);
            int m = Integer.parseInt(xnm[1]);
            int x = Integer.parseInt(xnm[2]);
            String[] Aarray = br.readLine().split(" ");
            String[] Barray = br.readLine().split(" ");
            ListStack<Integer> A = new ListStack();
            ListStack<Integer> B = new ListStack();
            int sumStacks = 0;
            for (int j = n - 1; j >= 0; j--){
                sumStacks += Integer.parseInt(Aarray[j]);
                A.push(Integer.parseInt(Aarray[j]));
            }
            for (int j = m - 1; j >= 0; j--) {
                sumStacks += Integer.parseInt(Barray[j]);
                B.push(Integer.parseInt(Barray[j]));
            }
            if(sumStacks <= x){
                output.add(n + m);
                continue;
            }
            ListStack<Integer> bufferList = new ListStack();
            int sum = 0, count = 0;
            int topA, topB;
            while(sum <= x){ // While begining *********************************
                topA = 1000000;
                topB = 1000000;
                if(!A.isEmpty()){
                    topA = A.top();
                }
                if(!B.isEmpty()){
                    topB = B.top();
                }
                if(topA < topB){
                    sum += A.topAndPop();
                    count++;
                    while(!bufferList.isEmpty()){
                        B.push(bufferList.topAndPop());
                    }
                }else if(topA > topB){
                    sum += B.topAndPop();
                    count++;
                    while(!bufferList.isEmpty()){
                        A.push(bufferList.topAndPop());
                    }
                }else{
                    while(A.top().equals(B.top())){
                        if(!A.isEmpty()){
                            bufferList.push(A.topAndPop());
                        }else{
                            break;
                        }
                        if(!B.isEmpty()){
                            B.pop();
                        }else{
                            break;
                        }
                        sum += bufferList.top();
                        count++;
                        if(sum > x || A.isEmpty() || B.isEmpty()){
                            break;
                        }
                    }
                }
            }
            output.add(--count);
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}

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