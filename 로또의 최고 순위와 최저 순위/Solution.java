class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int num = 0;  //일치한 번호수
        int zero = 0;   //0의 갯수
        int min = 0;
        int max = 0;
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            for(int k = 0; k<win_nums.length; k++){
                if(lottos[i] == win_nums[k]){
                    num++;
                }
            }

        }

        max = (num+zero <= 0) ? 6 : 7 - (num+zero);
        min = (num <= 0) ? 6 : 7 - num;

        int[] answer = {max,min};
        return answer;
      
    }
}
