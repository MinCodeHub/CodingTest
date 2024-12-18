import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution s = new Solution();
        int [] numbers = {6, 10, 2};
        s.solution(numbers);
    }
}

class Solution {
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        //정렬 기준 : 두 문자열 o1, o2를 이어붙여본 결과
        // o2+o1 와 o1+o2를 비교한다.
        //예: o1 ="3"와 o2="30"이라면
        // (o2+o1) = "303"
        // (o1+o2) = "330"
        // 330이 더 크므로 o1이 앞에 온다.
        Arrays.sort(arr,(o1,o2)->(o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i< arr.length; i++){
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}