# 개방 폐쇄 원칙(OCP, Open Closed Principle)

- 개방 폐쇄 원칙은 **클래스는 확장에 열려있어야 하며, 수정에는 닫혀있어야 한다**는 뜻한다.

- 기능 추가 요청이 오면 클래스는 확장을 통해 손쉽게 구현하면서 확장에 따른 클래스 수정은 최소화하도록 프로그램을 작성해야 하는 설계 기법이다.

  - **[확장에 열려있다]** → 새로운 변경 사항이 발생했을 때 유연하게 코드를 추가함으로써 큰 힘을 들이지 않고 애플리케이션의 기능을 확장
 
  - **[변경에 닫혀있다]** → 새로운 변경 사항이 발생했을 때 **객체를 직접적으로 수정을 제한**함
 
- **OCP원칙은 추상화와 직결**된다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/c13e2070-c689-4110-b2b9-8421b2903120)

- 즉, OCP는 다형성과 확장을 가능케 하는 객체지향의 장점을 극대화하는 설계 원칙으로 객체를 추상화함으로써 확장엔 열려있고 변경엔 닫혀있는 구조를 만들어 사용해오며 객체 지향 프로그래밍의 OCP원칙의 효과를 이용해왔던 것이다.

# OCP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (1)

```java
class Animal {
	String type;
    
    Animal(String type) {
    	this.type = type;
    }
}

// 동물 타입을 받아 각 동물에 맞춰 울음소리를 내게 하는 클래스 모듈
class HelloAnimal {
    void hello(Animal animal) {
        if(animal.type.equals("Cat")) {
            System.out.println("냐옹");
        } else if(animal.type.equals("Dog")) {
            System.out.println("멍멍");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HelloAnimal hello = new HelloAnimal();
        
        Animal cat = new Animal("Cat");
        Animal dog = new Animal("Dog");

        hello.hello(cat); // 냐옹
        hello.hello(dog); // 멍멍
    }
}
```

- 다른 동물들이 추가되면 각 객체의 필드 변수에 맞게 if문을 계속 추가하면서 구성해야 한다.

- 위와 같이 코드를 구성하면 동물이 추가될때마다 계속 코드를 일일이 변경해줘야 하는 작업이 생기게 된다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/0d7edbd3-1bce-4b7c-aaba-a9fa08d380e2)

```java
package codefactory;

abstract class Animal1 {
    abstract void speak();
}

class Cat1 extends Animal1 {

    @Override
    void speak() {
        System.out.println("야옹");
    }
}

class Dog1 extends Animal1 {

    @Override
    void speak() {
        System.out.println("멍멍");
    }
}

class Pig1 extends Animal1 {

    @Override
    void speak() {
        System.out.println("꿀꿀");
    }
}

class HelloAnimal {
    void hello(Animal1 animal1) {
        animal1.speak();
    }
}

public class Main1 {
    public static void main(String[] args) {
        HelloAnimal helloAnimal = new HelloAnimal();

        Animal1 animal1 = new Cat1();
        Animal1 animal2 = new Dog1();

        helloAnimal.hello(animal1);
        helloAnimal.hello(animal2);
    }
}
```

- **특정 구현체 클래스의 타입에 의존하면 코드의 유지보수가 어려우므로 인터페이스나 추상 클래스를 매개변수로 넣으면 객체를 넣어 사용하기 쉬워진다.**

# OCP 원칙을 따른 JDBC

- OCP원칙을 가장 잘 따르는 예시는 바로 자바의 데이터베이스 인터페이스인 JDBC이다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/60fb0e5b-8510-4518-9b03-6f61ec47045a)

- 만일 자바 애플리케이션에서 사용하고 있는 데이터베이스를 MySQL에서 Oracle로 바꾸고 싶다면, 복잡한 하드코딩없이 connection 객체 부분만 교체해주면 된다.

- 즉, 자바 애플리케이션(클라이언트 부분)은 데이터베이스라고 하는 주변의 변화에 닫혀 있는 것이다. 데이터베이스를 손쉽게 교체할 수 있다는 것은 데이터베이스가 자신의 확장에는 열려 있다는 말이 된다.
