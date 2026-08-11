package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements IBookDAO {
	private Connection con = null;

    public BookDAO() {
        con = DBConn.getConnection();
    }

	@Override
	public void insertBook(BookDTO dto) {
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // 1. 도서번호 중복 검사
            String checkSql = "SELECT BOOKNO FROM BOOK WHERE BOOKNO = ?";
            pstmt = con.prepareStatement(checkSql);
            pstmt.setString(1, dto.getBookNo());
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("오류 : 이미 존재하는 도서번호입니다.");
                return; // 중복인 경우 메서드 즉시 종료
            }
            
            // 검사에 사용한 자원 반환
            DBConn.close(pstmt, rs);
            pstmt = null;
            rs = null;

            // 2. 도서 등록 진행
            String insertSql = "INSERT INTO BOOK VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertSql);
            pstmt.setString(1, dto.getBookNo());
            pstmt.setString(2, dto.getBookName());
            pstmt.setString(3, dto.getBookAuthor());
            pstmt.setInt(4, dto.getBookPrice());
            pstmt.setDate(5, dto.getBookDate());
            pstmt.setInt(6, dto.getBookStock());
            pstmt.setString(7, dto.getPubNo());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("성공 : 도서 정보가 등록되었습니다.");
            } else {
                System.out.println("실패 : 도서 등록에 실패했습니다.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt, rs);
        }
		
	}

	@Override
	public ArrayList<BookDTO> searchBooks(int searchType, String keyword) {
		ArrayList<BookDTO> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql;
            
            if (searchType == 1) {
                sql = "SELECT * FROM BOOK ORDER BY BOOKNO";
                pstmt = con.prepareStatement(sql);
            } else {
                String condition = "";
                if (searchType == 2) {
                    condition = "B.BOOKNAME LIKE ?";
                } else if (searchType == 3) {
                    condition = "B.BOOKAUTHOR LIKE ?";
                } else if (searchType == 4) {
                    condition = "P.PUBNAME LIKE ?";
                }

                sql = "SELECT B.* FROM BOOK B JOIN PUBLISHER P ON B.PUBNO = P.PUBNO " +
                      "WHERE " + condition + " ORDER BY B.BOOKNO";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
            }

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                list.add(new BookDTO(
                        rs.getString("BOOKNO"),
                        rs.getString("BOOKNAME"),
                        rs.getString("BOOKAUTHOR"),
                        rs.getInt("BOOKPRICE"),
                        rs.getDate("BOOKDATE"),
                        rs.getInt("BOOKSTOCK"),
                        rs.getString("PUBNO")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt, rs);
        }
        return list;
        
	}

	@Override
	public void updateBook(BookDTO dto) {
		PreparedStatement pstmt = null;
        
        try {
            String sql = "UPDATE BOOK SET BOOKNAME=?, BOOKAUTHOR=?, BOOKPRICE=?, BOOKDATE=?, BOOKSTOCK=?, PUBNO=? WHERE BOOKNO=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getBookName());
            pstmt.setString(2, dto.getBookAuthor());
            pstmt.setInt(3, dto.getBookPrice());
            pstmt.setDate(4, dto.getBookDate());
            pstmt.setInt(5, dto.getBookStock());
            pstmt.setString(6, dto.getPubNo());
            pstmt.setString(7, dto.getBookNo());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("성공 : 도서 정보를 수정하였습니다. 도서 정보 조회에서 확인하세요.");
            } else {
                System.out.println("실패 : 도서 정보 수정에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt);
        }
		
	}

	@Override
	public void deleteBook(String bookNo) {
		PreparedStatement pstmt = null;
        
        try {
            String sql = "DELETE FROM BOOK WHERE BOOKNO=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("성공 : " + bookNo + " 도서를 삭제하였습니다. 도서 정보 조회에서 확인하세요.");
            } else {
                System.out.println("실패 : 해당 도서가 존재하지 않거나 삭제할 수 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt);
        }
		
	}
    
    
}
