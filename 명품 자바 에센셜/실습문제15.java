// Adder 클래스는 util 패키지에, AdderClass는 app 패키지에 작성하여 응용프로그램을 완성하고 실행시켜라.

package practice2.util;

public class Adder {
    private int x;
    private int y;

    public Adder(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int add() {
        return x + y;
    }
}

package practice2.app;

import practice2.util.Adder;

public class Main {
    public static void main(String[] args) {
        Adder adder = new Adder(2, 5);
        System.out.println(adder.add());
    }
}
