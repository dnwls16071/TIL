public class Main {
    public static void main(String[] args) {
        // 객체 생성
        KRW krw = new KRW(1500, "원");
        USD usd = new USD(100.50, "달러");
        EUR eur = new EUR(260.87, "유로");
        JPY jpy = new JPY(1400, "엔");

        // 부모 클래스를 통한 그룹화
        Currency[] currencies = { krw, usd, eur, jpy };

        // 모든 화폐정보를 출력
        for (Currency c : currencies) {
            System.out.println(c.toString());
        }
    }
}

/* 1. 부모 클래스 Currency를 만드시오. */
class Currency {
    protected double amount;
    protected String notation;

    Currency(double amount, String notation) {
        this.amount = amount;
        this.notation = notation;
    }
}
/* 2. 상속을 통해 중복 코드를 제거 후, */
/* 3. 생성자를 올바르게 수정하시오. */
/* 4. toString() 메소드를 오버라이딩 하시오. */
class KRW extends Currency {
    public KRW(double amount, String notation) {
        super(amount, notation);
    }

    @Override
    public String toString() {
        return String.format("KRW: %.2f %s", amount, notation);
    }
}

class USD extends Currency{
    public USD(double amount, String notation) {
        super(amount, notation);
    }

    @Override
    public String toString() {
        return String.format("USD: %.2f %s", amount, notation);
    }
}

class EUR extends Currency{
    public EUR(double amount, String notation) {
        super(amount, notation);
    }

    @Override
    public String toString() {
        return String.format("EUR: %.2f %s", amount, notation);
    }
}

class JPY extends Currency{
    public JPY(double amount, String notation) {
        super(amount, notation);
    }

    @Override
    public String toString() {
        return String.format("JPY: %.2f %s", amount, notation);
    }
}
