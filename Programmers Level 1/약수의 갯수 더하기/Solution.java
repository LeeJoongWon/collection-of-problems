class Solution {
    public int solution(int left, int right) {
        int sum=0;         
        for(int i=left; i<=right;i++){
            sum += i;
            for(int j=1;j<=(i/2)+1;j++){
                if((j*j) == i){
                    sum -= i*2;
                    break;
                }
            }

        }
        int answer = sum;
        return answer;
    }
}