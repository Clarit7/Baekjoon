import java.util.Arrays;
import java.util.Scanner;
/**
 * 특정 짝수의 골드바흐 파티션(두 수의 차이가 가장 적도록)을 출력하는 문제
 * 
 * @author Clarit
 */
public class Main {
	
	static boolean[] notPrimeNumber;	// 소수가 아닌 index가 true가 될 배열
	static int[] primeNumber;			// 소수가 오름차순으로 저장될 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		notPrimeNumber = new boolean[10001];
		
		int count = generatePrimeNumber();
		primeNumber = new int[count];
		int j = 0;
		
		// notPrimeNumber배열을 통해 오름차순으로 정렬된 소수의 배열 생성
		for (int i = 0; i <= 10000; i++)
			if (!notPrimeNumber[i])
				primeNumber[j++] = i; 
		
		int testCase = scan.nextInt();

		for (int i = 0; i < testCase; i++)
			goldbach(count, scan.nextInt());
		
		scan.close();
	}
	/**
	 * notPrimeNumber 배열 생성
	 * @return 배열 내 소수의 개수
	 */
	public static int generatePrimeNumber() {
		int count = 2;
		
		notPrimeNumber[0] = true;
		notPrimeNumber[1] = true;
		
		for (int i = 2; i <= 10000; i++)
			for (int j = 2; i*j <= 10000; j++)
				if (!notPrimeNumber[i*j]) {
					notPrimeNumber[i*j] = true;
					count++;
				}
		
		return 10001 - count;
	}
	/**
	 * 골드바흐 파티션 생성
	 * @param count 소수의 개수
	 * @param n 골드바흐 파티션을 생성할 짝수
	 */
	public static void goldbach(int count, int n) {
		int a = 0, b = 0;
		int temp_a = 0, temp_b = 0;
		int min = (int) Double.POSITIVE_INFINITY;
		
		// 1. primeNumber배열을 차례로 참조하고 temp_a에 저장
		// 2. 골드바흐 파티션 생성을 위해선 n - primeNumber에 해당하는 수가 소수 배열에 있어야 함
		// 3. n - primeNumber = temp_b에 해당하는 수가 소수 배열에 있는지 바이너리 서치로 찾고 없으면 temp_a는 primeNumber의 다음값 참조
		// 4. 만약 temp_b가 소수 배열에 있으면 temp_a + temp_b = n이므로 골드바흐 파티션임
		// 5. temp_a, temp_b 두 수의 차이가 가장 적은 경우를 찾아 각각 a와 b를 갱신하도록 함
		for (int i = 0; i < count; i++) {
			temp_a = primeNumber[i];
			temp_b = n - temp_a;
			
			if (temp_a * 2 > n) break;
			
			if (Arrays.binarySearch(primeNumber, temp_b) >= 0)
				if (Math.abs(temp_a - temp_b) < min) {
					a = temp_a;
					b = temp_b;
					min = Math.abs(a - b);
				}
		}
		
		System.out.println(a + " " + b);
	}
}
