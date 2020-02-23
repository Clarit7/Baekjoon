import java.util.Scanner;
/*
 * 재귀 함수를 이용해 n!을 추력하는 프로그램
 * @author Clarit7
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();

        System.out.println(factorial(n));
    }
    /*
     * 팩토리얼 메소드
     * @param n 팩토리얼을 계산할 정수
     */
    public static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
