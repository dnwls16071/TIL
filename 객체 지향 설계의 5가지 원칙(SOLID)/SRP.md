# 단일 책임 원칙(SRP, Single Responsibility Principle)

- ❗단일 책임 원칙은 **클래스(객체)는 단 하나의 책임만 가져야 한다**는 원칙

- ❗여기서 **책임**이란 하나의 **기능 담당**이라고 보면 된다.

- 만일 하나의 클래스에 기능(책임)이 여러개 있다면 기능 변경(수정)이 일어났을때 수정해야할 코드가 많아진다.
  예를 들어, A를 고쳤더니 B를 수정해야하고 또 C를 수정해야하고, C를 수정했더니 다시 A로 돌아가서 수정해야 하는, 마치 책임이 순환되는 형태가 되어버린다.
  따라서 SRP 원칙을 따름으로써 한 책임의 변경으로부터 다른 책임의 변경으로의 연쇄작용을 극복할 수 있게 된다.

- ❗단일 책임 원칙 준수 유무에 따른 가장 큰 특징 기준 척도는 **기능 변경(수정)을 하였을 때 파급 효과**이다.

- 한 객체에 책임(기능 담당)이 많아질수록 클래스 내부에서 서로 다른 역할을 수행하는 코드끼리 강하게 결합될 가능성이 높아져 시스템이 복잡해진다. 그래서 그 객체가 하는 기능에 변경사항이 생기면 이 기능을 사용하는 부분의 코드를 모두 다시 테스트를 해야 할 수도 있다.

- ❗책임이 여러 가지 포함된 클래스는 한 책임의 변경에서 다른 책임의 변경으로의 연쇄 작용을 일으킨다.

### ❗Tip

예를 들어 청소기 클래스는 청소 메서드만 잘 구현하면 되는 것이지 화분에 물을 주고 드라이까지 할 책임은 없다. 다재다능한 청소기가 좋겠지만 만일 청소기가 고장나면 다른 기능까지도 사용을 못하기 때문이다. 즉, 청소기는 청소만 잘하면 된다는 책임만 가지면 된다.
쉽게 말해 하나의 클래스로 너무 많은 일을 하지 말고 딱 한 가지 책임만 수행하라는 뜻으로 이해하면 된다.

# SRP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (1)

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/7202417e-f0bf-4a23-ac33-abac23196f32)

- Employee 클래스는 위와 같이 4가지 책임을 가진다.

  - calculatePay() : 회계팀에서 급여를 계산하는 메서드

  - reportHours() : 인사팀에서 근무시간을 계산하는 메서드

  - calculateExtraHour() : 회계팀과 인사팀이 공유하여 사용하는 초과 근무시간을 계산하는 메서드

  - saveDatabase() : 정보를 DB에 저장하는 메서드

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

- 단일 책임 원칙을 적용하려면 **각 책임(기능 담당)에 맞게 클래스를 분리하여 구성**한다.

# SRP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (2)

```java
class EmployeeManagement {

    // * Create 작업을 담당하는 CRUD 메소드
    void addEmployee(String employee) {
        if(Objects.equals(employee, "")) {
            postServer(employee); // 서버에 직원 정보를 보냄
            logResult("[LOG] EMPLOYEE ADDED"); // 로그 출력
        } else {
            logResult("[ERROR] NAME MUST NOT BE EMPTY");
        }
    }

    // * 서버에 데이터를 전달하는 메소드
    void postServer(String employees) {}

    // * 로그를 출력하는 메소드
    void logResult(String message) {
        System.out.println(message); // 로그를 콘솔에 출력
        writeToFile(message); // 로그 내용을 로그 파일에 저장
    }

    // * 파일에 내용을 저장하는 메소드
    void writeToFile(String msg){}
}
```

- **데이터를 생성하고 서버에 전송하는 작업과 로그를 기록하는 작업이 서로 관련이 있지 않다.**

```java
class EmployeeManagement {
    Logger logger = new Logger(); // 합성
    
    // * Create 작업을 담당하는 CRUD 메소드
    void addEmployee(String employee) {
        if(Objects.equals(employee, "")) {
            postServer(employee); // 서버에 직원 정보를 보냄
            logger.logResult("[LOG] EMPLOYEE ADDED"); // 로그 출력
        } else {
            logger.logResult("[ERROR] NAME MUST NOT BE EMPTY");
        }
    }

    // * 서버에 데이터를 전달하는 메소드
    void postServer(String employees) {}
}

class Logger {
    // * 로그를 출력하는 메소드
    void logResult(String message) {
        System.out.println(message); // 로그를 콘솔에 출력
        writeToFile(message); // 로그 내용을 로그 파일에 저장
    }

    // * 파일에 내용을 저장하는 메소드
    void writeToFile(String msg){}
}
```
