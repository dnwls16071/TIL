// 다음은 가로 세로로 구성되는 박스를 표현한 Box 클래스와 이를 이용하는 코드이다. Box의 draw()는 fill 필드에 지정된 문자로 자신을 그린다.
// 실행 결과를 보면서 코드를 완성하라.

package practice;

public class Box {
    private int width, height;
    private char fillChar;
    public Box() {
        this(10, 1);
    }

    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(fillChar);
            }
            System.out.println();
        }
    }

    public void fill(char c) {
        fillChar = c;
    }

    public static void main(String[] args) {
        Box a = new Box();
        Box b = new Box(20, 3);
        a.fill('*');
        b.fill('%');
        a.draw();
        b.draw();
    }
}
