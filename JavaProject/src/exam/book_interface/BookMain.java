package exam.book_interface;

public class BookMain {

	public static void main(String[] args) {
		IBookDAO dao = new BookDAO();
        BookDTO book1 = new BookDTO("B001", "자바", "홍길동", 20000);
        
        System.out.println("=== 도서 관리 시스템 테스트 ===");
        
        dao.insertBook(book1);
        dao.selectAllBooks();
        
        BookDTO searchedBook = dao.selectBook("B001");
        System.out.println("조회 결과: " + searchedBook.toString());
        
        book1.price = 30000;
        dao.updateBook(book1);
        dao.deleteBook("B001");

	}

}
