import java.util.Scanner;
/**
 * �簢���� ���� ������ ��ǥ �ϳ��� ����ϴ� ���α׷�
 * 
 * @author Claritd
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x1, x2, x3, y1, y2, y3;
		
		x1 = scan.nextInt();
		y1 = scan.nextInt();
		x2 = scan.nextInt();
		y2 = scan.nextInt();
		x3 = scan.nextInt();
		y3 = scan.nextInt();
		
		scan.close();
		
		if (x1 == x2)
			System.out.print(x3 + " ");
		else if (x1 == x3)
			System.out.print(x2 + " ");
		else
			System.out.print(x1 + " ");
		
		if (y1 == y2)
			System.out.println(y3);
		else if (y1 == y3)
			System.out.println(y2);
		else
			System.out.println(y1);
	}
}
