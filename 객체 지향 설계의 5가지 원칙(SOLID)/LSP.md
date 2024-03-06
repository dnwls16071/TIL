# 리스코프 치환 원칙(LSP, Liskov Substitution Principle)

- LSP원칙은 **서브 타입은 언제나 부모 타입으로 교체할 수 있어야 한다**는 원칙이다.

- 쉽게 말하자면, LSP는 다형성의 특징을 이용하기 위해 상위 클래스 타입으로 객체를 선언하여 하위 클래스의 인스턴스를 받으면 업캐스팅된 상태에서 부모의 메서드를 사용해도 동작이 의도대로 흘러가야 한다는 것을 의미한다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/a41b4531-7509-43bf-9ae9-47242771d29d)

# LSP원칙을 잘 적용한 예제 - Java Collection Framework

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/ddf37b75-e1b1-43a5-bdb6-a1ffef4a8510)

```java
void myData() {
	// Collection 인터페이스 타입으로 변수 선언
    Collection data = new LinkedList();
    data = new HashSet(); // 중간에 전혀 다른 자료형 클래스를 할당해도 호환됨
    
    modify(data); // 메소드 실행
}

void modify(Collection data){
    list.add(1); // 인터페이스 구현 구조가 잘 잡혀있기 때문에 add 메소드 동작이 각기 자료형에 맞게 보장됨
    // ...
}
```

# LSP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (1) 

```java
class Animal {
    int speed = 100;

    int go(int distance) {
        return speed * distance;
    }
}

class Eagle extends Animal {
    String go(int distance, boolean flying) {
        if (flying)
            return distance + "만큼 날아서 갔습니다.";
        else
            return distance + "만큼 걸어서 갔습니다.";
    }
}

public class Main {
    public static void main(String[] args) {
        Animal eagle = new Eagle();
        eagle.go(10, true);
    }
}
```

- Animal 부모 클래스의 메서드에 go 메서드가 있는데 이를 Eagle 자식 클래스에서 메서드 오버라이딩을 시도하고 있다. 하지만 위의 코드를 실행하면 정상적으로 실행이 되지 않고 에러가 발생한다.

- 상속 관계에서 자식 클래스는 부모 클래스의 대체 가능성을 유지해야한다. 즉, 자식 클래스는 부모 클래스의 기능을 변경하거나 확장하지만 기존의 동작을 변경해선 안 된다.

- 이 코드에서 메서드의 반환 타입을 변경함으로써 LSP 원칙을 위반한 것으로 이를 해결하려면 자식 클래스의 메서드 반환타입 역시 int형으로 바꿔줘야 한다.
