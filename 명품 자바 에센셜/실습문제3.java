// 사각형을 표현하는 다음 Rect 클래스를 활용하여 Rect 객체 배열을 생성하고 4개의 사각형 클래스를 담은 객체 배열에 저장한 뒤,
// 배열을 검색하여 사각형 면적의 합을 출력하는 main() 메서드를 작성하라.

package practice;

class Rect {
    private int width;
    private int height;

    Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Rect[] rects = {new Rect(3, 5), new Rect(3, 9),
                        new Rect(2, 7), new Rect(9, 5)};

        int totalArea = 0;
        for (Rect rect : rects) {
            totalArea += rect.getArea();
        }
        System.out.printf("사각형의 전체 합은 %d",totalArea);
    }
}
