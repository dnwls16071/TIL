public class CylinderTest {
    public static void main(String[] args) {
        // 객체 생성
        Cylinder c = new Cylinder();

        // 속성 값 입력
        c.radius = 4;
        c.height = 5;

        // 출력
        System.out.printf("원기둥의 부피: %.2f\n", c.getVolume());
        System.out.printf("원기둥의 겉넓이: %.2f\n", c.getArea());
    }
}

class Cylinder {
    /* 필드와 메소드를 구현하시오. */
    int radius;
    int height;

    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    public double getArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
