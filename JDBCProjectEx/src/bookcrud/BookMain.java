package bookcrud;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		IBookDAO dao = new BookDAO();
        Scanner sc = new Scanner(System.in);
        String selMenu;
        
        while (true) {
            System.out.println("**********************");
            System.out.println("도서 관리 프로그램");
            System.out.println("**********************");
            System.out.println("다음 메뉴에서 선택");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 정보 조회");
            System.out.println("3. 도서 정보 수정");
            System.out.println("4. 도서 정보 삭제");
            System.out.println("5. 종료");
            System.out.print("메뉴 번호 입력 : ");
            
            selMenu = sc.nextLine();
            
            switch (selMenu) {
                case "1":
                    System.out.println("***********************");
                    System.out.println("도서 정보 등록");
                    System.out.println("***********************");
                    BookDTO newBook = ReadWrite.getBookInfo(sc, null);
                    if (newBook != null) {
                        dao.insertBook(newBook);
                    }
                    break;
                    
                case "2":
                	System.out.println("검색 조건을 선택하세요.");
                    System.out.println("1. 전체 조회  2. 도서명 검색  3. 저자 검색  4. 출판사 검색");
                    System.out.print("선택 : ");
                    int searchType = 1;
                    
                    try {
                        searchType = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. 전체 조회를 진행합니다.");
                        searchType = 1;
                    }

                    String keyword = "";
                    if (searchType == 2) {
                        System.out.print("검색할 도서명 입력 : ");
                        keyword = sc.nextLine();
                    } else if (searchType == 3) {
                        System.out.print("검색할 저자명 입력 : ");
                        keyword = sc.nextLine();
                    } else if (searchType == 4) {
                        System.out.print("검색할 출판사명 입력 : ");
                        keyword = sc.nextLine();
                    }

                    ArrayList<BookDTO> searchList = dao.searchBooks(searchType, keyword);
                    ReadWrite.printBookList(searchList);
                    break;
                    
                case "3":
                	ArrayList<BookDTO> allBooksForUpdate = dao.searchBooks(1, "");
                    ReadWrite.printBookList(allBooksForUpdate);
                    System.out.print("수정할 도서번호 입력 : ");
                    String updateNo = sc.nextLine();
                    
                    BookDTO updateBook = ReadWrite.getBookInfo(sc, updateNo);
                    if (updateBook != null) {
                        dao.updateBook(updateBook);
                    }
                    break;
                    
                case "4":
                    System.out.print("삭제할 도서번호 입력 : ");
                    String deleteNo = sc.nextLine();
                    dao.deleteBook(deleteNo);
                    break;
                    
                case "5":
                    System.out.println("종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("잘못된 입력입니다. 1~5 사이의 번호를 입력해주세요.");
            }
        }

	}

}
