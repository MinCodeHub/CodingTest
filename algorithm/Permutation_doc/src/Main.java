import java.util.Arrays;

public class Main {
    //순열 예제
    static int[] arr = {1,2,3,4};
    static int[] output; //r개를 뽑은 배열

    static boolean[] visited; //방문 배열
    static int n = 4, r = 3; //4개에서 3개 뽑는다.

    //순열 : 순서를 고려하면서 서로 다른 n개에서 중복없이 r개를 일렬로 나열하는 수
    public static void main(String[] args) {

        output = new int[r];
        visited = new boolean[n];


    }

    static void permutation(int depth, int n, int r){
        //순열이 완성된 경우
        if(depth==r){
            System.out.println(Arrays.toString(output));
            return;
        }
        //0부터 n까지 반복
        for(int i =0; i<n; i++){
            //방문하지 않은 값이면 넣기
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth+1,n,r);
                visited[i] = false; //다음 순열을 뽑기 위해 방문처리 제거
            }
        }
    }


    //중복 순열 : 순서를 고려하면서 서로 다른 n개에서 중복으로 r개를 일렬로 나열하는 수
    //방문 처리를 안해줘도 된다.
    static void repeatPermutation(int depth, int n, int r){
        if(depth==r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i =0; i<n; i++){
            output[depth] = arr[i]; //현재 depth를 인덱스로 사용
            repeatPermutation(depth+1,n,r);
        }
    }

}