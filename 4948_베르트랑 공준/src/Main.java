import java.util.Scanner;
/**
 * 특정 자연수 구간에 소수가 몇개 있는지 출력하는 프로그램
 * 
 * @author Clarit
 */
public class Main {
	
	static boolean[] notPrimeNumber;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		notPrimeNumber = new boolean[246913];
		generatePrimeNumber();
		
		int n = scan.nextInt();
		
		while (n != 0) {
			System.out.println(countPrimeNumber(n));
			n = scan.nextInt();
		}
		
		scan.close();
	}
	/**
	 * 246912이하인 소수의 배열 생성
	 */
	public static void generatePrimeNumber() {
		notPrimeNumber[0] = true;
		notPrimeNumber[1] = true;
		
		for (int i = 2; i <= 246912; i++)
			for (int j = 2; i*j <= 246912; j++ )
				notPrimeNumber[i * j] = true;
	}
	/**
	 * n초과 2n이하인 소수의 개수를 셈
	 * @param n 구간 설정에 필요한 변수
	 * @return 소수의 개수
	 */
	public static int countPrimeNumber(int n) {
		int count = 0;
		
		for (int i = n+1; i <= 2*n; i++)
			if (notPrimeNumber[i] == false)
				count++;
		
		return count;
	}
}
