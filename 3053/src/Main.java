import java.util.Scanner;
/**
 * 유클리드 기하학에서의 원의 넓이와 택시 기하학에서의 원의 넓이 출력
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
