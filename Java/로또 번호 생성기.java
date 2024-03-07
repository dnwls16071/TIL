import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        // 객체 생성
        LottoMachine machine = new LottoMachine();

        // 번호 생성
        ArrayList<Integer> arr = machine.generate();

        // 결과 출력
        System.out.print("생성 번호: ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%d ", arr.get(i));
        }
    }
}

class LottoMachine {
    // 필드
    private ArrayList<Integer> numbers;

    // 생성자
    public LottoMachine() {
        numbers = new ArrayList<Integer>();

        /* 1. 번호(1 ~ 45)를 추가하세요. */
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
    }

    // 메소드
    public ArrayList<Integer> generate() {
        Random random = new Random();
        ArrayList<Integer> Lists = new ArrayList<>();

        /* 2. 임의의 숫자 6개를 추출하세요. */
        while (true) {
            if (Lists.size() == 6) {
                break;
            } else {
                int randomNumber = (random.nextInt(45) + 1);
                if (!Lists.contains(randomNumber)) {
                    Lists.add(randomNumber);
                }
            }
        }
        return Lists;
    }
}
