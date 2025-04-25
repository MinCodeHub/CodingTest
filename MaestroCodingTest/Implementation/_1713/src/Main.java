import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //자료구조 -> LinkedHashMap
    //사진틀
    //순서대로 추천받은 사람을 표하는?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //사진틀 개수
        int totalRecommendCnt = Integer.parseInt(br.readLine()); //총 추천 수

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        //저장된 순서를 기억하는 map

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < totalRecommendCnt; i++) {
            int student = Integer.parseInt(st.nextToken());

            if (map.containsKey(student)) {
                map.put(student, map.get(student) + 1);
            } else {
                if (map.size() == n) {
                    int minId = map.entrySet().stream().min(Map.Entry.comparingByValue())
                            .get().getKey();

                    map.remove(minId);
                }
                map.put(student, 1);
            }
        }

        map.keySet().stream().sorted().forEach(id -> System.out.print(id + " "));


    }
}

