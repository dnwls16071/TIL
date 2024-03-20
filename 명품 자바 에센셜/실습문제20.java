// 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성하라. 이 프로그램은 고객의 이름과 포인트를 누적하여 관리한다.
// 한 고객의 입력이 끝나면 현재까지의 모든 고객의 포인트 점수를 출력한다.

package practice4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapDictEx6 {
    public static void main(String[] args) {
        HashMap<String, Integer> program = new HashMap<>();
        System.out.println("** 포인트 관리 프로그램입니다. **");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("이름과 포인트 입력 >> ");
            String name = scanner.next();
            if (name.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            } else {
                int point = scanner.nextInt();
                if (program.containsKey(name)) {
                    program.put(name, program.get(name) + point);
                } else {
                    program.put(name, point);
                }
                printMap(program);
            }
        }
    }

    public static void printMap(HashMap<String, Integer> Map) {
        Set<String> set = Map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String name = it.next();
            int point = Map.get(name);
            System.out.print("("+name+","+point+")");
        }
        System.out.println();
    }
}
