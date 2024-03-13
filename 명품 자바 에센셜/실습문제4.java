// 이름(name)과 전화번호(tel), 생성자 및 필요한 메소드를 가진 Phone 클래스를 작성하고 실행 사례와 같이 작동하도록 main()을 가진 Ex4 클래스를 작성하라.
// 단, 한 사람의 전화번호는 하나의 Phone 객체로 다룬다.

package practice;

import java.util.Scanner;

class Phone1 {
    private String name;
    private String tel;

    Phone1(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("인원수>>");
        int num = scanner.nextInt();
        String name, tel;
        scanner.nextLine();
        Phone1[] arr = new Phone1[num];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
            name = scanner.next();
            tel = scanner.next();
            arr[i] = new Phone1(name, tel);
        }
        System.out.println("저장되었습니다...");

        while (true) {
            System.out.print("검색할 이름>>");
            name = scanner.next();
            if (name.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                boolean found = false;
                for (int i = 0; i < num; i++) {
                    if (arr[i].getName().equals(name)) {
                        tel = arr[i].getTel();
                        System.out.println(name+"의 번호는 "+tel+" 입니다.");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println(name+"은/는 존재하지 않습니다.");
                }
            }
        }
    }
}
