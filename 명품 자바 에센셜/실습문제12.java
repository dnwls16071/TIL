// main()의 실행 결과 클래스명과 점 값을 연결하여 MyPoint(3, 20)이 출력되도록 MyPoint클래스를 작성하라.

package practice2;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        MyPoint a = new MyPoint(3, 20);
        System.out.println(a);
    }
}
