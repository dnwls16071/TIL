// 메서드 오버라이딩과 추상 클래스를 이용하여 다음 실행 결과처럼 동작하는 프로그램을 만들어라.

package practice1;

import java.util.Scanner;

abstract class Shape {
    abstract void draw();
}

public class Editor extends Shape{
    static int i = 0;
    private String[] shape = new String[10];
    Scanner scanner = new Scanner(System.in);
    public void insert() {
        System.out.print("도형 종류 Line(1), Rect(2), Circle(3)>>");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                shape[i++] = "Line";
                break;
            case 2:
                shape[i++] = "Rect";
                break;
            case 3:
                shape[i++] = "Circle";
                break;
            default:
                System.out.println("잘못된 위치입니다.");
        }
    }

    public void remove() {
        System.out.print("삭제할 도형의 위치>>");
        Scanner scanner = new Scanner(System.in);
        int location = scanner.nextInt();
        if (location <= i) {
            shape[location--] = null;
        } else {
            System.out.println("삭제할 수 없습니다.");
        }
    }

    @Override
    public void draw() {
        for (int k = 0; k < i; k++) {
            System.out.println(shape[k]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = new Editor();
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    editor.insert();
                    break;
                case 2:
                    editor.remove();
                    break;
                case 3:
                    editor.draw();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다...");
                    System.exit(0);
            }
        }
    }
}
