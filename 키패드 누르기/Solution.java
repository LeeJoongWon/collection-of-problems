package Test;

class Solution {
	 public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        int left =10;
	        int right =12;
	        
	        for(int tmp: numbers){
	            if(tmp==1||tmp==4||tmp==7){
	                answer+="L";
	                left = tmp;
	            }else if(tmp==3||tmp==6||tmp==9){
	                answer+="R";
	                right = tmp;
	            }else {
	                if(tmp==0) tmp=11;
	                int leftdist = Math.abs(tmp-left)/3+Math.abs(tmp-left)%3;
	                int rightdist = Math.abs(tmp-right)/3+Math.abs(tmp-right)%3;
	                
	                if(leftdist<rightdist){
	                    answer+="L";
	                    left = tmp;
	                }else if(leftdist>rightdist){
	                    answer+="R";
	                    right = tmp;
	                }else{
	                    if(hand.equals("left")){
	                        answer+="L";
	                        left = tmp;
	                    }else{
	                        answer+="R";
	                        right = tmp;
	                    }
	                }
	            }
	        }
	        return answer;
	    }
   
	public static void main(String[] arg) {
		int[] a = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6,2};
		String hand = "left";
		System.out.print(solution(a,hand));
	}		
}