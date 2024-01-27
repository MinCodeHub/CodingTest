import java.io.*;
import java.util.Stack;


public class Main {
    //단어 뒤집기

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());




        while(N --> 0){
            Stack<Character> stack = new Stack<>(); //스택 만들기
            String s = br.readLine() + '\n';

            for( char ch : s.toCharArray()){
                if(ch == ' '|| ch == '\n'){
                    while(!stack.empty()){
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                }
                else{
                    stack.push(ch);
                }
            }
            bw.flush();
            bw.close();
        }
    }
}

