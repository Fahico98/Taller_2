
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class Waiter {
    
    public static void main(String[] arguments) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArray = br.readLine().split(" ");
        int N = Integer.parseInt(inputArray[0]), Q = Integer.parseInt(inputArray[1]);
        int prime;
        List<Integer> primesList = PrimeNumber.generate(Q);
        PrimeNumber.generate(Q);
        ListStack<Integer>[] A_stacks = new ListStack[Q + 1];
        ListStack<Integer>[] B_stacks = new ListStack[Q + 1];
        for (int i = 0; i <= Q; i++) {
            A_stacks[i] = new ListStack();
            B_stacks[i] = new ListStack();
        }
        inputArray = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A_stacks[0].push(Integer.parseInt(inputArray[i]));
        }
        for (int i = 0; i < Q; i++) {
            prime = primesList.get(i);
            while(!A_stacks[i].isEmpty()){
                int num = A_stacks[i].topAndPop();
                if(num % prime == 0){
                    B_stacks[i + 1].push(num);
                }else{
                    A_stacks[i + 1].push(num);
                }
            }
        }
        for (int i = 1; i <= Q; i++) {
            while(!B_stacks[i].isEmpty()){
                System.out.println(B_stacks[i].topAndPop());
            }
        }
        while(!A_stacks[Q].isEmpty()){
            System.out.println(A_stacks[Q].topAndPop());
        }
    }
}

