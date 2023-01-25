package Test;

public class test {
	
	static int n 	= 8; 	//	몇칸짜리인지 NxN
	static int count= 0;	//	정답갯수
	static int[] pos = new int[n];	// 각 열의 퀸의 위치를 담을 배열
	static boolean[] flag_a = new boolean[n];		// 각 행에 퀸이 있는지 체크
	static boolean[] flag_b = new boolean[(n*2)-1];	// ／대각선에 퀸이 있는지 체크
	static boolean[] flag_c = new boolean[(n*2)-1];	// ＼대각선에 퀸이 있는지 체크
	
	
	// 체스판(각 열의 퀸의 위치)을 출력
	static void print() {
		++count;
		System.out.println(count+"번째");

		for (int i = 0; i < pos.length; i++) {
			for (int j = 0; j < pos.length; j++) {
				System.out.printf("%s", j == pos[i] ? "■" : "□");
			}
				
			System.out.println();
		}
		System.out.println();
		
	}
	// i = 열 , j = 행
	static void set(int i) {
		for(int j=0;j<pos.length;j++) {
			
			if(flag_a[j] == false && 
				flag_b[i+j] == false && 
				flag_c[i-j+(pos.length-1)] == false) {
				
				pos[i] = j;
				if(i == pos.length-1) {
					print();
				}else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+(pos.length-1)] = true;
					set(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+(pos.length-1)] = false;
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		set(0);
	}
	
}

















