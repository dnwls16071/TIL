# 인터페이스 분리 원칙(ISP, Interface Segregation Principle)

- ❗인터페이스를 각각 사용에 맞게끔 잘게 분리해야한다는 설계 원칙이다.

- ❗SRP가 클래스의 단일 책임을 강조한다면, ISP는 인터페이스의 단일 책임을 강조하는 것으로 보면 된다.

- 인터페이스는 제약 없이 자유롭게 다중 상속(구현)이 가능하기 때문에, 분리할 수 있으면 분리하여 구성해놓고 나중에 무언가 수정사항이 생겨서 또 인터페이스들을 분리하는 행위를 가하지 말아야 한다. 각 클래스 용도에 맞게 `implements`하라는 설계 원칙이라고 보면 된다.

- 관련 있는 기능끼리 하나의 인터페이스에 모으되 지나치게 커지지 않도록 크기를 제한해야한다.

# ISP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (1)

```java
interface ISmartPhone {
    void call(String number); // 통화 기능
    void message(String number, String text); // 문제 메세지 전송 기능
    void wirelessCharge(); // 무선 충전 기능
    void AR(); // 증강 현실(AR) 기능
    void biometrics(); // 생체 인식 기능
}
```

- 스마트폰에 들어가는 기능들을 묶고 이를 구현하면 아래와 같이 구현할 수 있다.

```java
class S20 implements ISmartPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
    }

    public void AR() {
    }

    public void biometrics() {
    }
}

class S21 implements ISmartPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
    }

    public void AR() {
    }

    public void biometrics() {
    }
}
```

- 하지만 여기서 한 가지 문제를 제기할 수 있다. 시대를 거듭하면서 핸드폰의 기능이 좋아지는데 이전 핸드폰에서는 지원되지 않는 기능이 있어 **필요하지도 않은 기능을 어쩔 수 없이 구현해야하는 문제가 발생한다.**

- ❗따라서 **포괄적인 개념보다는 세부적이 개념으로 접근해 각각의 기능에 맞게 인터페이스를 잘게 분리하도록 구성**한다.

- 잘게 분리된 인터페이스를 필요로 하는 클래스에서 지원되는 기능만을 `implements`하면 ISP원칙이 지켜지게 된다.

```java
interface IPhone {
    void call(String number); // 통화 기능
    void message(String number, String text); // 문제 메세지 전송 기능
}

interface WirelessChargable {
    void wirelessCharge(); // 무선 충전 기능
}

interface ARable {
    void AR(); // 증강 현실(AR) 기능
}

interface Biometricsable {
    void biometrics(); // 생체 인식 기능
}
```

- 핸드폰의 기종인 S20, S21로 인터페이스를 구성한 것이 아닌 각각의 기능에 맞춰서 생체인식기능, 증강현실기능 등 세부적인 개념에 초점을 맞춰 인터페이스를 설계했다.

# ISP원칙 적용 주의점

- SRP가 클래스의 단일 책임 원칙이라면 ISP는 인터페이스의 단일 책임 원칙이다.

- 즉, 인터페이스에 기능에 대한 책임에 맞게 추상 메서드를 구성하면 된다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/a31d7fad-da49-40a4-891f-ec67381850ea)

- 위의 게시판 UML을 보면 게시판 인터페이스에 글쓰기, 읽기, 수정, 삭제 등의 CRUD 메서드가 들어가 있다. 하지만 삭제 메서드의 경우 일반 사용자는 사용할 수 없고 관리자의 경우에만 사용할 수 있다고 가정하면 이는 ISP원칙을 준수하지 않은 것이다.
