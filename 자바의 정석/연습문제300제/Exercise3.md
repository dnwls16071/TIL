**[3-1] 다음 연산의 결과를 적으시오.**

```java
package Exercise3;

public class Exercise3_1 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        char c = 'A';

        System.out.println(1 + x << 33);                // 6  
        System.out.println(y >= 5 || x < 0 && x > 2);   // true
        System.out.println(y += 10 - x++);              // 13
        System.out.println(x+=2);                       // 5
        System.out.println( !('A' <= c && c <='Z') );   // false
        System.out.println('C'-c);                      // 2
        System.out.println('5'-'0');                    // 5
        System.out.println(c+1);                        // 66 
        System.out.println(++c);                        // B
        System.out.println(c++);                        // B
        System.out.println(c);                          // C
    }
}
```

**[3-2] 아래의 코드는 사과를 담는데 필요한 바구니 버켓 의 수를 구하는 코드이다.
만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면 13개가 필요할 것이다 
(1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_2 {
    public static void main(String[] args) {
        int numOfApples = 123;
        int sizeOfBucket = 10;
        int numOfBucket = (numOfApples / sizeOfBucket) + (numOfApples % sizeOfBucket > 0 ? 1 : 0);

        System.out.println("필요한 바구니의 수 : " + numOfBucket);
    }
}
```

**[3-3] 아래는 변수 num의 값에 따라 '양수', '음수', '0'을 출력하는 코드이다. 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_3 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num > 0 ? "양수" : (num == 0) ? "0" : "음수");
    }
}
```

**[3-4] 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 456이면 400이 되고, 111이라면 100이 된다. (1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_4 {
    public static void main(String[] args) {
        int num = 456;
        System.out.println((num / 100) * 100);
    }
}
```

**[3-5] 아래는 변수 num의 값 중에서 일의 자리를 1로 비꾸는 코드이다. 만일 변수 num의 값이 333이라면 334이 되고, 777이라면 771이 된다. (1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_5 {
    public static void main(String[] args) {
        int num = 333;
        System.out.println((num / 10) * 10 + 1);
    }
}
```

**[3-6] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 코드이다.
예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우 20이고, 81의 경우 90이 된다. 30에서 24를 뺀 나머지는 6이기 때문에 변수 num의 값이 24라면 6을 결과로 얻어야 한다. (1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_6 {
    public static void main(String[] args) {
        int num = 24;
        // System.out.println((num / 10 + 1) * 10 - num);
        System.out.println(10 - num % 10);
    }
}
```

**[3-7] 아래는 화씨(F)를 섭씨(C)로 변환하는 코드이다. 변환 공식이 `C = 5/9 × (F - 32)`라고 할 때, (1)에 알맞은 코드를 넣으시오. 단 변환 결과값은 소수점 셋째자리에서 반올림해야한다. (Math.round()를 사용하지 않고 처리할 것)**

```java
package Exercise3;

public class Exercise3_7 {
    public static void main(String[] args) {
        // 화씨 온도
        int fahrenheit = 100;

        // 화씨를 섭씨로 변환
        float celsius = (int) ((5.0 / 9.0) * (fahrenheit - 32) * 100 + 0.5) / 100f;

        // 결과 출력
        System.out.println("F = " + fahrenheit);
        System.out.println("C = " + celsius);
    }
}
```

- [1]. 화씨온도를 100으로 설정한 후 계산한 중간값을 나타내면 37.7777778 이와 같이 나오게 된다.

- [2]. [1]의 결과에 100을 곱한다.(37.7777778 → 3777.77778)

- [3]. [2]의 결과에 0.5를 더한다.(3778.278)

- [4]. [3]의 결과를 정수형 타입으로 변환한다.(3778)

- [5]. [4]의 결과를 100으로 나눈다.

**[3-8] 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.**

```java
package Exercise3;

public class Exercise3_8 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a + b);

        char ch = 'A';
        ch = (char) (ch + 2);

        float f = 3 / 2f;
        long l = 3000 * 3000 * 3000L;

        float f2 = 0.1f;
        double d = 0.1;

        boolean result = (float) d == f2;

        System.out.println("c="+c);
        System.out.println("ch="+ch);
        System.out.println("f="+f);
        System.out.println("l="+l);
        System.out.println("result="+result);
    }
}
```

```java
byte a = 10;
byte b = 20;
byte c = (byte) (a + b);
```

- 변수 a와 b는 모두 byte타입으로 덧셈연산을 수행하기 전에 int타입으로 자동형변환된다.

- int와 int의 덧셈이므로 연산결과는 int가 된다. 근데 변수 c의 타입은 byte타입이므로 이를 위해 명시적 형변환을 해주어야 한다.

```java
char ch = 'A';
ch = (char) (ch + 2);
```

- char타입이 덧셈연산의 과정을 거치면서 int타입으로 변환되므로 char타입의 변수에 저장하기 위해서 char타입으로 명시적 형변환을 해주어야 한다.

```java
boolean result = (float) d == f2;
```

- 변수 d는 double타입이고 변수 f2는 float타입이다. 두 실수형 타입의 오차가 다르기 때문에 하나의 타입으로 일치시킨다.

**[3-9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드이다.
(1)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_9 {
    public static void main(String[] args) {
        char ch = '0';
        boolean b = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || '0' <= ch && ch <= '9' ? true : false;
        System.out.println(b);
    }
}
```

**[3-10] 다음은 대문자를 소문자로 변경하는 코드인데, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다. 문자코드는 소문자가 대문자보다 32만큼 더 크다. 예를 들어, 'A'의 코드는 65이고, 'a'의 코드는 97이다. (1), (2)에 알맞은 코드를 넣으시오.**

```java
package Exercise3;

public class Exercise3_10 {
    public static void main(String[] args) {
        char ch = 'A';

        char lowerCase = ('A' <= ch && ch <= 'Z' ? (char) (ch + 32) : ch);

        System.out.println("ch:"+ch);
        System.out.println("ch to lowerCase:"+lowerCase);
    }
}
```

- 덧셈연산의 결과는 항상 int타입이다. 따라서 이를 다른 타입으로 변환하려면 형변환을 해주어야 한다.
