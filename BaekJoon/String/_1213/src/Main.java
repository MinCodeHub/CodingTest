import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    //팰린드롬 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                int v = map.get(c);
                map.replace(c,v+1);
            }
        }

        int oddCnt = 0;

       for(int cnt: map.values()){
           if(cnt % 2 == 1){
               oddCnt++;
           }
       }

       if(oddCnt > 1){
           System.out.println("I'm Sorry Hansoo");
       }else{
           createPalindrom(map);
       }

    }

    private static void createPalindrom(HashMap<Character, Integer> map) {
        StringBuilder half = new StringBuilder();
        String middle="";

        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort(null); //알파벳 순으로 정렬

        for(char c: keys){
            int count = map.get(c);

            if(count %2==1){
                middle =String.valueOf(c); //홀수인경우 가운데 문자로 한번만 사용
            }

            for(int i=0;i<count/2; i++){
                half.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        result.append(middle);
        result.append(half.reverse());

        System.out.println(result.toString());




    }
}