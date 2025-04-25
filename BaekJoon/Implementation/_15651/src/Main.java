import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //중복순열

    static int N,M;
    static int[] output;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

       StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];

        permutation(0,N,M);
        System.out.println(sb);
    }

    private static void permutation(int depth, int n, int m) throws IOException {
        if(depth == m){
            for(int i = 0; i<m; i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<n; i++){
            output[depth] = i+1;
            permutation(depth+1, n,m);
        }
    }
}