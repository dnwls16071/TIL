public class SmartPhoneTest {
    public static void main(String[] args) {
        // 객체 생성
        SmartPhone sp = new SmartPhone("아이폰", "010-0000-0000");

        // 전화 걸기
        sp.call("010-1234-5678");

        // 전화벨이 울림
        sp.ring();
    }
}

interface Phone {
    void call(String targetNumber);

    void ring();
}

class SmartPhone implements Phone {
    protected String name;
    protected String phoneNumber;

    public SmartPhone(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void call(String targetNumber) {
        System.out.println(targetNumber + "로 전화를 겁니다!");
    }

    @Override
    public void ring() {
        System.out.println("전화벨이 울립니다~");
    }
}
