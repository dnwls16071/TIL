// SRP 원칙 개선

class Marine {
    String name;
    int hp;

    Marine(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    void stimPack() {
        System.out.printf("[%s]의 스팀팩! HP: %d -> %d\n", name, hp, hp-10);
        hp -= 10;
    }
}

class Medic {
    String name;
    int hp;
    int mp;

    Medic(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    void heal(Marine marine) {
        System.out.printf("[%s]의 치유! => [%s] HP(%d -> %d)\n", name, marine.name, marine.hp, marine.hp+10);
        mp -= 10;
        marine.hp += 10;
    }
}

public class Starcraft {
    public static void main(String[] args) {
        Marine marine = new Marine("레이너", 80);
        Medic medic = new Medic("모랄레스", 60, 60);

        marine.stimPack();
        medic.heal(marine);
    }
}
