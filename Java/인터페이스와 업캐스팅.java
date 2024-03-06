public class ObjectGrouping {
    public static void main(String[] args) {
        Bird bird = new Bird("새");
        Helicopter helicopter = new Helicopter("헬기");
        Rocket rocket = new Rocket("로켓");

        Flyable[] flyables = {bird, helicopter, rocket};

        for (Flyable flyable : flyables) {
            flyable.fly();
        }
    }
}

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    private String name;

    Bird(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.printf("<%s>가 날개를 퍼덕이며 날아갑니다!\n", this.name);
    }
}

class Helicopter implements Flyable {
    private String name;

    Helicopter(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.printf("<%s>가 프로펠러를 힘차게 돌리며 날아갑니다!\n", this.name);
    }
}

class Rocket implements Flyable {
    private String name;

    Rocket(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.printf("<%s>이 제트 엔진을 분출하며 날아갑니다!\n", this.name);
    }
}
