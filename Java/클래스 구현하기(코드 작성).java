/* Main 클래스 */
public class Main {
    public static void main(String[] args) {
        // Dog 객체 생성
        Dog d = new Dog();

        // Dog 객체 필드 값 출력
        System.out.printf("이름: %s\n", d.name);
        System.out.printf("품종: %s\n", d.breeds);
        System.out.printf("나이: %s\n", d.age);
    }
}

/* Dog 클래스 */
class Dog {
    /* 1. 필드 영역을 작성하시오. */
    String name;
    String breeds;
    int age;

    /* 2. 메소드 영역을 추가하시오. */
    void wag() {
        System.out.println("꼬리치기");
    }

    void bark() {
        System.out.println("짖기");
    }
}
