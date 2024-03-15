# Scanner

- 명품 자바 에센셜 문제를 풀면서 사용자로부터의 입력을 받는 문제가 많았고 이 때 Scanner 클래스가 빈번하게 사용되었다.

- Java API문서를 찾아보다가 Method Detail 부분에 `close()`가 있는 것을 발견했는데 이 메서드는 Scnner 객체를 닫는 역할을 수행한다.

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/24560733-4f51-4f54-8283-3b9aa79aa95d)

- 입력을 사용할 때 사용자가 키보드를 통해 입력을 하는 경우도 있지만 파일 등을 통해서 입력을 받는 경우도 존재한다.

- 파일 작업의 순서는 사용하고자 하는 파일을 열고, 이를 사용, 마지막으로 닫기 순서이다.

- 이 때, 파일을 열고 닫지 않는다면 파일이 손상될 수가 있기 때문에 기본적으로 파일 작업은 파일 열기/닫기를 꼭 해주어야 한다.

- Scanner 객체 생성시에 파라미터로 `System.in`을 넘기는데 이 때, `in`이 키보드 입력을 가리킨다.

- 키보드 입력의 경우 `close()`를 사용하지 않아도 상관이 없지만 리소스를 사용하는 경우(파일 등)에는 안전을 위해 `close()`를 사용하는 것을 권장한다.

---

# next() vs nextLine()

```java
package practice3;

import java.util.Scanner;

public class nextLineEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                scanner.close();
                break;
            } else {
                System.out.println(str);
            }
        }
    }
}
```

실행 결과
```bash
견우와 직녀
```

```java
package practice3;

import java.util.Scanner;

public class nextEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.next();
            if (str.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                scanner.close();
                break;
            } else {
                System.out.println(str);
            }
        }
    }
}
```

실행 결과
```bash
견우와
직녀
```

- next()와 nextLine()의 차이점은 개행문자(\n)를 무시하느냐 무시하지 않느냐의 차이다.

- next()의 경우 공백을 기준으로 한 단어 또는 한 문자씩을 입력받는다.

- nextLine()의 경우 문자 또는 엔터를 치기 전까지의 문장 전체를 입력받는다.
