class Solution {
    public int solution(int[] a, int[] b) {
        int answer=0;       
        for(int i = 0; ia.length;i++){
            answer += a[i]b[i];    
        }
        
        return answer;
    }
}