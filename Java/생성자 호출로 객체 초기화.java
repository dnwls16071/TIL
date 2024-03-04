public class BicycleTest {
    public static void main(String[] args) {
        // 객체 생성 및 초기화
        Bicycle b1 = new Bicycle("부릉2", 21.74, 899000);
        Bicycle b2 = new Bicycle("씽씽2", 12.57, 495000);

        // 객체 정보 출력
        System.out.printf("Bicycle { %s, %.2fkg, %d원 }\n", b1.name, b1.weight, b1.price);
        System.out.printf("Bicycle { %s, %.2fkg, %d원 }\n", b2.name, b2.weight, b2.price);
    }
}

class Bicycle {
    // 필드
    String name;
    double weight;
    int price;

    // 생성자 - 파라미터를 통한 초기화
    Bicycle(String n, double w, int p) {
        name = n;
        weight = w;
        price = p;
    }
}
