// 앞의 수 6가지냐 임의의 수 6가지냐 + 중복 고려한 코드 리팩토링

import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class SimpleLottoMachine {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] result = new int[6];

        // 45개의 공을 만든다
        for (int i = 1; i <= 45; i++) {
            list.add(i);
        }

        // 섞는다
        Collections.shuffle(list);

        // 뽑는다
        for (int i = 0; i < 6; i++) {
            result[i] = list.get(i);
        }

        // 결과 출력
        System.out.printf("자동 생성 번호: %s", Arrays.toString(result));
    }
}
