import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * ���ּ��� ������ �Ÿ��� ������ �� ���� Ƚ���� ����ϴ� ���α׷�
 * ���ּ��� ó���� �������� 1���⸸ ������ �� �ְ� �� �ܿ��� ���� ���� �Ÿ��� ���ų� 1���⾿ ũ������ �Ÿ��θ� ������ �� �ִ�.
 * ��ȭ�� �̿� ����
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		long[] list = new long[65537];
		
		// ��ȭ���� ���ʰ� �Ǵ� �迭 ����
		for (int i = 0; i < 65537; i++)
			list[i] = (long) i * (long) (i+1);
		
		String input = null;
		long x, y = 0;
		long distance = 0;
		int index = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test_case = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < test_case; i++) {
				input = reader.readLine();
				x = Long.parseLong(input.split(" ")[0]);
				y = Long.parseLong(input.split(" ")[1]);
				distance = y - x;
				
				// ������ �ϴ� �Ÿ��� �迭���� �� ��° �ε��� ���Ͽ� �ش��ϴ��� �˾Ƴ�
				index = Arrays.binarySearch(list, distance);
				if (index < 0) index = index * -1 - 1;
				
				if (distance > (list[index] + list[index - 1]) / 2)	// ��ȭ��
					System.out.println(index * 2);
				else
					System.out.println(index * 2 - 1);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
