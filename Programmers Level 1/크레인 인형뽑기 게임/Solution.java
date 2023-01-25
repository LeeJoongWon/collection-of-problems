package Test;

class Solution {
	
	class Stack{
		
		int ptr; 
		int[] stk;
		
		public Stack(int x) {
			ptr =0;
			stk = new int[x];
		}
		
		public void push(int x) {
			if(ptr >= stk.length) {
				return;
			}
	   	 	stk[ptr++] = x;
	    }
		
		public void delete() {
			if(ptr <= 0) {
				return;
			}
			ptr--;
		}
		
		public int peek() {
			if(ptr <= 0) {
				return 0;
			}
			return stk[ptr - 1];
		}
		
	}
	
    public int solution(int[][] board, int[] moves) {
        
    	 Stack stack = new Stack(100);
    	 int answer = 0;;    
            
         for(int i=0; i<moves.length; i++){
        	 
             int move = moves[i] - 1;
             
             for(int j=0; j<board.length; j++){
                 
                 if(board[j][move] != 0){
                	 
                	 if(stack.peek() == board[j][move]) {
                		 stack.delete();
                		 answer += 2;
                	 }else {
                		 stack.push(board[j][move]);
                		 
                	 }
                	  board[j][move] = 0;
			 break;
                 }
                              
             }
                 
         }
                 
         return answer;
    }
}
