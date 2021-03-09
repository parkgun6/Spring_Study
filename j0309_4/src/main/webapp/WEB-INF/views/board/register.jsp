<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp" %>

<!-- Page Heading -->

<h1 class="h3 mb-4 text-gray-800">List Page</h1>



<div class="modal" id="registerModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="movePage()">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>


<script>
/* 모달 yes누르면 list로 이동 */
function movePage(){
	alert("movePage")
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
			return;
		}
		return res.text();
		})
	.catch(error =>{
		console.log("catch...........")
		console.log(error)
		return error;
	})
}

const data = {title:"한글 제목",content:"게시물내용",writer:"user00" };

/* fnResult는 Promise상태 */
const fnResult = sendAjax(data);

console.log("1111"+fnResult);

/* Promise안에 있는 값을 반환 */
fnResult.then(result => {
	console.log("RESULT : "+ result);
	//$("#registerModal").modal('show')
})

</script>

<h3>${pageMaker }</h3> 
<%@include file="../includes/footer.jsp" %>