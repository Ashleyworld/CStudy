package org.example.test3;

public class Book {


    String BookName;
    int Books;
    int BookPrice;


    public Book(String bookName, int books, int bookPrice) {
        this.BookName = bookName;
        this.Books = books;
        this.BookPrice = bookPrice;
    }

    public Book() {
        this.BookName = "자바 프로그래밍 입문";
        this.Books = 1;
        this.BookPrice = 10000;
    }

    public void renewal() {
        this.Books = this.Books + 1;
        this.BookPrice = this.BookPrice + 5000;
        System.out.println(this.BookName + "가 재판매 되었습니다. " + this.BookPrice + "원 이고, " + this.Books + "권이예요.");

    }

    public static void main(String[] args) {
        Book a = new Book();
        a.renewal();

        Book b; //객체
        b = new Book("짧고 굵게 배우는 자바 프로그래밍", 1, 5000);
        b.renewal();
    }
}

