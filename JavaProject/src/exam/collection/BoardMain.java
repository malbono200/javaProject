package exam.collection;

import java.util.ArrayList;

public class BoardMain {

	public static void main(String[] args) {
		ArrayList<Board> boardList = new ArrayList<>();

        boardList.add(new Board("First", "1", "홍길동"));
        boardList.add(new Board("Second", "2", "이몽룡"));
        boardList.add(new Board("Third", "3", "성춘향"));

        for (Board board : boardList) {
            System.out.println(board.toString());
        }

	}

}
