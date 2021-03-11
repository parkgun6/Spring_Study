<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">List Page</h1>


<button class='listBtn'>목록</button>
<button class='modBtn'>수정</button>
<button class='removeBtn'>삭제</button>



<table class="table table-striped table-bordered">

		<tr>
			<th>게시글번호</th>
			<td><input type="number" class="form-control" name="bno"
				value="${board.bno }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<!-- 작성자 입력 -->
			<td><input type="text" class="form-control" name="writer"
				value="${board.writer}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<!-- 제목 입력 -->
			<td><input type="text" class="form-control" name="title"
				value='${board.title}' ></td>
		</tr>
	<tr>
		<th>내용</th>
		<!-- 내용 입력 -->
		<td><textarea rows="10" class="form-control" name="content"><c:out value="${board.content }"/></textarea></td>
	</tr>

</table>
<div class="modal" id="modModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">수정</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>수정됐어여</p>
      </div>
      <div class="modal-footer">
        <!-- <button type="button" class="btn btn-primary" onclick="movePage()">Save changes</button> -->
        <button type="button" class="btn btn-secondary" onclick="movePage()" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>
<div class="modal" id="removeModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>삭제할거니</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="sendRemoveAjax()">Remove</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>
<div class="modal" id="removeCheckModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>삭제됐어여</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="moveList()" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>
<form class='actionForm' action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page }"> 
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet }">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
	<input type="hidden" name="bno" value="${board.bno }">

</form>

<script>
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


function movePage(){
	//alert("aaaa");
	actionForm.setAttribute("action","/board/read")
	actionForm.submit();
}
function moveList(){
	actionForm.setAttribute("action","/board/list")
	actionForm.submit();
}

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


dqs(".listBtn").addEventListener("click",function(){
	alert("aaa");
	actionForm.setAttribute("action","/board/list")
	actionForm.submit()
},false)

//const fnResult = sendAjax(data);

//fnResult.then(result => {console.log("Result:"+result)
//	$("#modModal").modal("show")	
//	});


dqs(".removeBtn").addEventListener("click",function(){
	$('#removeModal').modal('show');
	
},false)

function sendRemoveAjax(){
	console.log('remove');
	$('#removeModal').modal('hide');
	return fetch("/board/remove",
			{method:'post',
		headers:{'Content-Type':'application/x-www-form-urlencoded'},
		body:"bno=${board.bno}"
		}).then(res =>  { 
			res.text()
			//alert("AAA");
			$('#removeCheckModal').modal('show');
		})
	
}
			
</script>
<%@include file="../includes/footer.jsp"%>
