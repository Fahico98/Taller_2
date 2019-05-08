
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
