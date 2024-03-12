**[5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.**

a. int[] arr[];

b. int[] arr = {1,2,3,};

c. int[] arr = new int[5];

d. int[] arr = new int[5]{1,2,3,4,5};

e. int arr[5];

f. int[] arr[] = new int[3][]

```bash
d. int[] arr = new int[5]{1,2,3,4,5};  // 대괄호에 숫자 불가(선언과 동시에 초기화하는 경우에만)

e. int arr[5];  // 배열을 선언할 땐 크기 지정 불가능
```

**[5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가?**

```java
package Exercise5;

public class Exercise5_2 {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10},
                {20, 20, 20, 20},
                {30, 30}
        };

        System.out.println(arr[3].length);
    }
}
```

**[5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.**

```java
package Exercise5;

public class Exercise5_3 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        System.out.println("sum="+sum);
    }
}
```

**[5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 작성하시오.**

```java
package Exercise5;

public class Exercise5_4 {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10, 10, 10},
                {20, 20, 20, 20, 20},
                {30, 30, 30, 30, 30}
        };

        int total = 0;
        float average = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
        }

        average = (float) total / (arr.length * arr[0].length);
        System.out.println("total="+total);
        System.out.println("average="+average);
    }
}
```

**[5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
(1)~(2)에 알맞은 코드를 넣어서 프로그램을 완성하시오.**

```java
package Exercise5;

public class Exercise5_5 {
    public static void main(String[] args) {
        int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ball3 = new int[3];

        // 배열 ballArr의 임의의 요소를 골라서 위치를 바꿔라.
        for (int i = 0; i < ballArr.length; i++) {
            int j = (int) (Math.random() * ballArr.length);
            int tmp = 0;

            tmp = ballArr[i];
            ballArr[i] = ballArr[j];
            ballArr[j] = tmp;
        }

        // 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사해라.
        System.arraycopy(ballArr, 0, ball3, 0, ball3.length);
        for (int i = 0; i < ball3.length; i++) {
            System.out.print(ball3[i]);
        }
    }
}
```

**[5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
단, 가능한 한 적은 수의 동전으로 거슬러 주어야 한다. (1)에 알맞은 코드를 넣어서 프로그램을 작성하시오.**

```java
package Exercise5;

public class Exercise5_6 {
    public static void main(String[] args) {
        int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        System.out.println("money="+money);

        for (int i = 0; i < coinUnit.length; i++) {
            int cnt = money / coinUnit[i];
            money %= coinUnit[i];
            System.out.println(coinUnit[i] + "원: "+cnt);
        }
    }
}
```

**[5-7] 문제 5-6에 동전의 개수를 추가한 프로그램이다. 커맨드라인부터 거슬러 줄 금액을 입력받아 계산한다. 보유한 동전의 개수로 거스름돈을 지불할 수 없다면, '거스름돈이 부족합니다.'라고 출력하고 종료한다.
지불할 돈이 충분히 있으면, 거스름돈을 지불할 만큼 가진 돈에서 빼고 남은 동전의 갯수를 화면에 출력한다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.**

```java
package Exercise5;

public class Exercise5_7 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java Exercise5_7 3120");
            System.exit(0);
        }

        int money = Integer.parseInt(args[0]);
        System.out.println("money="+money);

        int[] coinUnit = {500, 100, 50, 10};
        int[] coin = {5, 5, 5, 5};

        for (int i = 0; i < coinUnit.length; i++) {
            int coinNum = 0;
            // 1. 금액(money)를 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
            coinNum = money / coinUnit[i];

            // 2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
            if (coin[i] > coinNum) {
                coin[i] -= coinNum;
            } else {
                coinNum = coin[i];
                coin[i] = 0;
            }

            // 3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
            money -= coinNum * coinUnit[i];

            System.out.println(coinUnit[i]+"원: "+coinNum);
        }

        if (money > 0) {
            System.out.println("거스름돈이 부족합니다.");
            System.exit(0);
        }

        System.out.println("=남은 동전의 개수=");

        for (int i = 0; i < coinUnit.length; i++) {
            System.out.println(coinUnit[i]+"원:"+coin[i]);
        }
    }
}
```

**[5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'를 찍어서 그래프를 그리는 프로그램이다. 
(1)~(2)에 알맞은 코드를 넣어서 완성하시오.**

```java
package Exercise5;

public class Exercise5_8 {
    public static void main(String[] args) {
        int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
        int[] counter = new int[4];

        for (int i = 0; i < answer.length; i++) {
            int num = answer[i];
            counter[num - 1] += 1;
        }

        for (int i = 0; i < counter.length; i++) {
            System.out.print(counter[i]);
            for (int j = 0; j < counter[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

**[5-9★] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.**

```java
package Exercise5;

public class Exercise5_9 {
    public static void main(String[] args) {
        char[][] star = {
                {'*', '*', ' ', ' ', ' '},
                {'*', '*', ' ', ' ', ' '},
                {'*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*'}
        };

        char[][] result = new char[star[0].length][star.length];

        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                result[j][star.length-i-1] = star[i][j];
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
```

- 2차원 배열을 사용하면서 회전까지 고려하는 문제인데 머릿속으로만 생각하는 것이 어려워 종이에 그려가면서 문제를 해결했다.

**[5-10] 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다. (1)에 알맞은 코드를 넣어서 완성하시오.**

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/fde088cc-ba0b-4c0e-9231-45c4445ecc25)

```java
package Exercise5;

public class Exercise5_10 {
    public static void main(String[] args) {
        char[] abcCode =
                { '`','~','!','@','#','$','%','^','&','*',
                        '(',')','-','_','+','=','|','[',']','{',
                        '}',';',':',',','.','/'};
        char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};

        String src = "abc123";  // 암호화할 문장
        String result = "";     // 암호화 결과

        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                result += abcCode[ch - 'a'];
            } else if ('0' <= ch && ch <= '9') {
                result += numCode[ch - '0'];
            }
        }

        System.out.println("src:"+src);
        System.out.println("result:"+result);
    }
}
```

- Java에서 아스키 코드는 매우 빈번하게 사용이 되니 잘 기억해두자...

**[5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다. (1)에 알맞은 코드를 넣으시오.**

```java
package Exercise5;

public class Exercise5_11 {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        int[][] result = new int[score.length+1][score[0].length+1];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                result[i][j] = score[i][j];
                result[i][score[i].length] += result[i][j];
                result[score.length][j] += result[i][j];
                result[score.length][score[i].length] += result[i][j];
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
```

**[5-12] 예제 5-23을 변경하여 아래와 같은 결과가 나오도록 하시오.**

```bash
Q1. chair의 뜻은? dmlwk
틀렸습니다. 정답은 의자입니다.

Q2. computer의 뜻은? 컴퓨터
정답입니다.

Q3. integer의 뜻은? 정수
정답입니다.
```

```java
package Exercise5;

import java.util.Scanner;

public class Exercise5_12 {
    public static void main(String[] args) {
        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"}
        };

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);

            String temp = scanner.nextLine();

            if (temp.equals(words[i][1])) {
                System.out.println("정답입니다.");
                score += 1;
            } else {
                System.out.printf("틀렸습니다. 정답은 %s입니다.\n", words[i][1]);
            }

            System.out.println();
        }

        System.out.printf("전체 %d문제 중 %d문제 맞추셨습니다.", words.length, score);
    }
}
```

**[5-13] 단어의 글자위치를 무작위로 섞어서 보여주고 원래의 단어를 맞추는 예제이다. 실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오.**

```java
package Exercise5;

import java.util.Scanner;

public class Exercise5_13 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray();

            for (int j = 0; j < question.length; j++) {
                int randomIdx = (int) (Math.random() * question.length);
                char tmp = question[j];
                question[j] = question[randomIdx];
                question[randomIdx] = tmp;
            }

            System.out.printf("Q%d. %s의 정답을 입력하세요.>", i+1, new String(question));

            String answer = scanner.nextLine();

            if (answer.trim().equals(words[i])) {
                System.out.println("맞았습니다.");
            } else {
                System.out.println("틀렸습니다.");
            }

            System.out.println();
        }
    }
}
```

- `trim()` : 문자열 앞뒤의 공백을 제거하기 위해 사용하는 메서드
