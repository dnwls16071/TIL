public class CatTest3 {
    public static void main(String[] args) {
        // 두 고양이 객체 생성
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        // 객체 필드 초기화
        cat1.name = "네로";
        cat2.name = "나비";

        // 두 고양이의 야옹~
        cat1.meow();
        cat2.meow();

        // 두 고양이의 할퀴기!
        cat1.claw();
        cat2.claw();
    }
}

/* 고양이 클래스 */
class Cat {
    /* 필드(상태) 영역 */
    String name;    // 이름
    String breeds;  // 품종
    int age;        // 나이

    /* 메소드(동작) 영역 */
    void meow() {
        System.out.printf("[%s]의 야옹~\n", name);
    }

    void claw() {
        /* 1. claw 메소드를 완성하시오. */
        System.out.printf("[%s]의 할퀴기! 샥샥~\n", name);
    }
}
