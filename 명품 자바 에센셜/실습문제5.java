// CircleManager는 static메소드를 가진 클래스이다.
// StaticTest클래스는 static메소드를 활용하는 사례를 보여준다, 실행 결과를 참고하여 코드를 완성하라.

package practice;

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class CircleManager {
    static void copy(Circle src, Circle dest) {
        dest.setRadius(src.getRadius());
    }

    static boolean equals(Circle a, Circle b) {
        if (a.getRadius() == b.getRadius()) {
            return true;
        } else {
            return false;
        }
    }
}


public class StaticTest {
    public static void main(String[] args) {
        Circle pizza = new Circle(5);
        Circle waffle = new Circle(1);

        boolean res = CircleManager.equals(pizza, waffle);

        if (res) {
            System.out.println("pizza와 waffle 크기가 서로 같음");
        } else {
            System.out.println("pizza와 waffle 크기가 서로 다름");
        }

        CircleManager.copy(pizza, waffle);
        res = CircleManager.equals(pizza, waffle);

        if (res) {
            System.out.println("pizza와 waffle 크기가 서로 같음");
        } else {
            System.out.println("pizza와 waffle 크기가 서로 다름");
        }
    }
}
