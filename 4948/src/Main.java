import java.util.Scanner;
/**
 * Ư�� �ڿ��� ������ �Ҽ��� � �ִ��� ����ϴ� ���α׷�
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
	 * 246912������ �Ҽ��� �迭 ����
	 */
	public static void generatePrimeNumber() {
		notPrimeNumber[0] = true;
		notPrimeNumber[1] = true;
		
		for (int i = 2; i <= 246912; i++)
			for (int j = 2; i*j <= 246912; j++ )
				notPrimeNumber[i * j] = true;
	}
	/**
	 * n�ʰ� 2n������ �Ҽ��� ������ ��
	 * @param n ���� ������ �ʿ��� ����
	 * @return �Ҽ��� ����
	 */
	public static int countPrimeNumber(int n) {
		int count = 0;
		
		for (int i = n+1; i <= 2*n; i++)
			if (notPrimeNumber[i] == false)
				count++;
		
		return count;
	}
}
