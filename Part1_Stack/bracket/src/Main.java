import java.io.*;
import java.nio.Buffer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        //예상 풀이 :
        //일단 문자열 길이가 홀수이면 그냥 바로 NO 출력
        //문자열 길이가 짝수일 때
        // ) 가 나오면 size를 +1 함
        //( 가 나오면 size를 하나 감소시킴
        //스택이 빌 때까지 이 과정을 반복함
        //스택이 비었는데 size가 0 이 아니면 NO 출력
        //size가 0이면 YES출력

        //함점: size가 0이라도 올바른 괄호가 아닐 수도 있음 예시 -> ())(()
        //이럴 때는  flag변수를 추가해서 중간에 size가 마이너스로 떨어진 경우에 flag를 1로 바꿔서 표기해줘야함.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int size = 0; //괄호 개수 셀 변수
        int flag = 0; //size가 0이어도 NO일 수 있음
        while(N --> 0){

            Stack<Character> stack = new Stack<>(); //스택 만들기
            String str = br.readLine()+"\n";

                for(char ch : str.toCharArray()){
                    size = 0;
                    flag = 0;
                    if(ch == '\n'){ //개행을 만나면
                        while(!stack.empty()) { //스택이 빌 때까지
                            char popbraket = stack.pop();
                            if (popbraket == ')') {
                                size += 1;
                            }
                            if (popbraket == '(') {
                                size -= 1;
                                if(size < 0){
                                    flag = 1;
                                }
                            }
                        }
                        if(size == 0) {
                            if(flag ==1 ){
                                bw.write("NO"+ "\n");
                            }else{
                                bw.write("YES"+ "\n");
                            }
                        }else{
                            bw.write("NO"+ "\n");
                        }
                        bw.flush();
                    }
                    else{
                        stack.push(ch);
                    }
            }


        }

    }
}
