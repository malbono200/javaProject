package bookcrud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
	public static BookDTO getBookInfo(Scanner sc, String updateBookNo) {
        BookDTO dto = null;
        try {
            String bookNo = updateBookNo;
            if (bookNo == null) {
                System.out.print("도서번호 입력 : ");
                bookNo = sc.nextLine();
            } else {
                System.out.println("수정할 도서번호 : " + bookNo);
            }
            
            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();
            
            System.out.print("저자 입력 : ");
            String bookAuthor = sc.nextLine();
            
            System.out.print("가격 입력 : ");
            int bookPrice = Integer.parseInt(sc.nextLine());
            
            System.out.print("발행일 입력(yyyy-MM-dd) : ");
            String dateStr = sc.nextLine();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = fm.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            System.out.print("재고 입력 : ");
            int bookStock = Integer.parseInt(sc.nextLine());
            
            System.out.print("출판사 번호 입력 : ");
            String pubNo = sc.nextLine();
            
            dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, sqlDate, bookStock, pubNo);
            
        } catch (Exception e) {
            System.out.println("입력 오류가 발생했습니다. 형식에 맞게 다시 입력해주세요.");
        }
        return dto;
    }

    public static void printBookList(ArrayList<BookDTO> list) {
        System.out.println("***********************");
        System.out.println("도서 정보 조회");
        System.out.println("***********************");
        System.out.format("%-10s %-20s %-10s %-10s %-15s %-5s %-10s\n", 
                "도서번호", "도서명", "저자", "가격", "발행일", "재고", "출판사번호");
        
        for (BookDTO dto : list) {
            System.out.format("%-10s %-20s %-10s %-10d %-15s %-5d %-10s\n", 
                    dto.getBookNo(), dto.getBookName(), dto.getBookAuthor(), 
                    dto.getBookPrice(), dto.getBookDate().toString(), 
                    dto.getBookStock(), dto.getPubNo());
        }
    }
}
