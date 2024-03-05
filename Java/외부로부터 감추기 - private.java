public class Theif {
    // 메인 메소드
    public static void main(String[] args) {
        // 지갑 객체 생성
        Wallet wallet = new Wallet(30000);
        System.out.print(wallet.toString());

        // 지갑에서 돈을 모두 꺼냄
        Theif.steal(wallet);

        // 지갑 확인
        System.out.println(" -> " + wallet.toString());
    }

    // 클래스 메소드
    public static void steal(Wallet target) {
        target.money = 0;
    }
}

class Wallet {
    // 필드(인스턴스 변수)
    private int money; /* 1. 주어진 필드를 외부로부터 감추세요. */

    // 생성자
    public Wallet(int i) {
        money = i;
    }

    // 메소드
    public String toString() {
        return String.format("Wallet { money: %d }", money);
    }
}

// java: money has private access in codefactory.Wallet
