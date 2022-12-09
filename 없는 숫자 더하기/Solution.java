class Solution {
    public int solution(int[] numbers) {
        int num = 0;
        for(int i=0; i<numbers.length;i++){
            
            num += numbers[i];
        }
        
        return 45-num;
    }
}