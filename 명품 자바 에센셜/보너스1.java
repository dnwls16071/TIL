// 두 사람이 번갈아 하는 갬블링 게임을 만들어 보자.
// 0에서 2사이의 정수 3개를 랜덤하게 발생시켜 모두 같으면 승리한다. 선수는 Player클래스로 표현한다.
// 실행 결과를 참고하여 다음 코드를 완성하라.

package practice;

import java.util.Scanner;

class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] p = new Player[2];
        for (int i = 0; i < 2; i++) {
            System.out.print("선수 이름 입력 >>");
            p[i] = new Player(scanner.nextLine());
        }
        int n = 0;
        while (true) {
            System.out.print(p[n].getName() + " <Enter 외 아무키나 치세요>");
            scanner.nextLine();
            int[] val = new int[3];
            for (int i = 0; i < 3; i++) {
                val[i] = (int) (Math.random() * 3);
                System.out.print(val[i] + "\t");
            }
            System.out.println();
            if (val[0] == val[1] && val[1] == val[2]) {
                System.out.printf("%s 승리하였습니다.", p[n].getName());
                break;
            }
            n++;
            n %= 2;
        }
    }
}
