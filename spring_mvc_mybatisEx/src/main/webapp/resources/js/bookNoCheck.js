$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();

		let bookNo = $('#bookNo').val();

		if(bookNo == ""){
			alert("도서번호를 입력하세요");
			return false;
		} else {
			//jQuery ajax : data 옵션에 담은 값이 파라미터로 전달됨
			$.ajax({
				type:"post",
				url: contextPath + "/book/bookNoCheck",
				data:{"bookNo":bookNo},
				dataType:"text",
				success:function(result){
					if(result == "available"){
						alert("사용 가능한 도서번호입니다. (ajax)");
					} else {
						alert("사용 불가능한 도서번호입니다. (ajax)");
					}
				},
				error:function(){
					alert("전송 실패");
				}
			});
		}
	});
});