package Test;
import java.util.*;
class Solution {
	    public static String solution(String[] participant,String[] completion) {
	    	 Map<String, Integer> unfinished = new HashMap();
	    	 String answer ="";
	         for(String name : participant){
	        	 int count = unfinished.containsKey(name) ? unfinished.get(name) : 0;
	        	 unfinished.put(name, count+1);
	         }
	         for(String name : completion) {
	        	 unfinished.put(name, unfinished.get(name)-1);
	        	 if(unfinished.get(name) <= 0) unfinished.remove(name);
	         }
	         for(String name : unfinished.keySet()) {
	        	 answer += name;
	         }

	         return answer;
	    }
	    public static void main(String[] arg) {
	    	String[] id = {"mislav", "stanko", "mislav", "ana"};
	    	String[] b = {"stanko", "ana", "mislav"};
	    	String id_List = solution(id,b);
			System.out.print(id_List);
	}		
}