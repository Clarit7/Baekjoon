import java.util.Arrays;
import java.util.Scanner;
/**
 * Ư�� ¦���� ������ ��Ƽ��(�� ���� ���̰� ���� ������)�� ����ϴ� ����
 * 
 * @author Clarit
 */
public class Main {
	
	static boolean[] notPrimeNumber;	// �Ҽ��� �ƴ� index�� true�� �� �迭
	static int[] primeNumber;			// �Ҽ��� ������������ ����� �迭
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		notPrimeNumber = new boolean[10001];
		
		int count = generatePrimeNumber();
		primeNumber = new int[count];
		int j = 0;
		
		// notPrimeNumber�迭�� ���� ������������ ���ĵ� �Ҽ��� �迭 ����
		for (int i = 0; i <= 10000; i++)
			if (!notPrimeNumber[i])
				primeNumber[j++] = i; 
		
		int testCase = scan.nextInt();

		for (int i = 0; i < testCase; i++)
			goldbach(count, scan.nextInt());
		
		scan.close();
	}
	/**
	 * notPrimeNumber �迭 ����
	 * @return �迭 �� �Ҽ��� ����
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
	 * ������ ��Ƽ�� ����
	 * @param count �Ҽ��� ����
	 * @param n ������ ��Ƽ���� ������ ¦��
	 */
	public static void goldbach(int count, int n) {
		int a = 0, b = 0;
		int temp_a = 0, temp_b = 0;
		int min = (int) Double.POSITIVE_INFINITY;
		
		// 1. primeNumber�迭�� ���ʷ� �����ϰ� temp_a�� ����
		// 2. ������ ��Ƽ�� ������ ���ؼ� n - primeNumber�� �ش��ϴ� ���� �Ҽ� �迭�� �־�� ��
		// 3. n - primeNumber = temp_b�� �ش��ϴ� ���� �Ҽ� �迭�� �ִ��� ���̳ʸ� ��ġ�� ã�� ������ temp_a�� primeNumber�� ������ ����
		// 4. ���� temp_b�� �Ҽ� �迭�� ������ temp_a + temp_b = n�̹Ƿ� ������ ��Ƽ����
		// 5. temp_a, temp_b �� ���� ���̰� ���� ���� ��츦 ã�� ���� a�� b�� �����ϵ��� ��
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
