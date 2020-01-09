import java.util.Scanner;
/**
 * 주어진 범위의 소수의 리스트를 출력하는 프로그램(에라토스테네스의 체)
 * 
 * @author Clarit
 */
public class Main {
	
	static int[] primeNumber = new int[1000001];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int from = scan.nextInt();
		int to = scan.nextInt();

		scan.close();
		
		generatePrimeNumber(from, to);
	}
	/**
	 * from 부터 to 까지의 리스트 생성
	 * @param from 소수 리스트 시작
	 * @param to 소수 리스트 끝
	 */
	public static void generatePrimeNumber(int from, int to) {
		
		primeNumber[1] = 1;
		
		for (int i = 2; i <= to; i++)
			for (int j = 2; i*j <= to; j++ )
				primeNumber[i * j] = 1;
		
		for (int i = from; i <= to; i++)
			if (primeNumber[i] != 1)
				System.out.println(i);
	}
}