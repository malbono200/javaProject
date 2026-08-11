package bookcrud;

import java.util.ArrayList;

public interface IBookDAO {
	public void insertBook(BookDTO dto);
	
    public ArrayList<BookDTO> searchBooks(int searchType, String keyword);
    
    public void updateBook(BookDTO dto);
    
    public void deleteBook(String bookNo);
}
