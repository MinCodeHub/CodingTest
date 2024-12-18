package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //확장자 파일 개수 출력하기
        //확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력

        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i =0; i<n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(),".");

            st.nextToken();
            String extension = st.nextToken();

            if(!map.containsKey(extension))
                list.add(extension);

            map.put(extension, map.getOrDefault(extension,0)+1);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s+" "+ map.get(s)+"\n");
        }

        System.out.println(sb);

    }
}