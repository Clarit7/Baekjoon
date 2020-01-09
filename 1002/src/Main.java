import java.util.Scanner;
/**
 * Ư���� ��ǥ�� �־��� �ͷ� �ΰ��� ������ �Ÿ��� ���� ������ ��, ���� �������� ��ǥ�� �� �������� ����ϴ� ���α׷�
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCase = scan.nextInt();
		
		int x1, y1, r1, x2, y2, r2;
		
		for (int i = 0; i < testCase; i++) {
			x1 = scan.nextInt();
			y1 = scan.nextInt();
			r1 = scan.nextInt();
			x2 = scan.nextInt();
			y2 = scan.nextInt();
			r2 = scan.nextInt();
			
			System.out.println(calculate(x1, y1, r1, x2, y2, r2));
		}
		
		scan.close();
	}
	/**
	 * ���� �������� ��ġ�� ������ ���
	 * @param x1 1���ͷ� x��ǥ
	 * @param y1 1���ͷ� y��ǥ
	 * @param r1 1���ͷ� ������ �Ÿ�
	 * @param x2 2���ͷ� x��ǥ
	 * @param y2 2���ͷ� y��ǥ
	 * @param r2 2���ͷ� ������ �Ÿ�
	 * @return
	 */
	public static int calculate(int x1, int y1, int r1, int x2, int y2, int r2) {
		int temp;
		
		// �� �� Ž���Ÿ�(r)�� �� �� �ͷ��� 1���ͷ����� ����
		if (r1 < r2) {
			temp = x1;
			x1 = x2;
			x2 = temp;
			
			temp = y1;
			y1 = y2;
			y2 = temp;
			
			temp = r1;
			r1 = r2;
			r2 = temp;
		}
		
		int centre_dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);	// �� �ͷ� �Ÿ��� ����
		int radius_err;											// Ž���Ÿ� ���� ���� �Ǵ� ���� ����
		
		// 1���ͷ��� Ž���Ÿ� ���� 2���ͷ��� ��ġ�� ���
		if (r1*r1 > centre_dist) {
			radius_err = (r1-r2)*(r1-r2);	// Ž���Ÿ� ���� ����
			if (radius_err > centre_dist)
				return 0;	// 1���ͷ��� ���� 2���ͷ��� ���� ���������� �ʰ� ���������� �ʴ� ��� ���� ������ �ִ� ��ġ�� ����
			else if(radius_err == centre_dist) {
				if (x1==x2 && y1==y2)
					return -1;	// 1���ͷ��� ���� 2���ͷ��� ���� �߽ɵ� ���� �������� ������ ���� ������ �ִ� ��ġ�� ������ ����
				else
					return 1;	// 1���ͷ��� ���� 2���ͷ��� ���� �߽��� �ٸ��鼭 �����ϸ� ���� ������ �ִ� ��ġ�� ������ �ϳ���
			}
			else
				return 2;	// 1���ͷ��� ���� 2���ͷ��� ���� �����ϸ� ���� ������ �ִ� ��ġ�� ������ �ΰ��̴�
		}
		// 1���ͷ��� Ž���Ÿ� �ܿ� 2���ͷ��� ��ġ�� ���
		else {
			radius_err = (r1+r2)*(r1+r2);	// Ž���Ÿ� ���� ����
			if (radius_err > centre_dist)
				return 2;	// 1���ͷ��� ���� 2���ͷ��� ���� �����ϸ� ���� ������ �ִ� ��ġ�� ������ �ΰ��̴�
			else if(radius_err == centre_dist) {
				return 1;	// 1���ͷ��� ���� 2���ͷ��� ���� �����ϸ� ���� ������ �ִ� ��ġ�� ������ �ϳ���
			}
			else
				return 0;	// 1���ͷ��� ���� 2���ͷ��� ���� ���������� �ʰ� ���������� ������ ���� ������ �ִ� ��ġ�� ����
		}
	}
}
