// 도형을 묘사하는 인터페이스 ShapeEditor가 있다.
// main() 메서드의 실행 결과를 참고하여, 인터페이스 ShapeEditor을 구현한 클래스 Circle을 작성하고 전체 프로그램을 완성하라.

package practice1;

interface ShapeEditor {
    final double PI = 3.14;

    void draw();

    double getArea();
    default public void redraw() {
        System.out.println("---다시 그립니다.---");
        draw();
    }
}

class Circle implements ShapeEditor {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("반지름 %d ", radius);
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}

public class Bonus2 {
    public static void main(String[] args) {
        // 인터페이스의 타입으로 인터페이스를 구현한 구현체 클래스 인스턴스를 참조한 것(다형성)
        ShapeEditor coin = new Circle(10);
        coin.redraw();
        System.out.println("코인의 면적은 " + coin.getArea());
    }
}
