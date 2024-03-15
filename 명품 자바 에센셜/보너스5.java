// 문자열을 입력받고 String 클래스를 이용하여 <Enter>키를 입력할 때마다 한 글자씩 회전시켜 출력하는 프로그램을 작성하라.
// q를 이볅하면 종료한다.

package practice2;

import java.util.Scanner;

public class StringRotateOnEnter {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요. 빈 칸이나 있어도 되고 영어 한글 모두 됩니다.");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("<Enter>를 입력하면 문자열이 한 글자씩 회전합니다.");

        while (true) {
            String key = scanner.nextLine();
            if (key.equals("")) {
                String first = text.substring(0, 1);
                String remain = text.substring(1, text.length());
                text = remain + first;
                System.out.print(text+" >>");
            } else {
                if (key.equals("q")) {
                    System.out.println("종료합니다...");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}
