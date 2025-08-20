package condigTest.naver_ai;

public class test1 {
    public int solution(int N, int K) {
        long sum = (long) N * (N+1)/2;
        if (K > sum) return -1;

        int count =0;
        for(int i=N; i>=1;i--){
            if(K>=i){
                K-=i;
                count++;
            }
            if(K==0) break;
        }

        return K ==0 ? count: -1;

    }
}
