import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


//bfs로 푸는 방법
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        for(int i =0; i< numbers.length; i++){
            int size = queue.size();

            for(int j =0; j<size; j++){
                int sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);
            }

        }

        while(!queue.isEmpty()){
            if( queue.poll() == target){
                answer+=1;
            }

        }
        return answer;
    }
}


//dfs로 푸는 방법 1

class Solution2 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    private void dfs(int depth, int[] numbers, int target, int sum){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
        }

        dfs(depth+1, numbers,target, sum+numbers[depth]);
        dfs(depth-1, numbers, target, sum - numbers[numbers.length]);
    }
}

//dfs로 푸는 방법 2
class Solution3{

    public int solution(int[] numbers, int target){
        return dfs(0, numbers, target, 0);
    }

    private int dfs(int depth, int[] numbers, int target, int sum){
        if(depth == numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        return dfs(depth+1, numbers, target, sum+numbers[depth])+ dfs(depth+1, numbers, target, sum - numbers[depth+1]);
    }
}