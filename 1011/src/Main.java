import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 우주선이 정해진 거리를 가려할 때 워프 횟수를 출력하는 프로그램
 * 우주선은 처음과 마지막에 1광년만 워프할 수 있고 그 외에는 이전 워프 거리와 같거나 1광년씩 크고작은 거리로만 워프할 수 있다.
 * 점화식 이용 문제
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		long[] list = new long[65537];
		
		// 점화식의 기초가 되는 배열 생성
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
				
				// 가고자 하는 거리가 배열에서 몇 번째 인덱스 이하에 해당하는지 알아냄
				index = Arrays.binarySearch(list, distance);
				if (index < 0) index = index * -1 - 1;
				
				if (distance > (list[index] + list[index - 1]) / 2)	// 점화식
					System.out.println(index * 2);
				else
					System.out.println(index * 2 - 1);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
