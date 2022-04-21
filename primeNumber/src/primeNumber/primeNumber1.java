package primeNumber;

/* 소수를 판별하는 코드를 작성하시오 */
public class primeNumber1 {
	
	public static void main(String[] arg) {

		int num = 1000;
		
		primeNumberA(num); 	//곱셈과 나눗셈을 수행한 횟수 :78022
		primeNumberB(num);	//곱셈과 나눗셈을 수행한 횟수 :14622
		primeNumberC(num);	//곱셈과 나눗셈을 수행한 횟수 :7279
		
		//입력한 숫자가 소수인지 판별하는  메소드
		System.out.println(is_prime_number(5));	//true
		System.out.println(is_prime_number(6));	//false
	}
	
	
	static void primeNumberA(int num){
		
		int counter = 0;	//나눗셈의 횟수측정
		
		for(int n =2; n <= num; n++) {
			
			int i;
			
			for(i = 2; i < n; i++) {
				
				counter++;
				
				if( n % i == 0) {
					break;
				}
				
			}
			
		}
		
		System.out.println("primeNumberA - 곱셈과 나눗셈을 수행한 횟수 :" + counter);
		
	}
	
	/* 개선된 코드 1 */
	static void primeNumberB(int num){
		
		int counter = 0;	//나눗셈의 횟수측정
		int ptr = 0;
		int[] prime = new int[500];	//소수를 저장
		
		prime[ptr++] = 2;	//2는 소수
		
		/* 소수를 구할떄 짝수는 2로 나누어지기 때문에 홀수만 판별하면 됨 */
		for(int n = 3; n <= num; n +=2) {
			
			int i;
			
			/* n이 2또는 3으로 나누어 떨어진다면  2x2=4, 2x3=6 과 같은 수로 다시 나눌 필요가 없습니다 (이미 2나 3으로 나누어 떨어지기 떄문에)
			* 그래서 소수로만 나눗셈을 한다면 나눗셈 획수를 줄일 수 있습니다 
			* 소수는 prime[] 에 저장됨 */
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
		
		System.out.println("primeNumberB - 곱셈과 나눗셈을 수행한 횟수 :" + counter);
		
	}
	
	/* 대칭성을 이용
	 * 18의 약수는 1, 2, 3, 6, 9, 18 
	 * 1x18, 2x9, 3x6, √18x√18, 6x3, 9x2, 18x1로 (√18x√18=18)
	 * √18기준으로 대칭을 이룸 -> 대칭의 기준인 √18보다 같거나 작은 숫자로 나누어지면 
	 * 그 이후에 대해서는 계산할 필요가 없음 
	 * √18의 값은 4.2426... 이므로 4까지 나누어 떨어지지 않으면 소수가 아니라는 의미
	 * -> n이 소수라면 n의 제곱근 이하의 어떠한 소수로도 나누어 떨어지지 않습니다*/
	static void primeNumberC(int num){
		
		int counter = 0;	//나눗셈의 횟수측정
		int ptr = 0;
		int[] prime = new int[500];	//소수를 저장
		
		//소수 2,3저장
		prime[ptr++] =2;
		prime[ptr++] =3;
		
		for(int n = 5; n <= num; n += 2) {
			
			boolean flag = false;
			
			/* 9미만은 2번째 for문이 성립되지 않아(3*3=9 <= 5 또는 7) if(!flag)에서 저장되고
			 * 9 부터를 예시로 들자면 
			 * prime[1]*prime[1] == 3*3 == 9 으로 for문이 실행되고
			 * if(n % prime[i] == 0)이 성립되므로
			 * flag가 true가 되서  if(!flag)는 실행되지 않는다
			 * prime[2]*prime[2] 는  5x5=25 이므로 for문을 벗어나게 됩니다 - 소수가 아닌걸로
			 * 그 다음 수 11은 boolean flag = false;를 만나 
			 * flag가 false가 됩니다
			 * 하지만 11은 if(n % prime[i] == 0)가 성립되지 않으므로 flag는 계속 false
			 * 이후 for문을 벗어나 if(!flag)를 만나면 조건이 성립되므로  
			 * prime[ptr++] = n; 가 실행되며  prime[] 배열에 저장됩니다  -- 소수 */
			for(int i = 1; prime[i]*prime[i] <= n; i++) {
				counter += 2;
				
				if(n % prime[i] == 0) {
					flag =true;
					counter++;
				}
				
			}
			
			//소수를 저장
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
			
		}
		
		System.out.println("primeNumberC - 곱셈과 나눗셈을 수행한 횟수 :" + counter);
		
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
