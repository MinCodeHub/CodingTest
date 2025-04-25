import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int[] alphabet; //abcd ... 알파벳 배열
        char[] answer = new char[n];

        for(int i = 0; i<n; i++){
            str[i] = br.readLine(); //문자열 입력받기
        }

        for(int i = 0; i < n; i++){
            //26번을 돌면서
            int max = 0;
            int maxIdx = 0;
            int cnt = 0;

            alphabet = new int[26];
            String s = str[i];
            for(int j = 0 ; j < s.length(); j++){
                char c = s.charAt(j);

                //소문자 a는 97임
                if((int) c != 32){
                    alphabet[(int)c - 97] +=1;
                }
            }
            for(int k = 0; k<26; k++) {
                if (max < alphabet[k]) {
                    cnt = 0;
                    max = alphabet[k];
                    maxIdx = k;
                } else if (max == alphabet[k]) {
                    cnt++;
                }
            }

            if(cnt == 0){
                answer[i] = (char)(maxIdx + 97);
            }else{
                answer[i] = '?';
            }
        }

        for(int l = 0; l<n; l++){
            System.out.println(answer[l]);
        }

    }
}