
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Queue_using_Two_Stacks {
    
    public static void main(String[] arguments)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        ListStack<Integer> stack = new ListStack();
        ListStack<Integer> bufferStack = new ListStack();
        ArrayList<Integer> output = new ArrayList();
        int topStack = 0;
        for (int i = 0; i < q; i++) {
            String[] inputArray = br.readLine().split(" ");
            String query = inputArray[0];
            if(query.equals("1")){
                int toEnqueue = Integer.parseInt(inputArray[1]);
                if(stack.isEmpty()){
                    topStack = toEnqueue;
                }
                stack.push(toEnqueue);
            }else if(query.equals("2")){
                while(!stack.isEmpty()){
                    bufferStack.push(stack.topAndPop());
                }
                bufferStack.pop();
                if(bufferStack.isEmpty()){
                    topStack = 0;
                }else{
                    topStack = bufferStack.top();
                }
                while(!bufferStack.isEmpty()){
                    stack.push(bufferStack.topAndPop());
                }
            }else if(query.equals("3")){
                output.add(topStack);
            }
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}
