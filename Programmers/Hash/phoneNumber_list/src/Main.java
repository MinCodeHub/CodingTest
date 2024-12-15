import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
//        Solution s = new Solution();
        Sol2 s = new Sol2();
        System.out.println(s.solution(phone_book));

    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book); //작은 수부터 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}

class Sol2 {

    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        //모든 전화번호를 map에 넣는다.
        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 1; j < phoneBook[i].length(); j++) {
                String prefix = phoneBook[i].substring(0, j);
                //한마디 요약: 자신을 제외한 나머지 str값이 접두사로 취급 -> map에서 해당 접두사를 가진게 있는지 확인.
                // 접두사가 map에 존재하고, 자기 자신이 아니면 false
                //예:   String[] phone_book = {"123", "456", "1234"};
                //1234차례일때 123이 걸러지면 map에 123이 있으니까 good
                //본인은 제외해야하니까
                if (map.containsKey(prefix)) {
                    return false;
                }

            }
        }
        return true;
    }
}