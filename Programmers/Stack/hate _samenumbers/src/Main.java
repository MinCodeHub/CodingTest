import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,4,4,3,3};
        System.out.println( s.solution(arr));
    }
}
 class Solution {
    //스택을 두개 사용하고 , 배열은 초기화를 해주삼.
    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> s = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        for(int i =0; i< arr.length; i++) {
            if (s.empty()) {
                s.push(arr[i]);
            } else if (s.peek() != arr[i]) {
                resultStack.push(s.pop());
                s.push(arr[i]);
            }
        }
        if(!s.empty())
            resultStack.push(s.pop());

        answer = new int[resultStack.size()];

        for(int i = answer.length ; i > 0; i--){
            answer[i-1] = resultStack.pop();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}