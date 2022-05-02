package Test;

public class test {

	public static boolean isPrimeNumber(int num) {
		if (num % 2 == 0 || num % 3 == 0)
			return false;
		for (int n = 5; n <= Math.sqrt(num); n += 2) {
			if (num % n == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int answer = 0;
		int[] nums = { 1, 2, 7, 6, 4 };
		int primeNumber = 0;

		for (int i = 0; i < nums.length-2; i++)
			for (int j = i + 1; j < nums.length-1; j++)
				for (int k = j + 1; k < nums.length; k++) {
					primeNumber = nums[i] + nums[j] + nums[k];
					if (isPrimeNumber(primeNumber)) {
						answer++;
					}
				}

		System.out.print(answer);

	}
}
