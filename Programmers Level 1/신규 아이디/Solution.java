package Test;

class Solution {
	    public static String solution(String new_id) {
	        new_id = new_id.toLowerCase()
	            .replaceAll("[^-_.a-z0-9]","")
	            .replaceAll("[.]{2,}",".")
	            .replaceAll("^[.]|[.]$","");

	        if(new_id.equals("")) new_id += "a";

	        if(new_id.length() >= 16){
	            new_id = new_id.substring(0,15)
	                .replaceAll("[.]$","");
	        }

	        while(new_id.length() <= 2){
	            new_id += new_id.charAt(new_id.length()-1);
	        } 

	        String answer = new_id;
	        return answer;
	    }
	    public static void main(String[] arg) {
	    	String id = "...!@BaT#*..y.abcdefghijklm";
	    	id = solution(id);
			System.out.print(id);
	}		
}