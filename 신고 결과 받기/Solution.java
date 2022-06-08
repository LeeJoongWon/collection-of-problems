import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
	
	public static int[] solution(String[] id_list,String[] report,int k) {
		// Key:신고한 사람  		Value:신고처리 횟수
        Map<String, Integer> reporterList = new HashMap();
        // Key:신고당한 사람		Value:Key를 신고한 사람들
        Map<String, HashSet<String>> reportedList = new HashMap();
        
        //초기화
        for(String s : id_list){
            reporterList.put(s,0);
            reportedList.put(s,new HashSet<>());
        }
        
        //신고당한사람 데이터를 만들기 위함
        //report 데이터는  스페이스바 기준 앞쪽은 신고당한사람 뒷쪽은 신고한 사람
        for(String s : report){
        	//split이용 스페이스바 기준으로 나누어 신고자와 신고당한사람을 분리
        	String[] reportStr = s.split(" ");
            String reporter = reportStr[0];
            String reported = reportStr[1]; 
            //get으로 신고당한사람을(Key)찾고 add로 신고한 사람을(Value)추가
            reportedList.get(reported).add(reporter);
        }
        
        //K번이상 신고당한 사람을 찾고 신고자들에게 메일을 보내기 위함
        //신고당한사람 리스트를 순환하며 
        for(String s : reportedList.keySet()) {
        	HashSet<String> userForSend = reportedList.get(s);
        	//K번 이상 신고당한사람을 찾아
        	if(userForSend.size() >= k) {
        		//신고자 리스트를 순환하며
        		for(String id : userForSend) {
        			//신고자(Key)를 찾아 신고처리횟수를 증가
        			reporterList.put(id, reporterList.get(id)+1);
        		}
        	}
        }

        int[] answer = new int[id_list.length];  
        for(int i=0;i<id_list.length;i++){   
            answer[i] = reporterList.get(id_list[i]);
        }
        
        return answer;
    }
	
	public static void main(String[] arg) {
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		int[] x = solution(id_list, report , 2);
	}		
}