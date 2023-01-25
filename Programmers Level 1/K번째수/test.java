package Test;
import java.util.Arrays;
class KthSort{
    public int sort(int[] arr,int frontNum,int backNum,int th){ 
        arr = copyOfRange(arr,frontNum,backNum);
        arr = insertSort(arr);
        return arr[th-1];
    }
     public int[] copyOfRange(int[] arr,int frontNum, int backNum){
        int[] temp = new int[(backNum-frontNum)+1];
    	for(int i=0;i<=backNum-frontNum;i++) {
    		temp[i] = arr[frontNum+i-1];
    		}
        return temp;
    } 
    
    public int[] insertSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j;
            int temp = arr[i];
            for(j=i; j>0 && arr[j-1]>temp; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        return arr;
    }
}
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer =  new int[commands.length];
        KthSort kthsort = new KthSort(); 
        for(int i=0;i<commands.length;i++){
           answer[i] = kthsort.sort(array,commands[i][0],commands[i][1],commands[i][2]);
        }
        return answer;
    }
}

public class test {
    public static void main(String[] args) {
    	int[] a = {1, 5, 2, 6, 3, 7, 4};
    	int[][] b = { 
    			{2, 5, 3},
    			{4, 4, 1},
    			{1, 7, 3}};   	
    	Solution solution = new Solution();
    	System.out.print(Arrays.toString(solution.solution(a, b)));
    }
}













