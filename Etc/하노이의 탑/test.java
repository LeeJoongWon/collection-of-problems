package Test;

public class test {
	
	static int count = 0;

	static void move(int no, int x, int y) {
		
		/*	6 = x기둥번호 + y기둥번호 + 남은기둥번호
			6 - x기둥번호 - y기둥번호 = 남은기둥번호	*/

		if (no > 1)
			move(no - 1, x, 6 - x - y);
		
		System.out.println("원반[" + no + "]를 " + x  + "에서 " + y  + "으로 옮김");
		count++;
		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		

		int n = 3;

		move(n, 1, 3); // 1기둥에 쌓인 n개를 3기둥에 옮김
		System.out.println("옮긴 횟수 ="+count+"회");
	}
	
}

















