import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ȣ�� �濡 �մԵ��� ������� ä�� �� Ư�� �մ��� ȣ�� �� ��ȣ�� ���ϴ� ���α׷�
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		// ȣ���� ����, n��° ���� �մ�, ��, �������κ����� �Ÿ�
		int h, n, floor, distance = 0;
		String input = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test_case = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < test_case; i++) {
				input = reader.readLine();
				h = Integer.parseInt(input.split(" ")[0]);
				n = Integer.parseInt(input.split(" ")[2]);
				
				floor = (n - 1) % h + 1;	// �� ���ϱ�
				distance = (n - 1) / h + 1;	// �������κ����� �Ÿ� ���ϱ�
				
				System.out.println(floor + String.format("%02d", distance));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
