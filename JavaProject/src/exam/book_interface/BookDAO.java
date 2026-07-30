package exam.book_interface;

public class BookDAO implements IBookDAO{

	@Override
	public void insertBook(BookDTO book) {
		System.out.println("[DB] 도서 정보가 등록되었습니다. (등록 도서명: " + book.title + ")");
		
	}

	@Override
	public void updateBook(BookDTO book) {
		System.out.println("[DB] 도서 정보가 수정되었습니다. (수정 도서명: " + book.title + ")");
		
	}

	@Override
	public void deleteBook(String id) {
		System.out.println("[DB] 도서 정보가 삭제되었습니다. (삭제 ID: " + id + ")");
		
	}

	@Override
	public BookDTO selectBook(String id) {
		System.out.println("[DB] 도서 정보를 조회합니다. (조회 ID: " + id + ")");
        return new BookDTO(id, "임시 도서명", "임시 저자", 15000);
	}

	@Override
	public void selectAllBooks() {
		System.out.println("[DB] 등록된 전체 도서 목록을 조회합니다.");
		
	}
	
}
