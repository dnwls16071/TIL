# 의존 역전 원칙(DIP, Dependency Inversion Principle)

- ❗DIP원칙은 어떤 클래스를 참조해서 사용해야하는 상황이 생긴다면 그 **구현체 클래스를 직접 참조하는 것이 아니라 그 대상의 상위 요소(추상 클래스 or 인터페이스)를 참조하라는 원칙**이다.

- 다시 말하면 하위 모듈을 직접 인스턴스로 가져다 쓰지 말라는 것이다. 하위 모듈의 구체적인 내용에 클라이언트가 의존하게 되어 하위 모듈에 변화가 있을 때마다 클라이언트나 상위 모듈의 코드를 자주 수정해야 되기 때문이다.

- ❗한 마디로 **상위의 인터페이스 타입의 객체로 통신**하라는 것이다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/671309ca-c103-4a09-b666-091cf4671604)

### ❗Tip

- **클래스 간 의존 관계**란, **한 클래스가 어떤 기능을 수행하려고 할 때, 다른 클래스의 서비스가 필요한 경우**를 말한다.

- 대표적으로 A클래스의 메소드에서 매개변수를 다른 B클래스의 타입으로 받아 B객체의 메서드를 사용할 때, A클래스는 B클래스에 의존한다고 말할 수 있는 것이다.

```java
// 인터페이스
interface Toy {}

class Robot implements Toy {}
class Lego implements Toy {}
class Doll implements Toy {}

// 클라이언트
class Kid {
	Toy toy; // 합성
    
    void setToY(Toy toy) {
    	this.toy = toy;
    }
    
    void play() {}
}

// 메인 메소드
public class Main {
	public static void main(String[] args) {
        Kid boy = Kid();
        
        // 1. 아이가 로봇을 가지고 놀 때
        Toy toy = new Robot();
        boy.setToy(toy);
        boy.play();
        
        // ...
        
        // 2. 아이가 레고를 가지고 놀 때
        Toy toy = new Lego();
        boy.setToy(toy);
        boy.play();
    }
}
```

- 장난감의 종류가 로봇, 레고, 인형 등등 다양한데 하나의 하위 모듈에 의존하면 그에 따라 상위 모듈과 클라이언트 부분에서 코드를 수정해야 할 가능성이 높아지기 때문에 이를 방지하기 위해 로봇, 레고, 인형 등의 상위 모듈인 장난감에 의존하라는 것이다.

# DRP 원칙 위반 예제와 직접 코드 수정 방향 짚어보기 (1)

```java
class Character {
    final String NAME;
    int health;
    OneHandSword weapon; // 의존 저수준 객체

    Character(String name, int health, OneHandSword weapon) {
        this.NAME = name;
        this.health = health;
        this.weapon = weapon;
    }

    int attack() {
        return weapon.attack(); // 의존 객체에서 메서드를 실행
    }

    void changeWeapon(OneHandSword weapon) {
        this.weapon = weapon;
    }

    void getInfo() {
        System.out.println("이름: " + NAME);
        System.out.println("체력: " + health);
        System.out.println("무기: " + weapon);
    }
}
```
```java
class OneHandSword {
    final String NAME;
    final int DAMAGE;

    OneHandSword(String name, int damage) {
        NAME = name;
        DAMAGE = damage;
    }

    int attack() {
        return DAMAGE;
    }
}

class TwoHandSword {
    // ...
}

class BatteAxe {
    // ...
}

class WarHammer {
    // ...
}
```

- 한 손 무기 클래스, 두 손 무기 클래스... 등등 여러 하위 모듈이 있는데 Character 클래스에 이 하위 모듈로 의존하게 된다면 그에 따른 상위 모듈과 클라이언트 부분의 코드를 수정할 수 밖에 없다. 따라서 무기를 아우르는 인터페이스를 만들고 이를 의존하게 하면 된다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/a2682a19-15ba-4302-a103-e1a97b156882)

```java
// 고수준 모듈
interface Weaponable {
    int attack();
}

class OneHandSword implements Weaponable {
    final String NAME;
    final int DAMAGE;

    OneHandSword(String name, int damage) {
        NAME = name;
        DAMAGE = damage;
    }

    public int attack() {
        return DAMAGE;
    }
}

class TwoHandSword implements Weaponable {
	// ...
}


class BatteAxe implements Weaponable {
	// ...
}

class WarHammer implements Weaponable {
	// ...
}
```

- 위와 같이 Weaponable이라는 인터페이스를 만들고 하위 모듈이 이를 구현하는 구현체 클래스로 만들면 DIP원칙을 따름으로써 무기의 변경 시마다 코드를 바꿀 필요없이 다른 타입의 무기로 갈아 끼우면 된다.


