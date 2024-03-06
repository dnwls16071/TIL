# ❓인터페이스 정의

- 인터페이스를 작성하는 것은 추상 클래스를 작성하는 것과 같다고 보면 된다. (추상 메서드 집합)

- 인터페이스도 필드를 선언할 수 있지만 변수가 아닌 상수(final)로서만 정의할 수 있다.

- 제어자는 생략이 가능하다.

```java
interface 인터페이스이름{
    public static final 타입 상수이름 = 값;
    public abstract 타입 메서드이름(매개변수목록);
}

// --------------------------------------------------------

interface TV {
    int MAX_VOLUME = 10; // public static final 생략 가능
    int MIN_VOLUME = 10;

    void turnOn(); // public abstract 생략 가능
    void turnOff();
    void changeVolume(int volume);
    void changeChannel(int channel);
}
```

# ❓인터페이스 구현

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/88bc75de-6a6a-45ee-9f97-f0575147f566)

- 인터페이스도 추상 클래스처럼 그 자체로는 인스턴스를 생성할 수 없으며, 추상 클래스가 상속을 통해 완성되는 것처럼 인터페이스도 구현부를 만들어주는 클래스에 구현(상속)되어야 한다.

- 해당 클래스에 인터페이스를 구현하고 싶다면 `implements`키워드를 쓴 후에 인터페이스를 나열하면 된다.

- 인터페이스를 상속 받았으면, 자식 클래스에서 인터페이스가 포함하고 있는 추상 메서드를 구체적으로 구현해준다.

- 인터페이스의 가장 큰 특징은 여러 개를 다중 구현(다중 상속)이 가능하다는 것이다.

- 자식 클래스에 클래스 상속(`extend`)과 인터페이스 구현(`implements`)을 동시에 할 수 있다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/65ef73ab-b621-4b1a-aadf-2d8c2ac67967)

```java
interface Animal { 
	public abstract void cry(); 
}

interface Pet { 
	public abstract void play(); 
}

class Tail {
	// ...
}

class Cat extends Tail implements Animal, Pet { // 클래스와 인터페이스를 동시에 상속

    public void cry() {
        System.out.println("냐옹냐옹!");
    }

    public void play() {
        System.out.println("쥐 잡기 놀이하자~!");
    }
}
```

### ❗Tip

- 인터페이스도 따지고 보면 상속이지만 `extends`키워드 대신에 `implements`라는 키워드를 사용하는 이유는 상속은 클래스 간의 부모-자식 관계를 연관시키는데 중점을 두고 구현은 클래스를 확장시켜 다양히 이용하는데 중점이 되기 때문이다.

- 인터페이스를 구현받고 추상 메서드를 자체적으로 구현할 때 접근 제어자 설정에 주의해야 한다.

- 기본적으로 메서드를 오버라이딩할 때는 부모의 메서드보다 넓은 범위의 접근 제어자를 지정해야 한다는 규칙이 존재한다.

- 따라서 인터페이스의 추상 메서드는 기본적으로 `public abstract`가 생략된 상태이기 때문에 반드시 자식 클래스의 메서드 구현부에서는 제어자를 `public`으로 설정해주어야 한다.

# ❓인터페이스 일부 구현(추상 클래스)

- 인터페이스의 메서드를 구현체 클래스에서 모두 등록하지 않으면 인터페이스의 추상 메서드는 당연히 필요가 없게 된다.

- 만일 클래스가 구현하는 인터페이스의 메서드 중 일부만 구현한다면 `abstract`를 붙여서 추상 클래스로 선언해야 한다.

- 어찌 보면 당연한게 인터페이스의 추상 메서드를 그대로 상속받기 때문에 인터페이스를 구현한 클래스엥서 메서드 구현을 안하면 곧 추상 메서드를 가진 추상 클래스가 된다.

```java
interface Animal {
    void walk();
    void run();
    void breed();
}

// Animal 인터페이스를 일부만 구현하는 포유류 추상 클래스
abstract class Mammalia implements Animal {
    public void walk() { ... }
    public void run() { ... }
    // public void breed() 는 자식 클래스에서 구체적으로 구현하도록 일부로 구현하지 않음 (추상 메서드로 처리)
}

class Lion extends Mammalia {
    @Override
    public void breed() { ... }
}
```

# ❓인터페이스 자체 상속

- 클래스 간 상속의 경우 `extends`키워드를 사용, 킄래스 - 인터페이스 간 구현의 경우 `implements`키워드를 사용한다.

- 인터페이스 간 상속의 경우 `extends`키워드를 사용한다.
















