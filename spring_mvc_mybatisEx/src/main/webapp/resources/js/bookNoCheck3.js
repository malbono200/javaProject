window.onload = function(){
	let bookNoCheckBtn = document.getElementById('bookNoCheckBtn');

	bookNoCheckBtn.addEventListener('click', ()=>{
		event.preventDefault();
		let bookNo = document.getElementById('bookNo').value;

		if(bookNo == ""){
			alert("도서번호를 입력하세요");
		} else {
			//axios의 post : data를 json(k:v)으로 구성해서 body에 담아 전달
			let data = {"bookNo" : bookNo};
			axios.post("/mybatisEx/book/bookNoCheck3", data)
				.then(function(response){
					if(response.data == "available"){
						alert("사용 가능한 도서번호입니다. (axios)");
					} else {
						alert("사용 불가능한 도서번호입니다. (axios)");
					}
				})
				.catch((error)=>{
					console.log(error.response);
				})
		}
	});
}