// ajax를 활용한 비동기 통신, 검색결과 html을 받아와서 정해진 위치에 포함

$(document).ready(function(){
	$('#bookSearchFrm').on('submit', function(){
		event.preventDefault();

		let formData = $(this).serialize();

		let keyword = $("#keyword").val();
		let type = $("#type").val();

		if(keyword == "" || type == ""){
			alert("검색조건과 검색어를 입력하세요");
			return false;
		} else {
			$.ajax({
				type:"post",
				url:"/mybatisEx/book/bookSearch2",
				data:formData,
				success:function(result){ //result에 검색 결과를 담은 html 코드가 반환
					$('#searchResultBox').html(result);
				},
				error:function(){alert("실패");}
			}); //ajax 끝
		}
	}); //on 끝
}); //ready 끝