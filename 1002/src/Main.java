import java.util.Scanner;
/**
 * 특정한 좌표가 주어진 터렛 두개가 적과의 거리를 각각 감지할 때, 적이 있을만한 좌표가 몇 군데인지 출력하는 프로그램
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
	 * 적이 있을만한 위치의 갯수를 계산
	 * @param x1 1번터렛 x좌표
	 * @param y1 1번터렛 y좌표
	 * @param r1 1번터렛 적과의 거리
	 * @param x2 2번터렛 x좌표
	 * @param y2 2번터렛 y좌표
	 * @param r2 2번터렛 적과의 거리
	 * @return
	 */
	public static int calculate(int x1, int y1, int r1, int x2, int y2, int r2) {
		int temp;
		
		// 둘 중 탐지거리(r)가 더 긴 터렛을 1번터렛으로 만듦
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
		
		int centre_dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);	// 두 터렛 거리의 제곱
		int radius_err;											// 탐지거리 차의 제곱 또는 합의 제곱
		
		// 1번터렛의 탐지거리 내에 2번터렛이 위치한 경우
		if (r1*r1 > centre_dist) {
			radius_err = (r1-r2)*(r1-r2);	// 탐지거리 차의 제곱
			if (radius_err > centre_dist)
				return 0;	// 1번터렛의 원과 2번터렛의 원이 내접하지도 않고 교차하지도 않는 경우 적이 있을수 있는 위치는 없다
			else if(radius_err == centre_dist) {
				if (x1==x2 && y1==y2)
					return -1;	// 1번터렛의 원과 2번터렛의 원이 중심도 같고 반지름도 같으면 적이 있을수 있는 위치는 무수히 많다
				else
					return 1;	// 1번터렛의 원과 2번터렛의 원이 중심은 다르면서 내접하면 적이 있을수 있는 위치는 내접점 하나다
			}
			else
				return 2;	// 1번터렛의 원과 2번터렛의 원이 교차하면 적이 있을수 있는 위치는 교차점 두개이다
		}
		// 1번터렛의 탐지거리 외에 2번터렛이 위치한 경우
		else {
			radius_err = (r1+r2)*(r1+r2);	// 탐지거리 합의 제곱
			if (radius_err > centre_dist)
				return 2;	// 1번터렛의 원과 2번터렛의 원이 교차하면 적이 있을수 있는 위치는 교차점 두개이다
			else if(radius_err == centre_dist) {
				return 1;	// 1번터렛의 원과 2번터렛의 원이 외접하면 적이 있을수 있는 위치는 외접점 하나다
			}
			else
				return 0;	// 1번터렛의 원과 2번터렛의 원이 교차하지도 않고 외접하지도 않으면 적이 있을수 있는 위치는 없다
		}
	}
}
