**[7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다. 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오.
단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고, 숫자가 1, 3, 8의 경우에는 두 쌍 중 한 장에는 광(Kwang)이어야 한다.
즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.**

```java
package Exercise7;

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
            cards[i] = new SutdaCard(num, isKwang);
        }
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i]+",");
        }
    }
}
```

**[7-2] 문제 7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하시오.**

```bash
1. 메서드명 : shuffle
   기능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
   반환타입 : 없음
   매개변수 : 없음

2. 메서드명 : pick
   기능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
   반환타입 : SutdaCard
   매개변수 : int index - 위치

3. 메서드명 : pick
   기능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
   반환타입 : SutdaCard
   매개변수 : 없음
```

```java
package Exercise7;

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
            cards[i] = new SutdaCard(num, isKwang);
        }
    }

    void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int ran = (int) (Math.random() * cards.length);
            SutdaCard sutdaCard = cards[i];
            cards[i] = cards[ran];
            cards[ran] = sutdaCard;
        }
    }

    SutdaCard pick(int index) {
        return cards[index];
    }

    SutdaCard pick() {
        int ran = (int) (Math.random() * cards.length);
        return cards[ran];
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_2 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i]+",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}
```

**[7-3] 오버라이딩의 정의와 필요성에 대해 설명하시오.**

- 오버라이딩이란 조상 클래스로부터 상속받은 메서드를 자손 클래스에 맞게 재정의 하는 것을 말한다.

- 조상 클래스로부터 상속받은 메서드를 자손 클래스에서 그대로 사용할 수 없는 경우가 많기 때문에 오버라이딩이 필요하다.

**[7-4] 다음 중 오버라이딩의 조건으로 옳지 않은 것은? (모두 고르시오)**

a. 조상의 메서드와 이름이 같아야 한다.

b. 매개변수의 수와 타입이 모두 같아야 한다.

~~c. 접근 제어자는 조상의 메서드보다 좁은 범위로만 변경할 수 있다.~~

~~d. 조상의 메서드보다 더 많은 수의 예외를 선언할 수 있다.~~

```bash
자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와

  - 이름이 같아야 한다.
  - 매개변수가 같아야 한다.
  - 리턴타입이 같아야 한다.

조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때

  - 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
  - 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
  - 인스턴스 메서드를 static 메서드로 또는 그 반대로 변경할 수 없다.
```

[7-5] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가?

```java
package Exercise7;

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}

class Tv extends Product {
    Tv() {

    }

    public String toString() {
        return "Tv";
    }
}

public class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}
```

```java
package Exercise7;

class Product {
    int price;
    int bonusPoint;
    
    Product() {
        
    }

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}

class Tv extends Product {
    Tv() {
        
    }

    public String toString() {
        return "Tv";
    }
}

public class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}
```

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/babca0ac-9dfd-417b-b0b1-6be156633f9d)

- Product클래스에서 기본 생성자가 없기 때문에 에러가 발생한다.

- Tv클래스가 Product킄래스를 상속받아 인스턴스를 생성할 때 조상 클래스에 존재하는 것들 역시 Tv클래스 객체 생성 시 같이 포함된다.

- super()는 조상 클래스인 Product클래스의 기본 생성자를 호출하는데 Product클래스에서 기본 생성자가 정의되지 않았는데 이를 Tv클래스 기본 생성자가 호출하려니 에러가 발생하는 것이다.

**[7-6] 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유는 무엇인가?**

- 위의 문제(7-5)와 비슷한 문제이다.

- 조상에 정의된 인스턴스 변수들이 초기화되도록 하려면 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야 한다.

- 자손 클래스의 인스턴스를 생성하면 조상으로부터 상속받은 인스턴스변수들도 생성되는데, 이 상속받은 인스턴스변수들 역시 적절히 초기화되어야 한다.

- 상속받은 조상의 인스턴스변수들을 자손의 생성자에서 직접 초기화하기보다는 조상의 생성자를 호출함으로써 초기화되도록 하는 것이 바람직하다.

- **각 클래스의 생성자는 해당 클래스에 선언된 인스턴스변수의 초기화만을 담당하고, 조상 클래스로부터 상속받은 인스턴스변수의 초기화는 조상 클래스의 생성자가 처리하도록 해야 한다.**

**[7-7★] 다음 코드를 실행했을 때 호출되는 생성자의 순서와 실행 결과를 적으시오.**

```java
package Exercise7;

class Parent {
    int x = 100;

    Parent() {
        this(200);
    }

    Parent(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }
}

class Child extends Parent {
    int x = 3000;

    Child() {
        this(1000);
    }

    Child(int x) {
        this.x = x;
    }
}

public class Exercise7_7 {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println("x="+c.getX());
    }
}
```

- ★컴파일러는 생성자의 첫 줄에 다른 생성자를 호출하지 않으면 조상의 기본 생성자를 호출하는 `super();`를 넣는다.

```java
Child(int x) {
  this.x = x;
}
```

- 따라서 위의 코드는 아래와 같다고 볼 수 있다.

```java
Child(int x) {
  super();  // Child의 부모 클래스는 Parent클래스(Parent()를 호출)
  this.x = x;
}
```

```java
Parent(int x) {
  super();
  this.x = x;
}
```

- 마찬가지로, Parent(int x) 역시 컴파일러가 Parent의 조상인 Object클래스의 기본 생성자를 호출하는 `super();`를 넣는다.

- Child() → Child(int x) → Parent() → Parent(int x) → Object()의 순서로 호출된다.

- Child클래스의 인스턴스변수 x는 1000, Parent클래스의 인스턴스변수 x는 200(엄연히 따지면 100이지만 생성자에 의해서 200으로 초기화)이 된다.

- getX()는 조상인 Parent클래스에 의해서 정의된 것이라서 getX()에서 x는 Parent클래스의 인스턴스변수 x를 말하는 것이므로 200이 답이 된다.

**[7-8] 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은?**

a. public-protected-(default)-private

b. public-(default)-protected-private

c. (default)-public-protected-private

d. private-protected-(default)-public

```bash
1. private - 같은 클래스 내에서만 접근이 가능하다.
2. default - 같은 패키지 내에서만 접근이 가능하다.
3. protected - 같은 패지키 내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다.(상속 포함)
4. public - 접근 제한이 없다.
```

**[7-9] 다음 중 제어자 final을 붙일 수 있는 대상과 붙였을 때 그 의미를 적은 것이다. 옳지 않은 것은? (모두 고르시오)**

a. 지역변수 - 값을 변경할 수 없다.

b. 클래스 - 상속을 통해 클래스에 새로운 멤버를 추가할 수 없다.

~~c. 메서드 - 오버로딩을 할 수 없다.~~

d. 멤버변수 - 값을 변경할 수 없다.

```bash
메서드 - 오버라이딩을 할 수 없다.
```

**[7-10] MyTv2클래스의 멤버변수 isPowerOn, channel, volume 클래스 외부에서 접근할 수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter/setter 메서드를 추가하라.**

```java
package Exercise7;

class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

public class Exercise7_10 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setVolume(20);
        System.out.println("VOL:"+t.getVolume());
    }
}
```

**[7-11] 문제 7-10에서 작성한 MyTv클래스에서 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.**

```bash
1. 메서드명 : gotoPrevChannel
   기능 : 현재 채널을 이전 채널로 변경한다.
   반환타입 : 없음
   매개변수 : 없음
```

```java
package Exercise7;

class MyTv {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prevChannel;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    public void setChannel(int channel) {
        prevChannel = this.channel;
        this.channel = channel;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void gotoPrevChannel() {
        setChannel(prevChannel);
    }
}


public class Exercise7_11 {
    public static void main(String[] args) {
        MyTv t = new MyTv();

        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}
```

**[7-12] 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? (모두 고르시오)**

a. public은 접근 제한이 전혀 없는 접근 제어자이다.

b. (default)가 붙으면, 같은 패키지 내에서만 접근이 가능하다.

~~c. 지역변수에도 접근 제어자를 사용할 수 있다.~~

d. protected가 붙으면, 같은 패키지 내에서도 접근이 가능하다.

e. protected가 붙으면, 다른 패키지의 자손 클래스에서도 접근이 가능하다.

```bash
접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자
```

**[7-13] Math클래스의 생성자는 접근 제어자가 private이다. 그 이유는 무엇인가?**

- 외부로부터의 접근을 막기 위해서

**[7-14] 문제 7-1에 나오는 섯다카드의 숫자와 종류(iskwang)는 사실 한 번 값이 지정되면 변경되어서는 안 되는 값이다. 카드의 숫자가 한 번 잘못 바뀌면
똑같은 카드가 두 장이 될 수도 있기 때문이다. 이러한 문제점이 발생하지 않도록 아래의 SutdaCard를 수정하시오.**

```java
// 기존 코드
package Exercise7;

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_14 {
    public static void main(String[] args) {
        SutdaCard sutdaCard = new SutdaCard(1, true);

        System.out.println("SutdaCard:"+sutdaCard.toString());

        sutdaCard.num = 2;
        sutdaCard.isKwang = false;
        System.out.println("SutdaCard:"+sutdaCard.toString());
    }
}
```

- 위의 main을 보면 SutdaCard 타입의 인스턴스 멤버변수를 변경할 수 있게 되는데 이렇게 되면 문제에서와 같이 똑같은 카드가 두 장이 될 수도 있다.

- 값이 변경되지 못하도록 하려면 아래와 같이 final키워드를 붙여야 한다. (생성자에서 초기화 가능함, 단 변경 불가함)

```java
// 수정된 코드
package Exercise7;

class SutdaCard {
    final int num;
    final boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_14 {
    public static void main(String[] args) {
        SutdaCard sutdaCard = new SutdaCard(1, true);

        System.out.println("SutdaCard:"+sutdaCard.toString());

        // 값 변경 불가함
        // sutdaCard.num = 2;
        // sutdaCard.isKwang = false;
        // System.out.println("SutdaCard:"+sutdaCard.toString());
    }
}
```

**[7-15] 클래스가 다음과 같이 정의되어 있을 때, 형변환을 올바르게 하지 않은 것은? (모두 고르시오)**

```java
class Unit {}
class AirUnit extends Unit {}
class GroundUnit extends Unit {}
class Tank extends GroundUnit {}
class AirCraft extends AirUnit {}

Unit u = new GroundUnit();
Tank t = new Tank();
AirCraft ac = new AirCraft();
```

```java
package Exercise7;

class Unit {
    public String toString() {
        return "UnitClass";
    }
}

class AirUnit extends Unit {
    @Override
    public String toString() {
        return "AirUnitClass";
    }
}

class GroundUnit extends Unit {
    @Override
    public String toString() {
        return "GroundUnitClass";
    }
}

class Tank extends Unit {
    @Override
    public String toString() {
        return "TankClass";
    }
}

class AirCraft extends AirUnit {
    @Override
    public String toString() {
        return "AirCraftClass";
    }
}

public class Exercise7_15 {
    public static void main(String[] args) {
        Unit u = new GroundUnit();
        Tank t = new Tank();
        AirCraft ac = new AirCraft();
    }
}
```

a. u = (Unit)ac;

b. u = ac;

c. GroundUnit gu = (GroundUnit) u;

d. AirUnit au = ac;

~~e. t = (Tank)u;~~

f. GroundUnit gu = t;

- 조상 타입의 인스턴스를 자손 타입으로 형변환 할 수 없다.

- **조상 타입의 참조변수로 자손 타입의 인스턴스를 참조하는 것이 가능하다.**

**[7-16] 다음 중 연산결과가 true가 아닌 것은? (모두 고르시오)**

```java
class Car {}
class FireEngine extends Car implements Movable {}
class Ambulance extends Car {}

FireEngine fe = new FireEngine();
```

a. fe instanceof FireEngine

b. fe instanceof Movable

c. fe instanceof Object

d. fe instanceof Car

~~e. fe instanceof Ambulance~~

```bash
instanceof 연산자는 실제 인스턴스의 모든 조상이나 구현한 인터페이스에 대해 true를 반환한다.

어떤 타입에 대해 instanceof 연산결과가 true라면 그 타입으로 형변환이 가능하다는 것을 말한다.
```

**[7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아내서 Unit이라는 클래스를 만들고, 이 클래스를 상속받도록 코드를 변경하시오.**

```java
class Marine { // 보병
  int x, y; // 현재 위치
  void move(int x, int y) { /* */ } 지정된 위치로 이동
  void stop() { /* */ } 현재 위치에 정지
  void stimPack() { /* .*/} 스팀팩을 사용한다
}

class Tank { // 탱크
  int x, y; // 현재 위치
  void move(int x, int y) { /* */ } 지정된 위치로 이동
  void stop() { /* */ } 현재 위치에 정지
  void changeMode() { /* . */} 공격모드를 변환한다
}

class Dropship { // 수송선
  int x, y; // 현재 위치
  void move(int x, int y) { /* */ } 지정된 위치로 이동
  void stop() { /* */ } 현재 위치에 정지
  void load() { /* .*/ } 선택된 대상을 태운다
  void unload() { /* .*/ } 선택된 대상을 내린다
}
```

```java
package Exercise7;

abstract class Unit {
    int x, y;
    void move(int x, int y) {
        // 지정된 위치로 이동해라
    }

    void stop() {
        // 현재 위치에 정지해라
    }
}

class Marine extends Unit {
    void stimPack() {
        // 스팀팩을 사용해라
    }
}

class Tank extends Unit {
    void changeMode() {
        // 공격모드를 변환해라
    }
}

class Dropship extends Unit {
    void load() {
        // 선택된 대상을 태워라
    }

    void unload() {
        // 선택된 대상을 내려라
    }
}
```

**[7-18] 다음과 같은 실행결과를 얻도록 코드를 완성하시오.**

```bash
1. 메서드명 : action
   기능 : 주어진 객체의 메서드를 호출하라.
         DanceRobot - dance()
         SingRobot - sing()
         DrawRobot - draw()
   반환타입 : 없음
   매개변수 : Robot robot - Robot 인스턴스 또는 Robot의 자손 인스턴스
```

```java
package Exercise7;

class Robot {

}

class DanceRobot extends Robot {
    void dance() {
        System.out.println("춤추는 로봇");
    }
}

class SingRobot extends Robot {
    void sing() {
        System.out.println("노래하는 로봇");
    }
}

class DrawRobot extends Robot {
    void draw() {
        System.out.println("그림 그리는 로봇");
    }
}


public class Exercise7_18 {
    public static void action(Robot robot) {
        if (robot instanceof DrawRobot) {
            DrawRobot dr = (DrawRobot) robot;
            dr.draw();
        } else if (robot instanceof SingRobot) {
            SingRobot sr = (SingRobot) robot;
            sr.sing();
        } else if (robot instanceof DanceRobot) {
            DanceRobot dr = (DanceRobot) robot;
            dr.dance();
        }
    }

    public static void main(String[] args) {
        Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};

        for (int i = 0; i < arr.length; i++) {
            action(arr[i]);
        }
    }
}
```

- **조상 타입의 참조변수로 하위 타입의 인스턴스를 참조하는 것은 가능하다. 하지만, 조상 타입의 인스턴스를 하위 타입으로 형변환 할 수 없다.**

**[7-19] 다음은 물건을 구입하는 사람을 정의하는 Buyer클래스이다. 이 클래스는 멤버변수로 돈(money)과 장바구니(cart)를 가지고 있다. 제품을 구입하는 기능의 buy메서드와
장바구니에 구입한 물건을 추가하는 add메서드, 구입한 물건의 목록과 사용금액, 그리고 남은 금액을 출력하는 summary 메서드를 정의하시오.**

```bash
1. 메서드명 : buy
   기능 : 지정된 물건을 구입한다. 가진 돈(money)에서 물건의 가격을 빼고, 장바구니(cart)에 담는다.
          만일 가진 돈이 물건의 가격보다 적다면 바로 종료된다.
   반환타입 : 없음
   매개변수 : Product p - 구입할 물건

2. 메서드명 : add
   기능 : 지정된 물건을 장바구니에 담는다.
          만일 장바구니에 담을 공간이 없다면, 장바구니의 크기를 2배로 늘린 다음에 담는다.
   반환타입 : 없음
   매개변수 : Product p - 구입할 물건

3. 메서드명 : summary
   기능 : 구입한 물건의 목록과 사용금액, 남은 금액을 출력한다.
   반환타입 : 없음
   매개변수 : 없음
```

에러 메시지
```bash
Exception in thread "main" java.lang.NullPointerException: Cannot read field "price" because "this.cart[i]" is null
```

- 한 가지를 고려하지 않아 코드가 정확한 결과를 출력하지 못했는데 그것은 바로 장바구니의 크기였다.

- 장바구니의 인덱스가 3인 순간에 장바구니의 크기를 2배 늘려서 해당 인덱스의 물건도 금액 여력이 된다면 넣어야 하는데 넣질 않아서 계속 Audio가 추가되지 않는 문제가 발생했다.

- 조건문을 쓸 때도 else 블록 안에 넣어야 되는 것인지 아닌지를 정확하게 파악한 후 써야겠다.

```java
package Exercise7;

public class Exercise7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.summary();
    }
}


class Buyer {
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0;

    void buy(Product p) {
        // 1.1 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다.
        if (money < p.price) {
            System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다.");
            return;
        }
        // 1.2 가진 돈이 충분하면, 제품의 가격을 가진 돈에서 빼고
        // 1.3 장바구니에 구입한 물건을 담는다.(add 메서드 호출)
        money -= p.price;
        add(p);
    }

    void add(Product p) {
        // 1.1 i의 값이 장바구니의 크기보다 같거나 크면
        // 1.1.1 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다.
        // 1.1.2 기존의 장바구니의 내용을 새로운 배열에 복사한다.
        // 1.1.3 새로운 장바구니와 기존의 장바구니를 바꾼다.
        if (i >= cart.length) {
            Product[] newCart = new Product[cart.length * 2];
            System.arraycopy(cart, 0, newCart, 0, cart.length);
            cart = newCart;
        }
        // 1.2 물건을 장바구니(cart)에 저장한다. 그리고 i의 값을 1증가시킨다.
        cart[i++] = p;
    }

    void summary() {
        int totalPrice = 0;
        String itemList = "";
        // 1.1 장바구니에 담긴 물건들의 목록을 출력한다.
        // 1.2 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다.
        for (int i = 0; i < cart.length; i++) {
            itemList += cart[i] + ",";
            totalPrice += cart[i].price;
        }

        System.out.println("구입한 물건:"+itemList);
        System.out.println("사용한 금액:"+totalPrice);
        System.out.println("남은 금액:"+money);
    }
}

class Product {
    int price;

    Product(int price) {
        this.price = price;
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}
```

**[7-20] 다음의 코드를 실행한 결과를 적으시오.**

```java
package Exercise7;

public class Exercise7_20 {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x="+p.x);
        p.method();

        System.out.println("c.x="+c.x);
        c.method();
    }
}

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    int x = 200;
    void method() {
        System.out.println("Child Method");
    }
}
```

- 조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스변수를 자손 클래스에서 중복 정의했을 때, 어떤 것이 출력되는가?

- 메서드의 경우 조상 클래스의 메서드를 자손 클래스에서 오버라이딩한 경우에도 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드)가 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라진다.

- 타입은 다르지만 참조변수 p,c 모두 Child 인스턴스를 참조하고 있다.

  - Parent타입의 참조변수로 Child인스턴스를 생성한 경우 이 때 출력되는 멤버변수는 조상 클래스의 멤버변수가 된다.
 
  - Child타입의 참조변수로 Child인스턴스를 생성한 경우 이 때 출력되는 멤버변수는 자손 클래스의 멤버변수가 된다.

**[7-21] 다음과 같이 attack 메서드가 정의되어 있을 때, 이 메서드의 매개변수로 가능한 것 두 가지를 적으시오.**

```java
interface Movable {
void move(int x, int y);
}

void attack(Movable f) {
/* */ 내용 생략
}
```

- [정답] : null, Movable 인터페이스를 구현한 구현체 클래스 또는 그 자손의 인스턴스

**[7-22] 아래는 도형을 정의한 Shape클래스이다. 이 클래스를 조상으로 하는 Circle클래스와 Rectangle클래스를 작성하시오. 이 때, 생성자도 각 클래스에 맞게 적절히 추가해야한다.**

```bash
1. 클래스명 : Circle
   조상클래스 : Shape
   멤버변수 : double r - 반지름

2. 클래스명 : Rectangle
   조상클래스 : Shape
   멤버변수 : double witdh - 폭
             double height - 높이
   메서드명 : isSquare
            기능 : 정사각형인지 아닌지를 알려준다.
            반환타입 : boolean
            매개변수 : 없음
```

```java
package Exercise7;

class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this(new Point(0, 0), r);
    }

    Circle(Point p, double r) {
        super(p);
        this.r = r;
    }

    @Override
    double calcArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this(new Point(0, 0), width, height);
    }

    Rectangle(Point p, double width, double height) {
        super(p);
        this.width = width;
        this.height = height;
    }

    @Override
    double calcArea() {
        return width * height;
    }

    boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }
}

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double calcArea();

    Point getPosition() {
        return p;
    }

    void setPosition(Point p) {
        this.p = p;
    }
}

public class Exercise7_22 {
    public static void main(String[] args) {

    }
}
```

**[7-23] 문제 7-22에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트하시오.**

```bash
1. 메서드명 : sumArea
   기능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
   반환타입 : double
   매개변수 : Shape[] arr
```

```java
package Exercise7;

class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this(new Point(0, 0), r);
    }

    Circle(Point p, double r) {
        super(p);
        this.r = r;
    }

    @Override
    double calcArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this(new Point(0, 0), width, height);
    }

    Rectangle(Point p, double width, double height) {
        super(p);
        this.width = width;
        this.height = height;
    }

    @Override
    double calcArea() {
        return width * height;
    }

    boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }
}

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double calcArea();

    Point getPosition() {
        return p;
    }

    void setPosition(Point p) {
        this.p = p;
    }
}

public class Exercise7_22 {
    public static void main(String[] args) {
        Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
        System.out.println("면적의 합="+sumArea(arr));
    }

    static double sumArea(Shape[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].calcArea();
        }
        return sum;
    }
}
```

**[7-24] 다음 중 인터페이스의 장점이 아닌 것은?**

a. 표준화를 가능하게 해준다. → 개발시간을 단축시킨다.

b. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.

c. 독립적인 프로그래밍이 가능하다.

d. 다중상속을 가능하게 해준다.

~~e. 패키지간의 연결을 도와준다.~~

**[7-25★★] Outer클래스의 내부 클래스 inner의 멤버변수 iv의 값을 출력하시오.**

```java
package Exercise7;

class Outer {
    class Inner {
        int iv = 100;
    }
}

public class Exercise7_25 {
    public static void main(String[] args) {
        // 내부 클래스 인스턴스 생성을 위해 외부 클래스 인스턴스 생성
        Outer o = new Outer();
        // 외부 클래스 인스턴스 객체를 통해 내부 클래스 멤버변수 값 출력
        Outer.Inner ii = o.new Inner();
        System.out.println(ii.iv);
    }
}
```

- 내부 클래스의 인스턴스를 생성하기 위해선 **먼저 외부 클래스의 인스턴스를 생성해야 한다.**

- 그 다음 내부 클래스 타입의 참조변수로 외부 클래스 객체에서 new 키워드로 내부 클래스 타입의 인스턴스를 생성한다.

**[7-26] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.**

```java
package Exercise7;

class Outer1 {
    static class Inner1 {
        int iv = 200;
    }
}

public class Exercise7_26 {
    public static void main(String[] args) {
        // 외부 클래스 인스턴스를 생성하지않고도 내부 클래스 멤버변수 값 출력 가능
        Outer1.Inner1 ii = new Outer1.Inner1();
        System.out.println(ii.iv);
    }
}
```

- **static 클래스는 인스턴스 클래스와 달리 외부 클래스의 인스턴스를 생성하지 않고도 사용할 수 있다.**

**[7-27] 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.**

```java
package Exercise7;

class Outer2 {
    int value = 10;
    class Inner2 {
        int value = 20;
        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer2.this.value);
        }
    }
}

public class Exercise7_27 {
    public static void main(String[] args) {
        Outer2 o = new Outer2();
        Outer2.Inner2 ii = o.new Inner2();

        ii.method1();
    }
}
```

- 외부 클래스와 내부 클래스에 같은 이름의 인스턴스변수(value)가 선언되었을 때 어떻게 구별하는가에 대한 문제이다.

- 외부 클래스의 인스턴스 변수는 내부 클래스에서 `외부클래스.this.변수이름`으로 접근할 수 있다.

- 내부 클래스의 값은 `this.변수이름`으로 접근할 수 있다.

- 내부 클래스 내의 메서드 지역변수는 블록 범위 내에 있기 때문에 그대로 `변수이름`으로만으로도 접근할 수 있다.
