import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //소트인사이드
    static int n;
    static ArrayList<Integer> arr = new ArrayList();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while(n!=0){
            arr.add(n%10);
            n/=10;
        }

        Collections.sort(arr,Collections.reverseOrder());

        for(Integer c : arr){
            System.out.print(c);

        }
    }
}

//다른 방법

/*
* char[] arr = br.readLine().toCharArray();
* Arrays.sort(arr);
* */

