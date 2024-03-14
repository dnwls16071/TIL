// Math.random()의 난수 발생기를 이용하여 사용자와 컴퓨터가 하는 가위바위보 게임을 만들어보자.
// 가위, 바위, 보는 각각 1, 2, 3키이다. 사용자가 1, 2, 3 키 중 하나를 입력하면 동시에 프로그램에서 난수 발생기를 이용하여 1, 2, 3 중에 한 수를 발생시켜 컴퓨터가 낸 것을 결정한다.
// 그리고 사용자와 컴퓨터 둘 중 누가 이겼는지를 판별하여 승자를 출력한다.

package practice2;

import java.util.Scanner;

public class GameEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("가위(1), 바위(2), 보(3), 끝내기(4)>>");
            int num = scanner.nextInt();
            scanner.nextLine();
            int com = (int) (Math.random() * 3 + 1);

            if (num == 4) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }

            switch (num) {
                case 1:
                    System.out.print("사용자 가위 : ");
                    if (com == 1) {
                        System.out.println("컴퓨터 가위\n비겼습니다.");
                    } else if (com == 2) {
                        System.out.println("컴퓨터 바위\n사용자가 졌습니다.");
                    } else {
                        System.out.println("컴퓨터 보\n사용자가 이겼습니다.");
                    }
                    break;
                case 2:
                    System.out.print("사용자 바위 : ");
                    if (com == 1) {
                        System.out.println("컴퓨터 가위\n사용자가 이겼습니다.");
                    } else if (com == 2) {
                        System.out.println("컴퓨터 바위\n비겼습니다.");
                    } else {
                        System.out.println("컴퓨터 보\n사용자가 졌습니다.");
                    }
                    break;
                case 3:
                    System.out.print("사용자 보 : ");
                    if (com == 1) {
                        System.out.println("컴퓨터 가위\n사용자가 졌습니다.");
                    } else if (com == 2) {
                        System.out.println("컴퓨터 바위\n사용자가 이겼습니다.");
                    } else {
                        System.out.println("컴퓨터 보\n비겼습니다.");
                    }
                    break;
            }
        }
    }
}

