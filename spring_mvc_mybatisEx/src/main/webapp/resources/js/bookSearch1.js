// ajax를 활용한 비동기 통신, 검색결과를 받아와서 정해진 위치에 태그 생성 후 포함

$(document).ready(function(){
	$('#bookSearchFrm').on('submit', function(){
		event.preventDefault();

		//폼에 있는 폼 data를 payload(파라미터)로 구성
		let formData = $(this).serialize();

		let keyword = $("#keyword").val();
		let type = $("#type").val();

		if(keyword == "" || type == ""){
			alert("검색조건과 검색어를 입력하세요");
			return false;
		} else {
			$.ajax({
				type:"post",
				url:"/mybatisEx/book/bookSearch1",
				data:formData,
				success:function(result){
					//검색결과 표현 영역안을 지우고 테이블 생성
					$('#searchResultBox').empty();
					$('#searchResultBox').append(
						'<table id="resultTable" border="1" width="700">' +
						'<tr><th>도서번호</th><th>도서명</th><th>저자</th><th>가격</th>' +
						'<th>재고</th><th>출간일</th><th>출판사번호</th><th>표지</th></tr>'
					);

					if(result == ""){ //검색 결과가 없는 경우
						$('#resultTable').append('<tr align="center"><td colspan="8">찾는 도서가 없습니다</td></tr>');
					} else {
						console.log(result);
						for(let i=0; i<result.length; i++){
							let book_date = new Date(result[i].bookDate);
							let year = book_date.getFullYear();
							let month = (book_date.getMonth()+1).toString().padStart(2,'0');
							let date = (book_date.getDate()).toString().padStart(2,'0');
							let bookDate = `${year}-${month}-${date}`;
							$('#resultTable').append('<tr><td>' + result[i].bookNo + '</td><td>' +
															  result[i].bookName + '</td><td>' +
															  result[i].bookAuthor + '</td><td>' +
															  result[i].bookPrice + '</td><td>' +
															  result[i].bookStock + '</td><td>' +
															  bookDate + '</td><td>' +
															  result[i].pubNo + '</td><td>' +
															  '<img src="/mybatisEx/resources/image/apple.png" width="30" height="30"></td></tr>');
						}
					}
				},
				error:function(){alert("실패");}
			}); //ajax 끝
		}
	}); //on 끝
}); //ready 끝