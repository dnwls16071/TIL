//5개의 나라 이름과 인구를 입력받아 해시맵에 저장하고 가장 인구가 많은 나라를 검색하여 출력하는 프로그램을 작성하라.

package practice4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapDictEx5 {
    public static void main(String[] args) {
        HashMap<String, Integer> nations = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
        for (int i = 0; i < 5; i++) {
            System.out.print("나라 이름, 인구 >> ");
            String nation = scanner.next();
            Integer population = scanner.nextInt();
            nations.put(nation, population);
        }

        int resPop = 0;
        String resNat = "";
        Set<String> set = nations.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String name = it.next();
            int pop = nations.get(name);
            if (resPop < pop) {
                resPop = pop;
                resNat = name;
            }
        }

        System.out.println("제일 인구가 많은 나라는 (" + resNat + ", " + resPop + ")");
    }
}
