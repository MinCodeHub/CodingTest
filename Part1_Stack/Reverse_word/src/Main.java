import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
//스택과 큐를 함께 사용함
//17413번 단어 뒤집기2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        char[] sarr = s.toCharArray();


        Stack<String> stack1 = new Stack<>();
        Queue<String> queue = new LinkedList<>();


        for(int i = 0; i < sarr.length; i++){
            if(!String.valueOf(sarr[i]).equals(" ")){
                //공백이 아닐때만 push해라
                if(String.valueOf(sarr[i]).equals("<")){
                    //스택에 값이 있으면 먼저 pop해라
                    if(!stack1.isEmpty()){
                        while(!stack1.isEmpty()){
                            sb.append(stack1.pop());
                        }

                    }
                    //'<'를 만나면,,,>를 만날때까지 queue에 넣기
                    while(sarr[i] != '>'){
                        queue.offer(String.valueOf(sarr[i]));
                        i++;
                    }
                    queue.offer(String.valueOf(sarr[i]));
                    while(!queue.isEmpty()){
                        sb.append(queue.poll());
                    }
                }else{
                    stack1.push(String.valueOf(sarr[i]));
                }

            }
            if(String.valueOf(sarr[i]).equals(" ")){
                while(!stack1.isEmpty()){
                    sb.append(stack1.pop());
                }
                stack1.push(" ");
                sb.append(stack1.pop());
            }else if(i == sarr.length -1){
                while(!stack1.isEmpty()){
                    sb.append(stack1.pop());
                }
            }

        }

        System.out.println(sb);


    }
}