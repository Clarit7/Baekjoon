import java.util.Scanner;
/**
 * �־��� ������ �Ҽ��� ����Ʈ�� ����ϴ� ���α׷�(�����佺�׳׽��� ü)
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
	 * from ���� to ������ ����Ʈ ����
	 * @param from �Ҽ� ����Ʈ ����
	 * @param to �Ҽ� ����Ʈ ��
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