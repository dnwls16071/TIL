public class Main {
    public static void main(String[] args) {
        // 서로 다른 객체 생성
        Juice j = new Juice();
        Coffee c = new Coffee();
        Beer b = new Beer();
        Water w = new Water();
        Tea t = new Tea();

        // 부모 클래스 타입의 배열 생성
        Drink[] drinks = { j, c, b, w, t };

        // 모든 음료를 주문!
        for (Drink d : drinks) {
            d.ordered();
        }
    }
}

interface Drink {
    void ordered();
}

class Juice implements Drink{
    String name;
    double price;
    public void ordered() {
        System.out.println("주문되었습니다.");
    }
}

class Coffee implements Drink{
    String name;
    double price;
    public void ordered() {
        System.out.println("주문되었습니다.");
    }
}

class Beer implements Drink{
    String name;
    double price;
    public void ordered() {
        System.out.println("주문되었습니다.");
    }
}

class Water implements Drink{
    String name;
    double price;
    public void ordered() {
        System.out.println("주문되었습니다.");
    }
}

class Tea implements Drink{
    String name;
    double price;
    public void ordered() {
        System.out.println("주문되었습니다.");
    }
}
