import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    //스택
    static int n;
    static Stack<Integer> stack = new Stack<>();

    static  StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());



        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
               stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(str.equals("top")){
                if(stack.size() != 0){
                    sb.append(stack.peek()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
            else if(str.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(str.equals("empty")){
                if(stack.size()!=0){
                    sb.append(0).append("\n");
                }else{
                    sb.append(1).append("\n");
                }
            }
            else if(str.equals("pop")){
                if(stack.size() != 0){
                    sb.append(stack.pop()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}