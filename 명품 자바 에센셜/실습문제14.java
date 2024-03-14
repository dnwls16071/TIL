// 다음과 같이 +로 연결된 덧셈식을 입력받아 덧셈 결과를 출력하는 프로그램을 작성하라.
// StringTokenizer의 Integer.parseInt(), String의 trim()을 활용하라.

package practice2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sc = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(sc, "+");

        int sum = 0;
        while (st.hasMoreTokens()) {
            String num = st.nextToken().trim();
            sum += Integer.parseInt(num);
        }
        System.out.println("합은 "+sum);
    }
}
