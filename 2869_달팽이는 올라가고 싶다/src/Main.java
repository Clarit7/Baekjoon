import java.util.Scanner;
/**
 * 달팽이가 v미터인 나무를 낮에 a미터씩 올라가고
 * 밤에 b미터씩 미끄러질 때 꼭대기까지 며칠이 걸리는지 구하는 프로그램
 *
 * @author Clarit
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextInt();	// 낮에 올라가는 높이
		double b = scan.nextInt(); // 밤에 미끄러지는 높이
		double v = scan.nextInt(); // 나무의 높이
		
		scan.close();
		
		// v-a 미터 이상 도달한 다음 날이 걸리는 날짜이다.
		// v-a 미터 이상 도달하는데 걸리는 날짜는 (v-a)[높이]를 (a-b)[하루에 올라가는 총 높이]로 나눈 값이다. 
		int days = (int) Math.ceil((v - a) / (a - b)) + 1;
		
		System.out.println(days);
	}
}
