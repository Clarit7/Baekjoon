import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * �־��� �Է� �� �Ҽ��� ������ ����ϴ� ���α׷�ddd
 * 
 * @author Clarit
 */
public class Main {
	static List<Integer> primeNumber = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int count = 0;
		
		generatePrimeNumber();
		
		for (int i = 0; i < n; i++)
			if (primeNumber.contains(scan.nextInt()))
				count++;	// �Է��� ���� �Ҽ��̸� ī��Ʈ
		
		scan.close();
		
		System.out.println(count);
	}
	/**
	 * 1000���� �Ҽ��� ����Ʈ ����
	 */
	public static void generatePrimeNumber() {
		// 2�� 3 �̻��� Ȧ���� ����Ʈ�� ����
		primeNumber.add(2);
		for (int i = 3; i < 1000; i = i + 2)
			primeNumber.add(i);
		
		// ���� �Ҽ����� ���ʷ� 2�� �̻� ������迡 �ִ� ������ ��� ����
		for (int i = 3; i < 500; i = i + 2) {
			int k = 2;
			
			if (primeNumber.contains(i))
				while(k * i < 1000)
					primeNumber.remove((Integer) (k++ * i));
		}
	}
}
