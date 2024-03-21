**[11-1] 다음은 정수집합 1,2,3,4와 3,4,5,6의 교집합, 차집합, 합집합을 구하는 코드이다. 코드를 완성하여 실행결과와 같은 결과를 출력하시오.**

```java
package Exercise11;

import java.util.ArrayList;

public class Exercise11_1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();

        ArrayList kyo = new ArrayList();    // 교집합
        ArrayList chaA = new ArrayList();    // 차집합
        ArrayList chaB = new ArrayList();    // 차집합
        ArrayList hap = new ArrayList();    // 합집합

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // 교집합
        kyo.addAll(list1);
        kyo.retainAll(list2);
        System.out.println(kyo);

        // 합집합
        hap.addAll(list1);
        hap.removeAll(kyo);
        hap.addAll(list2);
        System.out.println(hap);

        // A-B 차집합
        chaA.addAll(list1);
        chaA.removeAll(kyo);
        System.out.println(chaA);

        // B-A 차집합
        chaB.addAll(list2);
        chaB.removeAll(kyo);
        System.out.println(chaB);
    }
}
```

**[11-2] 다음 코드의 실행결과를 적으시오.**

```java
package Exercise11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        HashSet set = new HashSet(list);
        TreeSet tset = new TreeSet(set);
        Stack stack = new Stack();
        stack.addAll(tset);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
```

```java
HashSet set = new HashSet(list);
```

- HashSet은 중복을 허용하지 않기 때문에 중복요소들은 저장되지 않는다. 또한 저장순서를 유지하지 않는다.

```java
TreeSet tset = new TreeSet(set);
```

- TreeSet 역시 Set인터페이스를 구현한 클래스로 중복을 허용하지 않고 중복요소들은 저장되지 않는다. 하지만 오름차순으로 정렬을 수행한다.

**[11-3★] 다음 중 ArrayList에서 제일 비용이 많이 드는 작업은? 단, 작업 도중에 ArrayList의 크기 변경이 발생하지 않는다고 가정한다.**

~~a. 첫 번째 요소 삭제~~

b. 마지막 요소 삭제

c. 마지막에 새로운 요소 추가

d. 중간에 새로운 요소 추가

- ArrayList는 배열을 기반으로 하고, 배열은 크기를 변경할 수 없기에 저장할 공간이 부족하면 새로운 배열을 만들고 내용을 복사해야하므로 비용이 많이 든다.

- 배열의 중간에 원소를 삽입하는 것과 원소를 삭제하는 것은 다른 요소들을 이동시켜야 하기 때문에 위와 같이 공간이 부족해서 배열을 새로 생성하는 것보다는 적지만 비용이 많이 든다.

- 특히 배열의 첫 번째 요소를 삭제하면 빈 자리를 채워야 하기 때문에 나머지 모든 요소들을 이동시켜야 하기 때문에 많은 비용이 든다.

- 반면에 ArrayList의 마지막 위치에 요소를 삽입하거나 삭제하는 것은 다른 요소들을 이동시킬 필요가 없기 때문에 아주 적은 비용만으로 처리가 가능하다.

 ~~**[11-4] LinkedList 클래스는 이름과 달리 실제로는 이중 원형 연결리스트로 구현되어 있다. LinkedList 인스턴스를 생성하고 11개의 요소를 추가했을 때, 이 11개의 요소 중 접근시간이 가장 오래 걸리는 요소는 몇 번째 요소인가?**~~

**[11-5] 다음에 제시된 Student 클래스가 Comparable인터페이스를 구현하도록 변경해서 이름(name)이 기본 정렬기준이 되도록 하시오.** 

```java
package Exercise11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add(new Student("홍길동", 1, 1, 100, 100, 100));
        arrayList.add(new Student("남궁성", 1, 2, 90, 70, 80));
        arrayList.add(new Student("김자바", 1, 3, 80, 80, 90));
        arrayList.add(new Student("이자바", 1, 4, 70, 90, 70));
        arrayList.add(new Student("안자바", 1, 5, 60, 100, 80));

        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() /3f) * 10 + 0.5) / 10f;
    }

    public String toString() {
        return name +","+ban +","+no +","+kor +","+eng +","+math
                +","+getTotal() +","+getAverage();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student tmp = (Student) o;
            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
}
```

**[11-6] 다음의 코드는 성적평균의 범위별로 학생 수를 세기 위한 것이다. TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와 평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라.**

```java
package Exercise11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() /3f) * 10 + 0.5) / 10f;
    }

    public String toString() {
        return name +","+ban +","+no +","+kor +","+eng +","+math
                +","+getTotal() +","+getAverage();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student tmp = (Student) o;
            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
}

public class Exercise11_6 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student tmp1 = (Student) o1;
                    Student tmp2 = (Student) o2;
                    return (int) (tmp1.getAverage() - tmp2.getAverage());
                } else {
                    return -1;
                }
            }
        });

        treeSet.add(new Student("홍길동",1,1,100,100,100));
        treeSet.add(new Student("남궁성",1,2,90,70,80));
        treeSet.add(new Student("김자바",1,3,80,80,90));
        treeSet.add(new Student("이자바",1,4,70,90,70));
        treeSet.add(new Student("안자바",1,5,60,100,80));

        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("[60-69]: " + getGroupCount(treeSet, 60, 70));
        System.out.println("[70-79]: " + getGroupCount(treeSet, 70, 80));
        System.out.println("[80-89]: " + getGroupCount(treeSet, 80, 90));
        System.out.println("[90-99]: " + getGroupCount(treeSet, 90, 101));
    }

    static int getGroupCount(TreeSet treeSet, int from, int to) {
        Student s1 = new Student("", 0, 0, from, from, from);
        Student s2 = new Student("", 0, 0, to, to, to);
        return treeSet.subSet(s1, s2).size();
    }
}
```
