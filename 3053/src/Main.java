import java.util.Scanner;
/**
 * ��Ŭ���� �����п����� ���� ���̿� �ý� �����п����� ���� ���� ���
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		float r = scan.nextInt();
		
		scan.close();
		
		System.out.println(String.format("%.6f", Math.PI*r*r));
		System.out.println(String.format("%.6f", 2.0*r*r));
	}
}
