import java.util.Arrays;

public class Main {
    static int[] arr = {1,2,3,4};
    static int[] output; //r개를 뽑은 배열

    static boolean[] visited; //방문 배열
    static int n = 4, r = 3; //4개에서 3개 뽑는다.

    public static void main(String[] args) {
        output = new int[r];
        visited = new boolean[n];
    }

    static void combination(int start, int depth, int n, int r){
        if(depth==r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i = start; i<n; i++){
            output[depth] = arr[i];
            combination(i+1, depth+1, n,r);
        }

    }

    //중복 조합
    static void repeatCombination(int start, int depth, int n, int r){
        if(depth== r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i = start; i<n; i++){
            output[depth] = arr[i];
            combination(i, depth+1, n, r);
        }
    }
}
