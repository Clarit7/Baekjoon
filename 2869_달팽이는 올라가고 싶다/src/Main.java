import java.util.Scanner;
/**
 * �����̰� v������ ������ ���� a���;� �ö󰡰�
 * �㿡 b���;� �̲����� �� �������� ��ĥ�� �ɸ����� ���ϴ� ���α׷�
 *
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextInt();	// ���� �ö󰡴� ����
		double b = scan.nextInt(); // �㿡 �̲������� ����
		double v = scan.nextInt(); // ������ ����
		
		scan.close();
		
		// v-a ���� �̻� ������ ���� ���� �ɸ��� ��¥�̴�.
		// v-a ���� �̻� �����ϴµ� �ɸ��� ��¥�� (v-a)[����]�� (a-b)[�Ϸ翡 �ö󰡴� �� ����]�� ���� ���̴�. 
		int days = (int) Math.ceil((v - a) / (a - b)) + 1;
		
		System.out.println(days);
	}
}
