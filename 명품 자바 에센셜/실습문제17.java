// Scanner를 사용하여 학점('A', 'B', 'C', 'D', 'F')을 5개만 문자로 입력받아 ArrayList에 저장하라.
// 그러고 나서 다시 ArrayList를 검색하여 5개의 학점을 점수(A=4.0, B=3.0, C=2.0, D=1.0, F=0.0)로 변환하여 출력하는 프로그램을 작성하라.

package practice3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayListEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        System.out.print("빈 칸으로 분리하여 5개의 학점을 입력(A/B/C/D/F)>>");
        for (int i = 0; i < 5; i++) {
            String s = scanner.next();
            System.out.println(s);
            al.add(s);
            switch (s) {
                case "A":
                    System.out.print("4.0"+" ");
                    break;
                case "B":
                    System.out.print("3.0"+" ");
                    break;
                case "C":
                    System.out.print("2.0"+" ");
                    break;
                case "D":
                    System.out.print("1.0"+" ");
                    break;
                case "F":
                    System.out.print("0.0"+" ");
                    break;
                default:
                    System.out.print("잘못된 입력입니다. 프로그램을 종료합니다.");
                    break;
            }
        }
    }
}
