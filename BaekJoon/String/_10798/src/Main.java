import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //세로 읽기

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        char[][] c = new char[15][5];
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < 5; i++){
          String str = br.readLine();
          int len = str.length();

          for(int j = 0; j<len ; j++){
              c[j][i] = str.charAt(j);
          }
        }

        for(int i = 0; i< 15; i++){
            for(int j = 0; j < 5; j++){
                if(c[i][j]=='\0'){
                    continue;
                }
                sb.append(c[i][j]);
            }
        }

        System.out.println(sb);
    }
}