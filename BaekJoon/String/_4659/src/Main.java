import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.equals("end")) {
                break;
            } else {
                boolean cc = checkPw(line);
                if(cc){
                    sb.append("<").append(line).append("> is acceptable.").append("\n");
                }else{
                    sb.append("<").append(line).append("> is not acceptable.").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean checkPw(String line) {
        boolean isaeiou = false;
        int cntz = 0; //자음 연속
        int cnta = 0; //모음 연속
        char behindC = ' ';
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                isaeiou = true; //1번 조건 (모음 존재 여부)
                cnta++; //모음 연속 체킹
                cntz = 0;  //모음이 왔으니까 자음 세준 것은 초기화 시켜줘야함.
            } else {
                cntz++;
                cnta = 0; //자음이 왔으니까 모음 세준 것은 초기화 시켜줘야함.
            }

            if (cntz == 3 || cnta == 3) { //연속으로 3번이면 false 반환
                return false;
            }
            if (behindC == c) {
                if (behindC == 'e' || behindC == 'o') {
                    continue;
                } else {
                    return false;
                }
            }

            behindC = c;
        }

        if(!isaeiou){
            return false;
        }
        return true;
    }
}