public class CatTest2 {
    public static void main(String[] args) {
        // 고양이 객체 c1 생성
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        // 메소드 호출
        cat1.meow();
        cat2.meow();

        /* 1. 할퀴기 메소드를 호출하시오. */
        cat1.claw();
        cat2.claw();
    }
}


/* 고양이 클래스 */
class Cat {
    /* 필드(상태) */
    String name;    // 이름
    String breeds;  // 품종
    int age;        // 나이

    /* 메소드(동작) */
    void meow() {
        System.out.println("야옹~");
    }

    void claw() {
        /* 2. 할퀴기 메소드를 완성하시오. */
        System.out.println("할퀴기!! 슥샥!");
    }
}
