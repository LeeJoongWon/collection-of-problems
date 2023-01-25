class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[100];
        int count=0;
        while(n > 0){
            arr[count++] = n%3;
            n = n/3;
        }
        int num = 1;
        for(int i=count-1; i>=0; i--) {
        	int tmp = arr[i]*num;
        	num = num * 3;
        	answer += tmp;
        }
        return answer;
    }
}