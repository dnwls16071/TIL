**[2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.**

| 종류\크기 | 1byte | 2byte | 4byte | 8byte |
|-----|-----|-----|-----|-----|
| 논리형 | boolean | - | - | - |
| 문자형 | - | char | - | - |
| 정수형 | byte | short | int | long |
| 실수형 | - | - | float | double |

**[2-2] 주민등록번호를 숫자로 저장하고자 한다. 이 값을 저장하기 위해서는 어떤 자료형(data type)을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로 초기화 하는 한 줄의 코드를 적으시오.**

```java
long regNo = 1231234567890;
```

- 정수형 타입의 경우 약 ±20억까지가 범위이기 때문에 int형의 범위를 넘어서는 값을 저장할 수 없다. 따라서 long형으로 선언해야 한다.

**[2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.**

```java
int i = 100;
long l = 100L;
final float PI - 3.14;
```

- 리터럴 : 100, 100L, 3.14
- 변수 : i, l
- 키워드 : final, int, long, float
- 상수 : PI

**[2-4] 다음 중 기본형(primitive type)이 아닌 것은?**

b. Byte 

- 기본형 타입 : boolean, byte, short, char, int, long, float, double 모두 8개이다.
- 참조형 타입 : 위에 열거된 기본형 타입 외에 나머지

**[2-5] 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우 오류라고 적으시오.**

```java
System.out.println(“1” + “2”);    // 12
System.out.println(true + “”);    // true
System.out.println(‘A' + 'B');    // 131
System.out.println('1' + 2);      // 51 
System.out.println('1' + '2');    // 99
System.out.println('J' + “ava”);  // Java
System.out.println(true + null);  // 오류
```

- 문자와 문자의 덧셈연산의 결과는 int형 정수값이 된다. 왜냐하면 int형보다 작은 타입은 int형으로 변환된 후에 덧셈연산이 진행되기 때문이다.

- 'A' + 'B'의 경우 char + char → int + int → int형의 과정을 통해 최종 결과는 int형 정수값이 된다.

```bash
문자열 + (any type) = 문자열 + 문자열 = 문자열
(any type) + 문자열 = 문자열 + 문자열 = 문자열
```

**[2-6] 다음 중 키워드가 아닌 것은?(모두 고르시오.)**

b. True(true)

c. NULL(null)

d. Class(class)

e. System(system)

- Java에서는 대소문자를 구별하기 때문에 true는 키워드이지만 True는 키워드가 아니다.

**[2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은?**

a. $ystem

b. channel#5

e. 자바

g. $MAX_NUM

- 대소문자가 구분되며 길이에 제한이 없다.

- 예약어를 사용해선 안 된다.

- 숫자로 시작해선 안 된다.

- 특수문자는 '_'와 '$'만을 허용한다.

**[2-8] 참조형 변수(referce type)와 같은 크기의 기본형(primitive type)은?**

- 모든 참조형 변수는 4byte이다. 참조형 변수와 같은 크기의 기본형은 다음과 같다.

a. int

d. float

**[2-9] 다음 중 형변환을 생략할 수 있는 것은?**

```java
byte b = 10;
char ch = 'A';
int i = 100;
long l = 100L;
```

d. float f = (float) l;

e. i = (int) ch;

### ❗자동 형변환

- 자동 타입 변환은 묵시적/암시적 형변환이라고도 불리우며, 프로그램 실행 도중에 컴파일러가 자동적으로 타입 변환이 일어나는 것을 말한다.

- 단, 작은 크기를 가진 타입이 큰 크기를 가진 타입에 저장될 때에만 자동 타입 변환이 발생한다.

- 자바에서는 데이터의 손실이 발생하지 않거나 데이터의 손실이 최소화되도록 자동 타입을 진행한다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/fc2b8c73-9c29-450e-aa1b-93c497248c82)

- 위에서 작은 크기를 가진 타입이 큰 크기를 가진 타입으로 자동 형변환이 이루어진다고 나와 있는데 long은 8byte이고 float은 4byte인데 자동 형변환이 되는 것을 볼 수 있다.

- 일반적으로 메모리 설계상 정수 타입보다 실수 타입이 더 크게 되어 있기 때문이다.

![img1 daumcdn](https://github.com/dnwls16071/TIL/assets/106802375/d72fa18f-c67b-4ed3-823d-41ec4248af98)

**[2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)**

- 1byte = 8bit로 char타입은 2byte로 16bit이다. 1bit는 0과 1, 두 가지로 표현된다.

- 따라서, 16bit라면 2의 16승이 된다.

**[2-11] 다음중 변수를 잘못 초기화 한 것은? (모두 고르시오)**

a. byte b = 256;

b. char c = '';

c. char answer = 'no';

d. float f = 3.14;

- byte의 경우 8bit이므로 -128 ~ 127 사이의 값을 표현할 수 있으므로 이를 넘어선 256으로 초기화 할 수 없다.

- char의 경우 빈 문자로 초기화 할 수 없고 문자 하나만 넣어서 초기화 할 수 있다.

- float의 경우 뒤에 f를 붙여야 한다.

**[2-12] 다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오)**

a. public static void main(String[] args)

b. public static void main(String args[])

e. static public void main(String[] args)

**[2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오)**

c. float - 0.0

e. long - 0

f. String - ""

- float의 경우 기본값은 0.0f

- long의 경우 기본값은 0L

- String은 참조형 변수로 참조형 변수의 기본값은 모두 null







