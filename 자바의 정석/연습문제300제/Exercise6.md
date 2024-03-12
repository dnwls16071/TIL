**[6-1] 다음과 같은 멤버변수를 갖는 SutdaCard클래스를 정의하시오.**

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/b4200733-16be-4a9f-93f5-5ea3bbf9e9dc)

```java
package Exercise6;

class SutdaCard {
    int num;
    boolean isKwang;
}
```

**[6-2] 문제 6-1에서 정의한 SutdaCard클래스에 두 개의 생성자와 info()를 추가해서 실행 결과와 같은 결과를 얻도록 하시오.**

```java
package Exercise6;

class SutdaCard {
    int num;
    boolean isKwang;

    // 생성자 추가
    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    String info() {
        return num + (isKwang ? "K" : "");
    }
}
```

```java
package Exercise6;

public class Exercise6_2 {
    public static void main(String[] args) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();

        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}
```

**[6-3] 다음과 같은 멤버변수를 갖는 Student클래스를 정의하시오.**

```java
package Exercise6;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
}
```

**[6-4] 문제 6-3에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal()과 getAverage()를 추가하시오.**

```bash
1. 메서드명 : getTotal
   기능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
   반환타입 : int
   매개변수 : 없음

2. 메서드명 : getAverage
   기능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다. + 소수점 둘째자리에서 반올림할 것
   반환타입 : float
   매개변수 : 없음
```

```java
package Exercise6;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) (getTotal() / 3f * 10 + 0.5) / 10f;
    }
}
```

```java
package Exercise6;

public class Exercise6_4 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름:" + s.name);
        System.out.println("총점:" + s.getTotal());
        System.out.println("평균:" + s.getAverage());
    }
}
```

[1]. 총점의 타입이 int이기 때문에 3으로 나누면 int와 int간의 연산이므로 결과를 int로 얻게 된다.

[2]. 결과를 int로 얻게 된다는 것은 소수점 이하 부분이 절사된다는 뜻이므로 이를 해결하기 위해 3f로 나누어 소수점 이하 값들을 회복한다.

[3]. 소수점 둘째 자리에서 반올림하려면 10을 곱한 후 0.5를 더하고 다시 10f로 나눈다.

**[6-5] 다음과 같은 실행결과를 얻도록 Student클래스에 생성자와 info()를 추가하시오.**

```java
package Exercise6;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) (getTotal() / 3f * 10 + 0.5) / 10f;
    }

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math+","+getTotal()+","+getAverage();
    }
}
```

```java
package Exercise6;

public class Exercise6_5 {
    public static void main(String[] args) {
        // 생성자를 활용한 객체 초기화
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);
        System.out.println(s.info());
    }
}
```

**[6-6] 두 점의 거리를 계산하는 getDistance()를 완성하시오. 이 때, 제곱근을 계산할 때 `Math.sqrt(double a)`를 사용하세요.**

```java
package Exercise6;

public class Exercise6_6 {
    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1,1,2,2));
    }
}
```

**[6-7] 문제 6-6에서 작성한 클래스메서드 getDistance()를 MyPoint클래스의 인스턴스 메서드로 정의하시오.**

```java
package Exercise6;

public class Exercise6_7 {
    public static void main(String[] args) {
        MyPoint p = new MyPoint(1, 1);

        System.out.println(p.getDistance(2, 2));
    }
}

class MyPoint {
    int x;
    int y;
    
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    double getDistance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
}
```

**[6-8] 다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오.**

```java
package Exercise6;

class PlayingCard {
    int kind;
    int num;

    static int width;
    static int height;

    PlayingCard(int k, int n) {
        kind = k;
        num = n;
    }

    public static void main(String[] args) {
        PlayingCard card = new PlayingCard(1, 1);
    }
}
```

[1]. 클래스변수(static변수) : width, height

[2]. 인스턴스변수 : kind, num

[3]. 지역변수 : k, n, args, card

[4]. 변수가 선언된 위치를 보면 변수의 종류를 알 수 있다. 클래스 블럭 내에 선언된 변수는 인스턴스 변수이고 static이 붙은 것은 static 변수이다. 나머지는 모두 지역변수이다.

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/8e5d6d81-9180-466c-9bbd-aebc9d39c32c)

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/e2d82bbd-23d9-4bd2-a8ef-d5dd8f3c6697)

**[6-9] 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가? (단, 모든 병사의 공격력과 방어력은 같아야 한다.)**

```java
package Exercise6;

class Marine {
    int x=0, y=0;
    int hp = 60;
    int weapon = 6;
    int armor = 0;
    void weaponUp() {
        weapon++;
    }
    void armorUp() {
        armor++;
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

```java
package Exercise6;

class Marine {
    int x=0, y=0;
    int hp = 60;
    static int weapon = 6;
    static int armor = 0;
    static void weaponUp() {
        weapon++;
    }
    static void armorUp() {
        armor++;
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

[1]. 모든 마린들의 공격력과 방어력은 모두 같아야하므로 weapon, armor은 클래스 변수로 선언한다.

[2]. 공격력과 방어력 업그레이드 역시 모든 마린들에게 공통적으로 적용되어야하므로 클래스 메서드로 선언한다.

**[6-10] 다음 중 생성자에 대한 설명으로 옳지 않은 것은?**

a. 모든 생성자의 이름은 클래스의 이름과 동일해야한다

b. 생성자는 객체를 생성하기 위한 것이다

c. 클래스에는 생성자가 반드시 하나 이상 있어야 한다

d. 생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다

e. 생성자는 오버로딩 할 수 없다

```bash
b. 생성자는 객체를 생성하기 위한 것이다.
→ 생성자가 객체를 생성할 때 사용되기는 하지만, 객체를 초기화할 목적으로 사용되는 것이다. 객체를 생성하는 것은 new 연산자이다.

e. 생성자는 오버로딩 할 수 없다.
→ 생성자도 오버로딩이 가능해서 하나의 클래스에 여러 개의 생성자를 정의할 수 있다.
```

**[6-11] 다음 중 this에 대한 설명으로 맞지 않은 것은? (모두 고르시오)**

a. 객체 자신을 가리키는 참조변수이다

b. 클래스 내에서라면 어디서든 사용할 수 있다

c. 지역변수와 인스턴스변수를 구별할 때 사용한다

d. 클래스 메서드 내에서는 사용할 수 없다

```bash
b. 클래스 멤버(static이 붙은 것)에 대해선 사용할 수 없다.
→ 사용 시점에 인스턴스가 생성되었는지 확인할 수 없기 때문에
```

**[6-12] 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은?**

a. 메서드의 이름이 같아야 한다

b. 매개변수의 개수나 타입이 달라야 한다

c. 리턴타입이 달라야 한다

d. 매개변수의 이름이 달라야 한다

```bash
c. 리턴타입이 달라야 한다.

d. 매개변수의 이름이 달라야 한다.
```

```bash
오버로딩의 조건

[1]. 메서드 이름이 같아야 한다.

[2]. 매개변수의 개수 또는 타입이 달라야 한다.

[3]. 매개변수는 같고 리턴타입이 다른 경우는 오버로딩이 성립되지 않는다.
→ 리턴타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.
```

**[6-13] 다음 중 아래의 add 메서드를 올바르게 오버로딩 한 것은? (모두 고르시오)**

```java
long add(int a, int b) {return a + b;}
```

a. long add(int x, int y) { return x+y;}

b. long add(long a, long b) { return a+b;}

c. int add(byte a, byte b) { return a+b;}

d. int add(long a, int b) { return (int)(a+b);}

```bash
b. long add(long a, long b) { return a+b;}

c. int add(byte a, byte b) { return a+b;}

d. int add(long a, int b) { return (int)(a+b);}
```

**[6-14] 다음 중 초기화에 대한 설명으로 옳지 않은 것은?**

a. 멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참조할 수 있다.

b. 지역변수는 사용하기 전에 반드시 초기화해야 한다.

c. 초기화 블럭보다 생성자가 먼저 수행된다.

d. 명시적 초기화를 제일 우선적으로 고려해야 한다.

e. 클래스변수보다 인스턴스변수가 먼저 초기화된다.

```bash
c. 초기화 블럭이 먼저 수행된 후 생성자가 수행된다.

e. 클래스변수는 클래스가 메모리에 로딩될 때 자동 초기화되므로 인스턴스변수보다 먼저 초기화된다.
```

**[6-15] 다음 중 인스턴스 변수의 초기화 순서가 올바른 것은?**

a. 기본값-명시적초기화-초기화블럭-생성자

b. 기본값-명시적초기화-생성자-초기화블럭

c. 기본값-초기화블럭-명시적초기화-생성자

d. 기본값-초기화블럭-생성자-명시적초기화

```bash
c. 기본값-초기화블럭-명시적초기화-생성자
```

[1]. 클래스변수의 초기화시점 : 클래스가 처음 로딩될 때 한 번 초기화된다.

[2]. 인스턴스변수의 초기화시점 : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.

[3]. 클래스변수의 초기화 순서 : 기본값 → 명시적초기화 → 클래스초기화블럭

[4]. 인스턴스변수의 초기화 순서 : 기본값 → 명시적초기화 → 인스턴스초기화블럭 → 생성자

**[6-16] 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? (모두 고르시오)**

a. 자동 초기화되므로 별도의 초기화가 필요없다

b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다

c. 매서드의 매개변수로 선언된 변수도 지역변수이다

d. 클래스변수나 인스턴스변수보다 메모리 부담이 적다

e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.

```bash
a. 지역변수는 자동 초기화 되지 않기 때문에 사용하기 전에 반드시 적절한 값으로 초기화를 해야 한다.

e. 힙 영역에는 인스턴스가 생성되는 영역이며, 지역변수는 호출스택에 생성된다. (클래스변수는 메서드 영역)
```

**[6-17] 호출스택이 다음과 같은 상황일 때 옳지 않은 설명은? (모두 고르시오)**

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/4e27f1cf-e061-4f83-996e-987eb522a6e5)

a. 제일 먼저 호출스택에 저장된 것은 메서드이다.

b. println메서드를 제외한 나머지 메서드들은 모두 종료된 상태이다.

c. method2메서드를 호출한 것은 main메서드이다.

d. println메서드가 종료되면 메서드가 수행을 재개한다.

e. main-method2-method1-println의 순서로 호출되었다.

f. 현재 실행중인 메서드는 println뿐이다.

```bash
b. println 메서드를 제외한 나머지 메서드들은 종료된 것이 아니라 대기 상태로 들어간다.
```

**[6-18] 다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명하시오.**

```java
package Exercise6;

class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    static int cv2 = iv;

    static void staticMethod1() {
        System.out.println(cv);
        System.out.println(iv);
    }

    void instanceMethod1() {
        System.out.println(cv);
        System.out.println(iv);
    }

    static void staticMethod2() {
        staticMethod1();
        instanceMethod1();
    }

    void instanceMethod2() {
        staticMethod1();
        instanceMethod1();
    }
}
```

```java
static int cv2 = iv;
// 클래스변수의 초기화에 인스턴스 변수를 사용할 수 없다.

System.out.println(iv);
// 클래스메서드 내부에서 인스턴스 변수를 사용할 수 없다.

instanceMethod1();
// 클래스메서드에서 인스턴스 메서드를 호출할 수 없다.
```

**[6-19] 다음 코드의 실행 결과를 예측하여 적으시오.**

```java
package Exercise6;

class Exercise6_19 {
    public static void change(String str) {
        str += "456";
    }

    public static void main(String[] args) {
        String str = "ABC123";
        System.out.println(str);
        change(str);
        System.out.println("After:"+str);
    }
}
```

실행결과

```bash
ABC123
After:ABC123
```

[1]. `String str = "ABC123";`

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/c364ad94-f129-4474-b87f-82af69c2bc42)

[2]. `change(str);`

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/4c99f728-f90b-48a4-92e3-7edb3a3d34a0)

[3]. `public static void change(String str) { str += "456"; }`

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/391b3d77-d76c-4c24-b8ca-89b2971768f9)

[4]. `System.out.println("After:"+str);`

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/32009382-e07e-4f48-8433-13f77041013d)

이 때, 메서드를 통해 만들어진 `ABC123456`은 참조하는 변수가 하나도 없으므로 적절한 시기에 가비지컬렉터에 의해 제거된다.

**[6-20] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

```bash
1. 메서드명 : shuffle
   기능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
   반환타입 : int[]
   매개변수 : int[] arr - 정수값이 담긴 배열
```

```java
package Exercise6;

import java.util.Arrays;

class Exercise6_20 {
    static int[] shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(Arrays.toString(result));
    }
}
```

- 값을 교환하는 메커니즘은 자주 이용되므로 기억하는 것이 좋다.

**[6-21] Tv클래스를 주어진 로직대로 완성하시오. 완성된 후에 실행해서 주어진 실행결과와 일치하는지 확인하라.**

```java
package Exercise6;

public class Exercise6_21 {
    public static void main(String[] args) {
        MyTv t = new MyTv();

        t.channel = 100;
        t.volume = 0;
        System.out.println("CH:"+t.channel+", VOL:"+t.volume);

        t.channelDown();
        t.volumeDown();
        System.out.println("CH:"+t.channel+", VOL:"+t.volume);

        t.volume = 100;
        t.channelUp();
        t.volumeUp();
        System.out.println("CH:"+t.channel+", VOL:"+t.volume);
    }
}

class MyTv {
    boolean isPowerOn;
    int channel;
    int volume;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    void turnOnOff() {
        isPowerOn = !isPowerOn;
    }

    void volumeUp() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    void volumeDown() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

    void channelUp() {
        if (channel == MAX_CHANNEL) {
            channel = MIN_CHANNEL;
        } else {
            channel++;
        }
    }

    void channelDown() {
        if (channel == MIN_CHANNEL) {
            channel = MAX_CHANNEL;
        } else {
            channel--;
        }
    }
}
```

**[6-22] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

```bash
1. 메서드명 : isNumber
   기능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
         모두 숫자로만 이루어져 있으면 true를 반환하고, 그렇지 않으면 false를 반환한다.
         만일 주어진 문자열이 null이거나 빈문자열 ""이라면 false를 반환한다.
   반환타입 : boolean
   매개변수 : String str - 검사할 문자열
```

```java
package Exercise6;

public class Exercise6_22 {
    static boolean isNumber(String str) {
        char[] array = str.toCharArray();
        boolean result = true;
        if (str == null || str.equals(" ")) {
            result = false;
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            if ('0' <= array[i] && array[i] <= '9') {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));

        str = "1234o";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));
    }
}
```

**[6-23] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

```bash
1. 메서드명 : max
   기능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
          만일 주어진 배열이 null이거나 크기가 0인 경우, -99999를 반환한다.
   반환타입 : int
   매개변수 : int[] arr - 최대값을 구할 배열
```

```java
package Exercise6;

import java.util.Arrays;

class Exercise6_23 {
    static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -99999;
        }

        int MAX = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > MAX) {
                MAX = arr[i];
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("최대값:"+max(data));
        System.out.println("최대값:"+max(null));
        System.out.println("최대값:"+max(new int[]{}));
    }
}
```

**[6-24] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

```bash
1. 메서드명 : abs
   기능 : 주어진 값의 절대값을 반환한다.
   반환타입 : int
   매개변수 : int value
```

```java
package Exercise6;

class Exercise6_24 {
    static int abs(int value) {
        if (value < 0) {
            value = value * (-1);
        }
        return value;
    }

    public static void main(String[] args) {
        int value = 5;
        System.out.println(value+"의 절대값:"+abs(value));

        value = -10;
        System.out.println(value+"의 절대값:"+abs(value));
    }
}
```























