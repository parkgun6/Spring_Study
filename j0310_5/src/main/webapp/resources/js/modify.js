
const dqs = document.querySelector.bind(document);
const actionForm = dqs(".actionForm");
const table = dqs(".table");
console.log(table)
//const bnoval = table.querySelector("input[name=bno]").value
//const titleval = table.querySelector("input[name=title]").value
//const contentval = table.querySelector("input[name=content]").value
//	const writerval = table.querySelector("input[name=writer]").value
//console.log(table.querySelector("input[name=bno]").value)
//console.log(table.querySelector("input[name=title]").value)
//console.log(table.querySelector("input[name=content]").value)

/* ------------------------------게시글로이동------------------------------ */
function movePage(){
	//alert("aaaa");
	actionForm.setAttribute("action","/board/read")
	actionForm.submit();
}
/* ------------------------------목록이동------------------------------ */
function moveList(){
	actionForm.setAttribute("action","/board/list")
	actionForm.submit();
}
/* ------------------------------수정Ajax------------------------------ */
function sendAjax(data){
	console.log("sendAjax...",data)

	
	return fetch("/board/modify",
		{method:"post",
		headers:{'Content-Type' : 'application/json'},
		body:JSON.stringify(data)}).then(res => {return res.text()})
		.then(result => {console.log("Result:"+result)
			$("#modModal").modal("show")	
			});

	
}
//console.log(sendAjax(data))

/* ------------------------------수정 완료 이벤트------------------------------ */

dqs(".modBtn").addEventListener("click",function(e){
	e.preventDefault();
	
	const bnoval = table.querySelector("input[name=bno]").value
	const titleval = table.querySelector("input[name=title]").value
	//const contentval = table.querySelector("input[name=content]").value
	const contentval = table.querySelector("textarea[name=content]").value
	console.log(contentval)
	const writerval = table.querySelector("input[name=writer]").value
	
	const data = {bno:bnoval,title:titleval,content:contentval,writer:writerval};
	
	sendAjax(data)
	
},false)

/* ------------------------------목록 이동 이벤트------------------------------ */

dqs(".listBtn").addEventListener("click",function(){
	//alert("aaa");
	actionForm.setAttribute("action","/board/list")
	actionForm.submit()
},false)

//const fnResult = sendAjax(data);

//fnResult.then(result => {console.log("Result:"+result)
//	$("#modModal").modal("show")	
//	});


/* ------------------------------삭제 Ajax------------------------------ */

	function sendRemoveAjax(){
	console.log('remove');
	$('#removeModal').modal('hide');
	return fetch("/board/remove",
			{
			method:'post',
		    headers:{'Content-Type':'application/x-www-form-urlencoded'},
		    body:"bno=" + $("input[name='bno']").val()
		}).then(res =>  { 
			res
			$('#removeCheckModal').modal('show');
		})
	
}
/* ------------------------------삭제 이벤트------------------------------ */
dqs(".removeBtn").addEventListener("click",function(){
	$('#removeModal').modal('show');

},false)
/* ---------------------------삭제(모달) 이벤트--------------------------- */

dqs(".modalRemoveBtn").addEventListener("click",function(){
	$('#removeModal').modal('hide');

	sendRemoveAjax()
},false)
