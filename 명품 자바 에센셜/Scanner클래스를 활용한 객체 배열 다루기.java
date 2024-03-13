package practice;

import java.util.Scanner;

class Book {
    String title;
    String author;

    // public의 유무 : 외부 패키지에서 사용할 수 있는지 아닌지의 차이
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookArray {
    public static void main(String[] args) {
        Book[] books = new Book[2];

        // Scanner 클래스로 객체 생성
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < books.length; i++) {
            System.out.print("제목>>");
            String title = scanner.nextLine();
            System.out.print("저자>>");
            String author = scanner.nextLine();
            books[i] = new Book(title, author);
        }

        for (int i = 0; i < books.length; i++) {
            System.out.printf("(%s, %s)\n", books[i].title, books[i].author);
        }
    }
}
