package primeNumber;

/* �Ҽ��� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ� */
public class primeNumber1 {
	
	public static void main(String[] arg) {

		int num = 1000;
		
		primeNumberA(num); 	//������ �������� ������ Ƚ�� :78022
		primeNumberB(num);	//������ �������� ������ Ƚ�� :14622
		primeNumberC(num);	//������ �������� ������ Ƚ�� :7279
		
		//�Է��� ���ڰ� �Ҽ����� �Ǻ��ϴ�  �޼ҵ�
		System.out.println(is_prime_number(5));	//true
		System.out.println(is_prime_number(6));	//false
	}
	
	
	static void primeNumberA(int num){
		
		int counter = 0;	//�������� Ƚ������
		
		for(int n =2; n <= num; n++) {
			
			int i;
			
			for(i = 2; i < n; i++) {
				
				counter++;
				
				if( n % i == 0) {
					break;
				}
				
			}
			
		}
		
		System.out.println("primeNumberA - ������ �������� ������ Ƚ�� :" + counter);
		
	}
	
	/* ������ �ڵ� 1 */
	static void primeNumberB(int num){
		
		int counter = 0;	//�������� Ƚ������
		int ptr = 0;
		int[] prime = new int[500];	//�Ҽ��� ����
		
		prime[ptr++] = 2;	//2�� �Ҽ�
		
		/* �Ҽ��� ���ҋ� ¦���� 2�� ���������� ������ Ȧ���� �Ǻ��ϸ� �� */
		for(int n = 3; n <= num; n +=2) {
			
			int i;
			
			/* n�� 2�Ǵ� 3���� ������ �������ٸ�  2x2=4, 2x3=6 �� ���� ���� �ٽ� ���� �ʿ䰡 �����ϴ� (�̹� 2�� 3���� ������ �������� ������)
			* �׷��� �Ҽ��θ� �������� �Ѵٸ� ������ ȹ���� ���� �� �ֽ��ϴ� 
			* �Ҽ��� prime[] �� ����� */
			for(i=1;i<ptr; i++) {
				counter++;
				
				if(n% prime[i] == 0) {
					break;
				}
				
			}
			
			if(ptr == i) {
				prime[ptr++] = n;
			}
			
		}
		
		System.out.println("primeNumberB - ������ �������� ������ Ƚ�� :" + counter);
		
	}
	
	/* ��Ī���� �̿�
	 * 18�� ����� 1, 2, 3, 6, 9, 18 
	 * 1x18, 2x9, 3x6, ��18x��18, 6x3, 9x2, 18x1�� (��18x��18=18)
	 * ��18�������� ��Ī�� �̷� -> ��Ī�� ������ ��18���� ���ų� ���� ���ڷ� ���������� 
	 * �� ���Ŀ� ���ؼ��� ����� �ʿ䰡 ���� 
	 * ��18�� ���� 4.2426... �̹Ƿ� 4���� ������ �������� ������ �Ҽ��� �ƴ϶�� �ǹ�
	 * -> n�� �Ҽ���� n�� ������ ������ ��� �Ҽ��ε� ������ �������� �ʽ��ϴ�*/
	static void primeNumberC(int num){
		
		int counter = 0;	//�������� Ƚ������
		int ptr = 0;
		int[] prime = new int[500];	//�Ҽ��� ����
		
		//�Ҽ� 2,3����
		prime[ptr++] =2;
		prime[ptr++] =3;
		
		for(int n = 5; n <= num; n += 2) {
			
			boolean flag = false;
			
			/* 9�̸��� 2��° for���� �������� �ʾ�(3*3=9 <= 5 �Ǵ� 7) if(!flag)���� ����ǰ�
			 * 9 ���͸� ���÷� ���ڸ� 
			 * prime[1]*prime[1] == 3*3 == 9 ���� for���� ����ǰ�
			 * if(n % prime[i] == 0)�� �����ǹǷ�
			 * flag�� true�� �Ǽ�  if(!flag)�� ������� �ʴ´�
			 * prime[2]*prime[2] ��  5x5=25 �̹Ƿ� for���� ����� �˴ϴ� - �Ҽ��� �ƴѰɷ�
			 * �� ���� �� 11�� boolean flag = false;�� ���� 
			 * flag�� false�� �˴ϴ�
			 * ������ 11�� if(n % prime[i] == 0)�� �������� �����Ƿ� flag�� ��� false
			 * ���� for���� ��� if(!flag)�� ������ ������ �����ǹǷ�  
			 * prime[ptr++] = n; �� ����Ǹ�  prime[] �迭�� ����˴ϴ�  -- �Ҽ� */
			for(int i = 1; prime[i]*prime[i] <= n; i++) {
				counter += 2;
				
				if(n % prime[i] == 0) {
					flag =true;
					counter++;
				}
				
			}
			
			//�Ҽ��� ����
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
			
		}
		
		System.out.println("primeNumberC - ������ �������� ������ Ƚ�� :" + counter);
		
	}
	
	static boolean is_prime_number(int num) { 
		
		int r = 1;
		boolean sw = false; 
		double sqrt_value = Math.sqrt(num); 
		
		do { 
			
			r++; 
			
			if(r > sqrt_value) { 
				sw = true; 
				} 
			
			} while(num % r != 0 && sw == false); 
		
		return sw; 
		
		}
}
