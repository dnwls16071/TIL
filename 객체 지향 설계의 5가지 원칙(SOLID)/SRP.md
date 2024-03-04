# 단일 책임 원칙(SRP, Single Responsibility Principle)

- 단일 책임 원칙은 **클래스(객체)는 단 하나의 책임만 가져야 한다**는 원칙

- 여기서 **책임**이란 하나의 **기능 담당**이라고 보면 된다.

- 만일 하나의 클래스에 기능(책임)이 여러개 있다면 기능 변경(수정)이 일어났을때 수정해야할 코드가 많아진다.
  예를 들어, A를 고쳤더니 B를 수정해야하고 또 C를 수정해야하고, C를 수정했더니 다시 A로 돌아가서 수정해야 하는, 마치 책임이 순환되는 형태가 되어버린다.
  따라서 SRP 원칙을 따름으로써 한 책임의 변경으로부터 다른 책임의 변경으로의 연쇄작용을 극복할 수 있게 된다.

- 최종적으로 단일 책임 원칙의 목적은 프로그램의 유지보수성을 높이기 위한 설계 기법이다.

- 이 때, 책임의 범위는 딱 정해져있는 것이 아니고 어떤 프로그램을 개발하느냐에 따라 개발자마다 생각 기준이 달라질 수 있다. 따라서 단일 책임 원칙에 대한 해답은 없다.

### ❗Tip

예를 들어 청소기 클래스는 청소 메서드만 잘 구현하면 되는 것이지 화분에 물을 주고 드라이까지 할 책임은 없다. 다재다능한 청소기가 좋겠지만 만일 청소기가 고장나면 다른 기능까지도 사용을 못하기 때문이다. 즉, 청소기는 청소만 잘하면 된다는 책임만 가지면 된다.
쉽게 말해 하나의 클래스로 너무 많은 일을 하지 말고 딱 한 가지 책임만 수행하라는 뜻으로 이해하면 된다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/7202417e-f0bf-4a23-ac33-abac23196f32)

```java
class Employee {
    String name;
    String positon;

    Employee(String name, String position) {
        this.name = name;
        this.positon = position;
    }

    // 초과 근무 시간을 계산하는 메서드 (두 팀에서 공유하여 사용)
    void calculateExtraHour() {
        // ...
    }

    // 급여를 계산하는 메서드 (회계팀에서 사용)
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // 근무시간을 계산하는 메서드 (인사팀에서 사용)
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // 변경된 정보를 DB에 저장하는 메서드 (기술팀에서 사용)
    void saveDababase() {
        // ...
    }
}
```

- 그런데 회계팀에서 급여를 계산하는 메서드인 `calculatePay()` 방식을 새로 변경하여 코드에서 초과 근무 시간을 계산하는 메서드 `calculateExtraHour()`의 알고리즘 업데이트가 필요해졌다.

- 그래서 개발팀에서 회계팀의 요청에 따라 `calculateExtraHour()`메서드를 변경했는데 변경에 의한 파급 효과로 인해 수정 내용이 의도치 않게 `reportHours()`에도 영향을 미쳐 코드를 바꿔야하는 문제가 발생한다. 이렇게 하나의 수정 사항이 다른 곳에 영향을 미쳐 수정을 수반하게 된다면 그것은 좋은 코드라고 할 수 없다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/e98bb72d-f6f8-4f95-a54d-832024d00195)

```java
// * 통합 사용 클래스
class EmployeeFacade {
    private String name;
    private String positon;

    EmployeeFacade(String name, String position) {
        this.name = name;
        this.positon = position;
    }
    
    // * 급여를 계산하는 메서드 (회계팀 클래스를 사용)
    void calculatePay() {
        // ...
        new PayCalculator().calculatePay();
        // ...
    }

    // * 근무시간을 계산하는 메서드 (인사팀 클래스를 사용)
    void reportHours() {
        // ...
        new HourReporter().reportHours();
        // ...
    }

    // * 변경된 정보를 DB에 저장하는 메서드 (기술팀 클래스를 사용)
    void EmployeeSaver() {
        new EmployeeSaver().saveDatabase();
    }
}

// * 회계팀에서 사용되는 전용 클래스
class PayCalculator {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 인사팀에서 사용되는 전용 클래스
class HourReporter {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 기술팀에서 사용되는 전용 클래스
class EmployeeSaver {
    void saveDatabase() {
        // ...
    }
}
```

- 각 책임(기능 담당)에 맞게 클래스를 분리하여 구성한다.

- 회계팀, 인사팀, 기술팀의 기능 담당은 PayCaculator, HourReporter, EmployeeSaver으로 각기 다른 클래스로 분리하고 이를 통합적으로 사용하는 EmployeeFacade 클래스를 만든다.

- EmployeeFacade 클래스의 메서드에는 사실상 아무런 로직이 없게 된다. 생성자로 인스턴스를 생성 및 초기화하고 각 클래스의 메서드를 사용하면 된다.

- 어떤 클래스를 보고 단일 책임 원칙을 지켰는지 단번에 판단하는 것은 쉽지 않다. 중요한 것은 클래스를 작성할 때 단일 책임 원칙을 지켰는지 끊임없이 고민해보는 것이다. 하나의 클래스가 너무 많은 책임을 가지진 않았는지, 분리할 수 있는 변수와 메서드가 많은 것이 아닌지를 고민해봐야 한다.


