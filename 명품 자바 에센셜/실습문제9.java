// 다음 코드와 실행 결과를 참고하여 추상 클래스 Calculator를 상속받는 Adder와 Subtracter클래스를 작성하라.

package practice1;


import java.util.Scanner;

abstract class Calculator {
    protected int a, b;
    abstract protected int calc();
    protected void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 2개를 선택하세요>>");
        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    public void run() {
        input();
        int res = calc();
        System.out.println("계산된 값은 " + res);
    }
}

class Adder extends Calculator {
    @Override
    protected int calc() {
        return a + b;
    }
}

class Subtracter extends Calculator {

    @Override
    protected int calc() {
        return a - b;
    }
}

public class App {
    public static void main(String[] args) {
        Adder adder = new Adder();
        Subtracter subtracter = new Subtracter();

        adder.run();
        subtracter.run();
    }
}
