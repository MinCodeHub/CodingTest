import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] citations = {3, 0, 6, 1, 5};
        System.out.println(s.solution(citations));

    }
}

class Solution {
    public int solution(int[] citations) {

        //기본형 배열을 래퍼 클래스로 반환
        Integer[] wrapperArray = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        //내림차순 정렬
        Arrays.sort(wrapperArray, Collections.reverseOrder());

        // 다시 기본형 배열로 반환

        citations = Arrays.stream(wrapperArray).mapToInt(Integer::intValue).toArray();

        int answer = 0;
        for(int i = 0; i< citations.length; i++){
            if(i+1 >= citations[i]){
                answer = citations[i];
            }
        }
        return answer;
    }
}