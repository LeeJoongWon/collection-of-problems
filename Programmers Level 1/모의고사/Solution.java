package Test;
class Queue{ 
    int num;
    class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }
    Queue(){
        num = 0;
    }
    private Node first;
    private Node last;   
    
    public void add(int data){
        Node t = new Node(data);
    
        if(last != null){
            last.next = t;
        }
        last = t;   
        num++;
        if( first == null){
            first = last;
        }
    }
    public int pop(){
        int data = first.data;
        first = first.next;
        
        if(first == null){
            last = null;
        }
        return data;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int capacity() {
        return num;
    }
}

class solutionTest {
    public int[] solution(int[] answers) {
        int [] a = {1,2,3,4,5,};
        int [] b = {2,1,2,3,2,4,2,5};
        int [] c = {3,3,1,1,2,2,4,4,5,5};
        int aCount=0;
        int bCount=0;
        int cCount=0;
        for(int i=0;i<answers.length;i++){
            if(a[i%a.length] == answers[i]) aCount++;
            if(b[i%b.length] == answers[i]) bCount++; 
            if(c[i%c.length] == answers[i]) cCount++;
        }      
        
        int top;
        int[] student = {aCount,bCount,cCount};
        top = aCount > bCount ? aCount : bCount;
        top = top > cCount ? top : cCount;
        
        Queue queue = new Queue();
        for(int i=0;i<student.length;i++){
            if(student[i] == top) {
                queue.add(i+1);

            }
        }
        int[] answer = new int[queue.capacity()];
        for(int i=0;i<answer.length;i++){
            answer[i] = queue.pop();
        }
        return answer;
    }
}
public class Solution {

	public static void main(String[] args) {
		int[] answers = {1, 2, 3, 4, 5};
		solutionTest test = new solutionTest();
		for(int num : test.solution(answers)) {
			System.out.print(num+" ");
		}
		
	}

}
