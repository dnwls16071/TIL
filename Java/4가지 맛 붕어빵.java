public class FishBreadTest {
    public static void main(String[] args) {
        // 객체 배열 생성
        FishBread[] breads = new FishBread[4];

        /* 1. 붕어빵 객체를 팥/고구마/치즈/슈크림 순으로 만드시오. */
        breads[0] = new FishBread(0); // 팥 붕어빵
        breads[1] = new FishBread(1); // 고구마 붕어빵
        breads[2] = new FishBread(2); // 치즈 붕어빵
        breads[3] = new FishBread(3); // 슈크림 붕어빵

        // 모든 붕어빵 객체 정보 출력
        for (int i = 0; i < FishBread.count; i++) {
            breads[i].print();
        }
        System.out.println("==============");

        /* 2. 전체 붕어빵 객체 수를 출력하시오. */
        System.out.printf("붕어빵 객체 수: %d", FishBread.count);
    }
}

class FishBread {
    // 인스턴스 변수(non-static 필드)
    String contents;  // 내용물

    // 클래스 변수(static 필드)
    static int count; // 붕어빵 객체 수

    // 생성자
    public FishBread(int n) {
        // 내용물 선택 - 0: 팥, 1: 고구마, 2: 치즈, 3: 슈크림
        String[] arr = {"팥", "고구마", "치즈", "슈크림"};
        contents = arr[n];

        // 붕어빵 객체 수 카운팅
        FishBread.count++;
    }

    // 메소드
    void print() {
        System.out.printf("[%s] 붕어빵\n", contents);
    }
}
