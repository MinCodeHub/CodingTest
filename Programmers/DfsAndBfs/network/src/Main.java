import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//dfs로 푸는 방법

class Solution {
    private boolean[] check;
    public int solution(int n, int[][] computers) {
       //네트워크 개수 구하기 - 모두 연결되어있으면 1
        // 주어진 것: n - 컴퓨터 수, computers - 인덱스별 컴퓨터의 연결자
        //[i][i] = 1이다.

        check = new boolean[n];
        int answer = 0;

        for(int i =0; i<n; i++){
            if(!check[i]){
                check[i] = true;
                answer++;
                search(i,computers);
            }
        }

        return answer;
    }

    private void search(int i, int[][] computers) {

        for(int j = 0; j<computers.length; j++){
            if(check[j]|| i==j) continue;

            if(computers[i][j] == 1){
                check[i] = true;
                search(j,computers);
            }
        }
    }
}


// bfs로 푸는 방법

class Solution2{

    public int solution(int n, int[][] computers){

        boolean[] check = new boolean[n];

        int answer = 0;

        for(int i = 0; i<n; i++){
            if(!check[i]){
                bfs(i, computers, check);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int start, int[][] computers, boolean[] check) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        check[start] = true;

        while(!queue.isEmpty()){

            int current = queue.poll();

            for(int i =0; i<computers.length; i++){
                if(check[i] || computers[current][i]==0){
                    continue;
                }

                check[i] = true;
                queue.add(i);

            }
        }


    }
}