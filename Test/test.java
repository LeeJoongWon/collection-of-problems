package Test;

import java.util.Scanner;


public class test {
	
	
	 public static void main(String[] args) {
		 Solution solution = new Solution();
		 int a = solution.solution(new int[][]{
			 {0,0,0,0,0},
			 {0,0,1,0,3},
			 {0,2,5,0,1},
			 {4,2,4,4,2},
			 {3,5,1,3,1}},
			new int[]{1,5,3,5,1,2,1,4});
		 
		 System.out.print(a);
	    }
}