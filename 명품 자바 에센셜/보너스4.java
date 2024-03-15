// StringBuffer클래스를 이용하여 사용자로부터 영문 한 줄을 입력받고, 글자 하나만 랜덤하게 선택하여 다른 글자로 수정하여 출력하는 프로그램을 작성하라.
// 공백도 수정에 포함된다.

package practice2;

import java.util.Scanner;

public class StringBufferEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                System.out.println("종료합니다...");
                System.exit(0);
            }

            StringBuffer sb = new StringBuffer(s);
            int index = (int) (Math.random() * sb.length());
            while (true) {
                int i = (int) (Math.random() * 26);
                char c = (char) ('a' + i);
                sb.replace(index, index + 1, String.valueOf(c));
                break;
            }
            System.out.println(sb);
        }
    }
}

//by Java API Documentation
//StringBuffer(String str)
//Constructs a string buffer initialized to the contents of the specified string

//public static String valueOf(char c)
//Returns the string representation of the char argument.
//Parameters:
//c - a char.
//Returns:
//a string of length 1 containing as its single character the argument c.
