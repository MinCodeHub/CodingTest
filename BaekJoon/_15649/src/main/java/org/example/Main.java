package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] participant= {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution s = new Solution();
        s.solution(participant, completion);
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println("participant:"+ participant);
        System.out.println("completion:"+ completion);

        String answer = "";
        return answer;
    }
}