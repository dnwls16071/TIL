public class LockTest {
    public static void main(String[] args) {
        // 객체 생성
        Lock lock = new Lock("123!@#");

        /* 1. 세터를 호출하여, 비밀번호를 변경하시오. */
        lock.setPassword("654#@!");

        // 객체 정보 출력
        System.out.println(lock.toString());
    }
}

class Lock {
    // 필드
    private String password;

    // 생성자
    public Lock(String p) {
        password = p;
    }

    // 메소드
    public String toString() {
        return String.format("Lock { password: %s }", password);
    }

    /* 2. 비밀번호 변경을 위한, 세터 메소드를 추가하시오. */
    public void setPassword(String password) {
        this.password = password;
    }
}
