<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp" %>

<!-- Page Heading -->

<h1 class="h3 mb-4 text-gray-800">List Page</h1>

<button class='registerBtn'>완료</button>

<table class="table table-striped table-bordered">
	<tr>
		<th>제목</th>                                     <!-- 제목 입력 -->
		<td><input type="text" class="form-control" name="title"  ></td>
	</tr>
	<tr>
		<th>내용</th>                                     <!-- 내용 입력 -->
		<td><textarea rows="10" class="form-control" name="content"></textarea></td>
	</tr>
    <tr>
		<th>작성자</th>                                    <!-- 작성자 입력 -->
		<td><input type="text" class="form-control" name="writer"></td>
	</tr>
</table>


<div class="modal" id="registerModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">저장</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>저장완료여</p>
      </div>
      <div class="modal-footer">
        <!-- <button type="button" class="btn btn-primary" onclick="movePage()">Save changes</button> -->
        <button type="button" class="btn btn-secondary" onclick="movePage()" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>


<script>

const dqs = document.querySelector.bind(document);
const table = dqs('.table');

console.log('1123111'+table.querySelector('textarea[name=content]').innerText);

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


/* 모달 yes누르면 list로 이동 */
function movePage(){
//	alert("movePage")
	self.location="/board/list"
}
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




/* fnResult는 Promise상태 */
//const fnResult = sendAjax(data);

//console.log("1111"+fnResult);

/* Promise안에 있는 값을 반환 */
//fnResult.then(result => {
//	console.log("RESULT : "+ result);
//	$("#registerModal").modal('hide')
//})



</script>

<h3>${pageMaker }</h3> 
<%@include file="../includes/footer.jsp" %>

