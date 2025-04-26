import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //단어 공부
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();

        int[] alphabet;

        int len = str.length();
        char []c = new char[len];
        alphabet = new int[26];
        for(int i =0; i< len; i++) {
            c[i] = str.charAt(i);

            if((int)c[i] != 32){
                alphabet[(int)c[i]-65]+=1;
            }
        }
    int max = 0;
     int cnt = 0;
     int maxIdx = 0;

        for(int i = 0; i<26; i++){
            if(alphabet[i] > max){
               max = alphabet[i];
               cnt = 0;
               maxIdx = i;
           }else if(alphabet[i] == max){
               cnt+=1;
             }
    }

        if(cnt == 0){
            System.out.println((char)(maxIdx+65));
        }else{
            System.out.println("?");
        }

    }

}