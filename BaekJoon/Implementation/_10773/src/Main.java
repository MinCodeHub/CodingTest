import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    //구현 실버 4
    //제로
    static int k;
    static Stack<Integer> stack = new Stack<>();
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        result = 0;

        for(int i = 0; i < k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                stack.push(n);
            }else if(n == 0){
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        System.out.println(result);
    }

}