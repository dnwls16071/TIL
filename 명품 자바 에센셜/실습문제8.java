// 인터페이스 AddInterface를 상속받은 MyAdder 클래스를 작성하여 main()을 실행할 때 아래와 같은 결과를 얻도록 코드를 작성하라.

package practice1;

public class MyAdder implements AddInterface {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int add(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        MyAdder myAdder = new MyAdder();
        System.out.println(myAdder.add(5, 10));
        System.out.println(myAdder.add(10));
    }
}
