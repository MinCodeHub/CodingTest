import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //1부터N까지 자연수 중에서 중복없이 M개를 고른 수열
    //순열

    static int n,m;
    static boolean[] visited;
    static int[] arr;
    static int[] output; //r개를 뽑은 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //뽑아야하는 수

        arr = new int[n];
        visited = new boolean[n];
        output = new int[m];

        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }


            permutation(0,n,m);

    }

    private static void permutation(int depth, int n, int r) {

        if(depth == r){
            for(int i =0;i <r; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i =0; i <n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth+1,n,r);
                visited[i] = false;
            }
        }



    }
}