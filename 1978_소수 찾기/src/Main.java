import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 주어진 입력 중 소수의 개수를 출력하는 프로그램ddd
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
				count++;	// 입력한 수가 소수이면 카운트
		
		scan.close();
		
		System.out.println(count);
	}
	/**
	 * 1000이하 소수의 리스트 생성
	 */
	public static void generatePrimeNumber() {
		// 2와 3 이상의 홀수를 리스트에 넣음
		primeNumber.add(2);
		for (int i = 3; i < 1000; i = i + 2)
			primeNumber.add(i);
		
		// 작은 소수부터 차례로 2배 이상 배수관계에 있는 수들을 모두 없앰
		for (int i = 3; i < 500; i = i + 2) {
			int k = 2;
			
			if (primeNumber.contains(i))
				while(k * i < 1000)
					primeNumber.remove((Integer) (k++ * i));
		}
	}
}
