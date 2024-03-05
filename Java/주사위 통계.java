// 자바 API를 불러옴
import java.lang.Math;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        int[] counts = new int[13];

        for (int i = 0; i < 100; i++) {
            int a = DieA.roll();
            int b = DieB.roll();
            counts[a + b]++;
        }

        for (int i = 2; i < counts.length; i++) {
            System.out.printf("%2d => ", i);
            for (int j = 0; j < counts[i]; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

class DieA {
    public static int roll() {
        double r = Math.random() * 6; // 0.0 <= r < 6.0
        int randInt = (int) r;        // 0, 1, 2, ..., 5
        return randInt + 1;           // 1, 2, 3, ..., 6
    }
}

class DieB {
    public static int roll() {
        Random rand = new Random();
        int randInt = rand.nextInt(6); // (0 ~ 5)
        return randInt + 1;
    }
}
