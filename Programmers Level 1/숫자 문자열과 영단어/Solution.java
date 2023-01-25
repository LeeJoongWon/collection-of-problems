package Test;

class Solution {
	
	public static void main(String[] arg) {
		
	    String txt = "one4seveneight";
	    String[] numberEnglish = {
	    			"zero","one","two","three","four",
	    			"five","six","seven","eight","nine"};
		
	    for(int i =0; i<numberEnglish.length;i++) {
	    	txt = txt.replaceAll(numberEnglish[i], Integer.toString(i));
	    }
	    
	    int aws = Integer.parseInt(txt);
	    System.out.print(aws);
	    
	}		
}
