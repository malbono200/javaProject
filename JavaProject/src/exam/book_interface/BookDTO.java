package exam.book_interface;

public class BookDTO {
	String id;
    String title;
    String author;
    int price;

    public BookDTO(String id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO [ID=" + id + ", 도서명=" + title + ", 저자=" + author + ", 가격=" + price + "]";
    }
}
