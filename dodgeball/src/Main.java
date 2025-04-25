public class Main {
    static int N;
    static int[] member = {10,20,30,40,30,20};
    static boolean[] selected; //선택 여부
    static int[] output; //선택된 조합 인덱스
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = member.length;
        output = new int[N/2];
        selected = new boolean[N];
        combination(0,0,N,N/2);
        System.out.println("최소 능력치 차이: "+ minDiff);
    }
    public static void combination(int start, int depth, int n, int r){
        if(depth == r){
            int sumA = 0;
            int sumB = 0;
            boolean[] team = new boolean[N];

            for(int i = 0; i<r; i++){
                team[output[i]] = true;
            }

            for(int i = 0; i<N; i++){
                if(team[i]){
                    sumA += member[i];
                }else{
                    sumB += member[i];
                }
            }
            int diff = Math.abs(sumA - sumB);
            if(diff<minDiff){
                minDiff = diff;
            }
            return;
        }
        for(int i = start; i<n; i++){
            output[depth] = i;
            combination(i+1, depth+1, n, r);
        }
    }
}
