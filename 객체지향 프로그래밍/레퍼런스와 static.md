# ❗레퍼런스 변수

- 레퍼런스(reference)는 우리말로 '참조'라는 뜻이다. 레퍼런스 변수는 객체를 가리킨다.

![gefY972](https://github.com/dnwls16071/TIL/assets/106802375/99d91858-7f71-46f4-a2c9-d5aa3d7265be)

- 엄밀히 말하면 **객체의 주소**를 가지고 있다.

# ❗기본형 변수와의 차이

- 기본형 변수는 값을 직접 저장하지만 참조형(레퍼런스) 변수는 객체를 간접적으로 저장한다.

![11oKvAf](https://github.com/dnwls16071/TIL/assets/106802375/4a2c3ccb-84b6-4406-9b62-06150a184c09)

- 위와 같이 참조 변수에 객체의 주소를 저장하고 필드에 접근해 데이터를 저장하는 것이다.

- 객체는 하나의 변수에 담기엔 너무 크다. 뿐만 아니라 그 크기가 유동적이다. 때문에 자바는 객체 접근을 위해 어드레싱(addressing) 방식 즉, 주소지를 통한 접근 방식을 취한다.

# ❗static 키워드

- static은 "공유"라는 개념을 담은 키워드이다. static은 클래스의 필드와 메서드에 적용될 수 있다. static 필드는 클래스 변수, static 메서드는 클래스 메서드라고 부른다.

![5PUlfws](https://github.com/dnwls16071/TIL/assets/106802375/b698559f-e009-4d68-9341-05d5f280fafe)

- **클래스 변수는 클래스 영역에 존재**한다. **객체 내부에 존재하는 것이 아니라 객체 외부에 존재**한다.

![nRPLmri](https://github.com/dnwls16071/TIL/assets/106802375/bf02b92b-8ffa-4286-a254-85bee791a074)

- 위와 반대로 non-static 필드는 인스턴스 변수라고 한다. **인스턴스 변수는 객체 내부에 존재**한다.

![IEOWjCp](https://github.com/dnwls16071/TIL/assets/106802375/efdfcd78-697a-4051-b1d1-b174e6097fb3)

- 클래스 메서드는 객체의 생성없이 실행된다. 반면 인스턴스 메서드는 메서드 실행 시점에 생성된 객체가 존재해야만 한다.

![VzzYQlZ](https://github.com/dnwls16071/TIL/assets/106802375/5e471120-cb37-4fc5-826a-cf69da0e43bb)




  
