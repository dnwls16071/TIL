// 다음 StackInterface는 문자열을 푸시하고 팝할 수 있는 스택에 대한 스펙을 정의하고 있다.
// StackInterface를 상속받는 StringStack 클래스를 구현하라.
// 그리고 StackManager클래스에 main()메서드를 작성하여 StringStack 객체를 생성하고 사용자로부터 문자열을 5개 읽어 스택 객체를 저장하고, 다시 팝하여 읽은 반대순으로 출력하라.

package practice1;

public interface StackInterface {
    int length();   // 스택에 들어 있는 문자열 개수 리턴
    String pop();   // 스택의 톱에 들어 있는 문자열 팝
    boolean push(String ob);    // 스택의 톱에 문자열 ob 푸시 삽입
}

package practice1;

public class StringStack implements StackInterface{
    String[] stack = new String[5];
    private int cnt = 0;

    @Override
    public int length() {
        return cnt+1;
    }

    @Override
    public String pop() {
        return stack[--cnt];
    }

    @Override
    public boolean push(String ob) {
        if (cnt == 5) {
            return false;
        } else {
            stack[cnt] = ob;
            cnt++;
            return true;
        }
    }
}


package practice1;

import java.util.Scanner;

public class StackManager {
    public static void main(String[] args) {
        StringStack stack = new StringStack();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            stack.push(scanner.nextLine());
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop()+" ");
        }
    }
}
