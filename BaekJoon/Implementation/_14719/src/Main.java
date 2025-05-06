import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] height = new int[w];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        //블럭 높이 저장
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        //“양쪽에서 막혀야 고인다”는 논리적인 조건
        //그걸 구현하기 위한 왼쪽/오른쪽 최대값 계산이라는 로직
        for(int i =1; i<w-1; i++){
            int left = 0, right = 0;
            for(int j = 0; j < i;j++){
                left = Math.max(left, height[j]);
            }
            for(int j = i+1; j<w; j++){
                right = Math.max(right,height[j]);
            }
            if(height[i]<left && height[i] <right){
                answer += Math.min(left,right) - height[i];
            }

        }
        System.out.println(answer);



    }
}