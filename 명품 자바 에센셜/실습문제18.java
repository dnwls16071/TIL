//HashMap<String, Integer> 컬렉션을 생성하고 "에스프레소"는 2000원, "아메리카노"는 2500원, "카푸치노"는 3000원, "카페라떼"는 3500원을 저장한다.
//그리고 다음과 같이 음료수 이름을 입력받으면 HashMap에서 가격을 출력하라.

package practice4;

import java.util.HashMap;
import java.util.Scanner;


public class HashMapEx3 {
    public static void main(String[] args) {
        HashMap<String, Integer> dict = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        dict.put("에스프레소", 2000);
        dict.put("아메리카노", 2500);
        dict.put("카푸치노", 3000);
        dict.put("카페라떼", 3500);

        System.out.println("에스프레소, 아메리카노, 카푸치노, 카페라떼 있습니다.");
        while (true) {
            System.out.print("주문 >> ");
            String c = scanner.nextLine();
            if (c.equals("그만")) {
                break;
            } else {
                if (!dict.containsKey(c)) {
                    System.out.println("그런 메뉴는 없어요");
                } else {
                    int price = dict.get(c);
                    System.out.println(c + "는 " + price + "원입니다.");
                }
            }
        }
    }
}
