package laba3;

public class book {
    String N;
    String C;
    String A;
    boolean S;

    book(String a, String n, String c, boolean s) {
        this.N = n;
        this.A = a;
        this.C = c;
        this.S = s;
    }

    void info() {
        System.out.println("Название книги: " + this.N);
        System.out.println("Автором книги является: " + this.A);
        System.out.println("Цвет книги: " + this.C);
        if (this.S) {
            System.out.println("Обложка книги мягкая");
        } else {
            System.out.println("Обложка книги жесткая");
        }

    }
}