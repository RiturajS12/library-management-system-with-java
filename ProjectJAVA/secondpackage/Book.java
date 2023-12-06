package secondpackage;

public class Book {
    private String author;
    private String bookName;
    private String bookCode;

    public Book(String author, String bookName, String bookCode) {
        this.author = author;
        this.bookName = bookName;
        this.bookCode = bookCode;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookCode() {
        return bookCode;
    }
}
