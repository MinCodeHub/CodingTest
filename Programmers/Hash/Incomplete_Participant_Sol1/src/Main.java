package CodingTest.Programmers.Hash.Incomplete_Participant_Sol1.src;

import java.io.IOException;
import java.util.*;

//public class Main {
//    public static void main(String[] args) throws IOException {
//        String[] participant= {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//
//        Solution_1 s = new Solution_1();
//       String result =  s.solution(participant, completion);
//
//       System.out.println(result);
//    }
//}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int flag = 0;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < participant.length -1; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            answer = participant[participant.length-1];
        }

        return answer;
    }
}