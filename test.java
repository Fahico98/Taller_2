
public class test {
    
    public static void main(String[] arguments){
        
        int num = 20;
        
        sum(num);
        
        System.out.println(num + "...!");
        
    }
    
    public static void sum(int num){
        num++;
        System.out.println("num in method: " + num);
    }
}
