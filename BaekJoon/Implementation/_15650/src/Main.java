import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //중복 없이 M개 고른 수열
    //조합 순서가 중요하지 않음
    static int N,M;
    static int[] output;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];

        comb(0,0,N,M);
    }

    private static void comb(int start, int depth, int n, int r){
        if(depth == r){
            for(int k = 0; k < r; k++){
                System.out.print(output[k]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<n; i++){
          output[depth] = i+1;
          comb(i+1, depth+1, n, r);
        }
    }
}