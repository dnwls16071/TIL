// 하나의 클래스는 하나의 책임만을 가지는 SRP원칙 위배
// 마린 클래스와 메딕 클래스를 분리해서 작성하는 것이 좋음
class Soldier {
    String name;
    int hp;
    int mp;

    Soldier(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.mp = 0;
    }

    Soldier(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    void stimPack(Soldier soldier) {
        System.out.printf("[%s]의 스팀팩! HP: %d -> %d\n", soldier.name, soldier.hp, soldier.hp-10);
        soldier.hp -= 10;
    }

    void heal(Soldier soldier1, Soldier soldier2) {
        System.out.printf("[%s]의 치유! => [%s] HP(%d -> %d)", soldier1.name, soldier2.name, soldier2.hp, soldier2.hp+10);
        soldier1.mp -= 10;
    }
}

public class Starcraft {

    public static void main (String[] args) {
        // 객체 생성
        Soldier soldier1 = new Soldier("모랄레스", 60, 60);
        Soldier soldier2 = new Soldier("레이너", 80);

        // 마린의 스팀팩!
        soldier2.stimPack(soldier2);

        // 메딕의 힐!
        soldier1.heal(soldier1, soldier2);
    }
}
