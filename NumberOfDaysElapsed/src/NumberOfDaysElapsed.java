import java.util.Scanner;


/*�� ���� ��� �ϼ��� ���Ͻÿ�*/
public class NumberOfDaysElapsed {

	//�� ���� �ϼ�
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},	//���  mdays[0][]
			{31,28,31,30,31,30,31,31,30,31,30,31}	//����  mdays[1][]
	};
	
	// ��� ���� ���� / �����ϋ� 1 ����ϋ� 0 ��ȯ
	static int isLeep(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	static int dayOfYear(int y,int m, int d) {
		
		int days = d;
		
		/*������� �������� isLeep �޼ҵ�� �����Ͽ� 2�����迭 mdays�� ����
		 * ������� 2022�� 3�� 5��(���) �̶�� 
		 * days = 5 (3�� 5��), mdays[0][0] = 31 (1���� �ϼ�), mdays[0][1] = 28 (2��  �ϼ�)
		 * 5+31+28 = 64 */
		for(int i = 1; i < m; i++) {
			days += mdays[isLeep(y)][i-1];
		}
		
		return days;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.print("�� : "); int year = scanner.nextInt();
			System.out.print("�� : "); int month = scanner.nextInt();
			System.out.print("�� : "); int day = scanner.nextInt();
			
			System.out.printf(" �� ���� %d��° �Դϴ�", dayOfYear(year, month, day));
			
		} catch (Exception e) {
			System.out.println("���ڸ� �Է����ּ���");
		}
		
	}
	
}
