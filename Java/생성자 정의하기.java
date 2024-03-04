public class HeroTest {
    public static void main(String[] args) {
        // 객체 생성
        Hero ironMan = new Hero("아이언맨", 80);
        Hero thanos = new Hero("타노스", 160);
        Hero thor = new Hero("토르", 150);
        Hero groot = new Hero("그루트", 40);
        Hero[] heroes = {ironMan, thanos, thor, groot};

        // 모든 객체 정보를 출력
        for (Hero hero : heroes) {
            System.out.println(hero.toStr());
        }
    }
}

// Hero 클래스
class Hero {
    // 필드
    String name;
    int hp;

    // 생성자
    Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // 메소드
    String toStr() {
        return String.format("Hero { name: %s, hp: %d }", name, hp);
    }
}
