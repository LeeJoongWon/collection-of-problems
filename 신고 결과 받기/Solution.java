import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
	
	public static int[] solution(String[] id_list,String[] report,int k) {
		// Key:�Ű��� ���  		Value:�Ű�ó�� Ƚ��
        Map<String, Integer> reporterList = new HashMap();
        // Key:�Ű���� ���		Value:Key�� �Ű��� �����
        Map<String, HashSet<String>> reportedList = new HashMap();
        
        //�ʱ�ȭ
        for(String s : id_list){
            reporterList.put(s,0);
            reportedList.put(s,new HashSet<>());
        }
        
        //�Ű���ѻ�� �����͸� ����� ����
        //report �����ʹ�  �����̽��� ���� ������ �Ű���ѻ�� ������ �Ű��� ���
        for(String s : report){
        	//split�̿� �����̽��� �������� ������ �Ű��ڿ� �Ű���ѻ���� �и�
        	String[] reportStr = s.split(" ");
            String reporter = reportStr[0];
            String reported = reportStr[1]; 
            //get���� �Ű���ѻ����(Key)ã�� add�� �Ű��� �����(Value)�߰�
            reportedList.get(reported).add(reporter);
        }
        
        //K���̻� �Ű���� ����� ã�� �Ű��ڵ鿡�� ������ ������ ����
        //�Ű���ѻ�� ����Ʈ�� ��ȯ�ϸ� 
        for(String s : reportedList.keySet()) {
        	HashSet<String> userForSend = reportedList.get(s);
        	//K�� �̻� �Ű���ѻ���� ã��
        	if(userForSend.size() >= k) {
        		//�Ű��� ����Ʈ�� ��ȯ�ϸ�
        		for(String id : userForSend) {
        			//�Ű���(Key)�� ã�� �Ű�ó��Ƚ���� ����
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