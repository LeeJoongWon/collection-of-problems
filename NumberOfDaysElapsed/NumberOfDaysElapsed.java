import java.util.Scanner;


/*그 해의 경과 일수를 구하시오*/
public class NumberOfDaysElapsed {

	//각 달의 일수
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},	//평년  mdays[0][]
			{31,28,31,30,31,30,31,31,30,31,30,31}	//윤년  mdays[1][]
	};
	
	// 평년 윤년 구분 / 윤년 1 평년 0 반환
	static int isLeep(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	static int dayOfYear(int y,int m, int d) {
		
		int days = d;
		
		/*평년인지 윤년인지 isLeep 메소드로 구분하여 2차원배열 mdays에 접근
		 * 예를들어 2022년 3월 5일(평년) 이라면 
		 * days = 5 (3월 5일), mdays[0][0] = 31 (1월의 일수), mdays[0][1] = 28 (2월  일수)
		 * 5+31+28 = 64 */
		for(int i = 1; i < m; i++) {
			days += mdays[isLeep(y)][i-1];
		}
		
		return days;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.print("년 : "); int year = scanner.nextInt();
			System.out.print("월 : "); int month = scanner.nextInt();
			System.out.print("일 : "); int day = scanner.nextInt();
			
			System.out.printf(" 그 해의 %d일째 입니다", dayOfYear(year, month, day));
			
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
		}
		
	}
	
}
