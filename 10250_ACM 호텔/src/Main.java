import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 호텔 방에 손님들을 순서대로 채울 때 특정 손님의 호텔 방 번호를 구하는 프로그램
 * 
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		// 호텔의 높이, n번째 입장 손님, 층, 정문으로부터의 거리
		int h, n, floor, distance = 0;
		String input = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test_case = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < test_case; i++) {
				input = reader.readLine();
				h = Integer.parseInt(input.split(" ")[0]);
				n = Integer.parseInt(input.split(" ")[2]);
				
				floor = (n - 1) % h + 1;	// 층 구하기
				distance = (n - 1) / h + 1;	// 정문으로부터의 거리 구하기
				
				System.out.println(floor + String.format("%02d", distance));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
