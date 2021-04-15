
const dqs = document.querySelector.bind(document);
const table = dqs('.table');

console.log('1123111'+table.querySelector('textarea[name=content]').innerText);
/* ------------------------------등록Ajax------------------------------ */
function sendAjax(data){
	console.log("sendAjax..",data)
	
	return fetch("/board/register",
		{method:"post",
		headers:{'Content-Type':'application/json'},
		body: JSON.stringify(data)})
		/* 지금 상태는 Promise로 되어있는 상태다. */
	.then(res => {
		if(!res.ok){
			throw new Error(res)
		}
		return res.text();
		})
	.catch(error =>{
		console.log("catch...........")
		console.log(error)
		return error;
	}).then(result => {
		console.log("RESULT : "+ result);
		$("#registerModal").modal('show')
	})
}
/* ------------------------------게시글등록 이벤트------------------------------ */
dqs(".registerBtn").addEventListener("click",function(){
	
	//console.log("aaa")
	console.log( table.querySelector("textarea[name=content]").innerText)
	const titleval = table.querySelector("input[name=title]").value
	const contentval = table.querySelector("textarea[name='content']").value
	const writerval = table.querySelector("input[name=writer]").value
	
	console.log("-------------------------")
	
	console.log(contentval);

	const data = {title:titleval,content:contentval,writer:writerval};
	
	console.log(data);

	sendAjax(data);
	
},false)

/* ------------------------------모달이동------------------------------ */
/* 모달 yes누르면 list로 이동 */
function movePage(){
//	alert("movePage")
	self.location="/board/list"
}




/* fnResult는 Promise상태 */
//const fnResult = sendAjax(data);

//console.log("1111"+fnResult);

/* Promise안에 있는 값을 반환 */
//fnResult.then(result => {
//	console.log("RESULT : "+ result);
//	$("#registerModal").modal('hide')
//})

