import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
      //2217번 - 로프

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int []w;
        w = new int[n];
        int max = 0;

        //시간복잡도 O(n)
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(br.readLine());
        }
        //정렬,,,,으음..작은 것부터 정렬

        //버블 정렬 사용 -> O(n^2)  -> 시간 초과가 뜬다.
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j<n; j++){
//                if(w[i] > w[j]){
//                    int temp  = w[i];
//                    w[i] = w[j];
//                    w[j] = temp;
//                }
//            }
//        }

        Arrays.sort(w); //Arrays.sort를 사용하여 시간 복잡도를 O(nlogn)으로 줄여준다.
        //O(n)
        for(int k = 0; k < n; k++){
          int ww = w[k] * (n-k);
          if(max < ww){
              max = ww;
          }
        }
        System.out.println(max);
    }
}