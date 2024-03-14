// Scanner를 이용하여 한 라인을 읽고 공백으로 분리된 어절이 몇 개인지 출력을 반복하는 프로그램을 작성하라.
// exit이 입력되면 프로그램을 종료한다.

package practice2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                System.out.println("종료합니다...");
                break;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
                int cnt = stringTokenizer.countTokens();
                System.out.println("어절 개수는 " + cnt);
            }
        }
    }
}
