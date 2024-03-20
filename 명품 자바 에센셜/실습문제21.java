// Location클래스는 2차원 평면에서 하나의 위치(x, y)를 표현한다. Location객체로 쥐가 이동한 각 위치를 저장하고 이들로부터 총 이동거리를 구하고자 한다.
// ArrayList컬렉션에 쥐의 위치(Location 객체)를 5개 입력받아 삽입한 후 총 길이를 구하라. 시작 위치는 (0, 0)이며 도착 위치는 (0, 0)이다.

package practice4;

import codefactory.Lotto;

import java.util.ArrayList;
import java.util.Scanner;

class Location {
    private int x;
    private int y;

    public Location() {
        this(0, 0);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Location location) {
        double dist = Math.sqrt((x - location.x) * (x - location.x) + (y - location.y) * (y - location.y));
        return dist;
    }
}

public class HashMapDictEx7 {
    public static void main(String[] args) {
        ArrayList<Location> arrayList = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        arrayList.add(new Location());
        System.out.println("쥐가 이동한 위치(x, y)를 5개 입력하세요.");
        for (int i = 0; i < 5; i++) {
            System.out.print(">> ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arrayList.add(new Location(x, y));
        }
        arrayList.add(new Location());

        double sum = 0.0;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            double d = arrayList.get(i).distance(arrayList.get(i + 1));
            sum += d;
        }

        System.out.println("총 이동거리는 " + sum);
    }
}
