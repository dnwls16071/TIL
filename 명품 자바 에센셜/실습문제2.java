// 이름(name 필드)과 전화번호(tel 필드)를 가진 Phone클래스이다.
// 이름과 전화번호를 입력받아 2개의 Phone 객체를 생성하고 출력하는 main() 메서드를 작성하라.

package practice;

class Phone {
    private String name;
    private String tel;

    Phone(String name, String tel) {
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

public class Ex2 {
    public static void main(String[] args) {
        Phone phone1 = new Phone("A", "010-0000-0000");

        System.out.println(phone1.getName());
        System.out.println(phone1.getTel());

        Phone phone2 = new Phone("B", "010-1111-1111");

        System.out.println(phone2.getName());
        System.out.println(phone2.getTel());
    }
}

