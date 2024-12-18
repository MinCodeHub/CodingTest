public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int wmax = 0; //가로 최대 길이
            int hmax = 0; //세로 최대 길이

            for(int i =0; i<sizes.length; i++){
                //가로를 기준으로 가로를 최대한 길게 , 세로는 최대한 작게
                //가로 길이가 세로 길이보다 작으면
                if(sizes[i][0] < sizes[i][1]){
                    int temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
                }
            }

            for(int i =0; i<sizes.length; i++){
                //가로의 가장 긴 길이 구하고
                //세로의 가장 긴 길이 구함.

                if(wmax < sizes[i][0]){
                    wmax = sizes[i][0];
                }

                if(hmax < sizes[i][1]){
                    hmax = sizes[i][1];
                }
            }


            answer = wmax * hmax;


            return answer;
        }
    }
}