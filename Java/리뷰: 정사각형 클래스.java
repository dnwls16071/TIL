public class SquareTest {
    public static void main(String[] args) {
        /* 객체 생성 */
        Square square = new Square();

        /* 필드 초기화(값 변경) */
        square.length = 4;

        /* 결과 출력 */
        square.area(square.length);
    }
}

/* 정사각형 클래스 구현 */
class Square {
    int length;

    void area(int length) {
        System.out.println("한 변의 길이가 " + this.length + "인 정사각형의 넓이: " + this.length * this.length);
    }
}
