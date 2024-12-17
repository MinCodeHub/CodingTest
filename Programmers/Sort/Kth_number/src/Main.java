import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int []array = {1,5,2,6,3,7,4};

        int [][]commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = {};
            Solution s = new Solution();
        answer = s.solution(array,commands);
    }
}

// 반복문 사용
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];



        for(int h = 0; h< commands.length; h++){
            int i = commands[h][0];
            int j = commands[h][1];
            int k = commands[h][2];

            int[] arr2 = new int[j-i+1];

            for(int l = 0 ; l < array.length; l++){
                if(l >= i - 1 && l<= j-1){
                    arr2[l-(i-1)] = array[l];
                }
            }

            Arrays.sort(arr2);

            answer[h] = arr2[k-1];

        }

        return answer;
    }
}

//Arrays.copyOfRange 사용
class Solution2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

