// 중심을 표현하는 int타입의 x, y 필드와 반지름 값을 저장하는 int타입의 radius 필드를 가진 Circle 클래스를 작성하고자 한다.
// 생성자는 x, y, radius 값을 인자로 받아 필드를 초기화하고, equals() 메서드는 면적이 같으면 두 Circle 객체가 동일한 것으로 판별한다.
// 아래는 Circle 클래스와 이를 활용하는 코드의 실행 결과이다. 빈칸을 채워라.

package practice2;

import java.util.Objects;

class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")반지름 " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        Circle circle = (Circle) obj;
        if (Math.PI * circle.radius * circle.radius == Math.PI * radius * radius) {
            return true;
        } else {
            return false;
        }
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Circle a = new Circle(1, 2, 10);
        Circle b = new Circle(5, 7, 10);
        System.out.println("원 1: " + a);
        System.out.println("원 2: " + b);

        if (a.equals(b)) {
            System.out.println("같은 원입니다.");
        } else {
            System.out.println("다른 원입니다.");
        }
    }
}

//by Java API Documentation
//public boolean equals(Object obj)
//Returns true if and only if the argument is not null and is a Boolean object that represents the same boolean value as this object.
//        Overrides:
//equals in class Object
//Parameters:
//obj - the object to compare with.
//        Returns:
//        true if the Boolean objects represent the same value; false otherwise.
//See Also:
//        Object.hashCode(), HashMap
