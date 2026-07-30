package exam.book_interface;

public interface IBookDAO {
	public void insertBook(BookDTO book);
	public void updateBook(BookDTO book);
	public void deleteBook(String id);
	public BookDTO selectBook(String id);
	public void selectAllBooks();
}
