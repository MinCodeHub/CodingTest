import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //백준 1406번 에디터

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());


        Stack<String> leftSt = new Stack<String>();
        Stack<String> rightSt = new Stack<String>();

        String[] arr = str.split("");
        for (String s: arr){
            leftSt.push(s);
        }

        for(int i = 0 ; i < N; i++){
            String command =  br.readLine();
            char c = command.charAt(0);

            switch (c){
                case 'P':  //인덱스 cursor에 next.token삽입 list.add(cusor - 1, next.token)
                    char t = command.charAt(2);
                    leftSt.push(String.valueOf(t));
                    break;
                default:break;
                case 'L': //인덱스 커서 - 1
                    if(!leftSt.isEmpty()){
                        rightSt.push(leftSt.pop());
                    }
                    break;
                case 'B': //인덱스 cursor -1 삭제 list.remove(cusor -1)
                    if(!leftSt.isEmpty()){
                        leftSt.pop();
                    }
                    break;

                case 'D':
                    if(!rightSt.isEmpty()){
                        leftSt.push(rightSt.pop());
                    }
                    break;
            }
        }

        while(!leftSt.isEmpty())
            rightSt.push(leftSt.pop());

        while(!rightSt.isEmpty())
            sb.append(rightSt.pop());

        System.out.print(sb);



    }
}