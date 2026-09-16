$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();

		let bookNo = $('#bookNo').val();

		if(bookNo == ""){
			alert("도서번호를 입력하세요");
			return false;
		} else {
			//fetch의 get : url 경로에 값을 붙여서 전달 (슬래시 주의)
			fetch(contextPath + "/book/bookNoCheck2/" + bookNo)
				.then(response => response.text())
				.then(result => {
					console.log(result);
					if(result == "available"){
						alert("사용 가능한 도서번호입니다. (fetch)");
					} else {
						alert("사용 불가능한 도서번호입니다. (fetch)");
					}
				})
				.catch(err => console.log(err));
		}
	});
});