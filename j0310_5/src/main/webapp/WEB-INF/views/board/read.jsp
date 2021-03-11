<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">List Page</h1>
<%-- 
<h2>${board }</h2>
<h3>${pageDTO }</h3> --%>

<button class='listBtn'>목록</button>
<button class='modBtn'>수정/삭제</button>

<table class="table table-striped table-bordered">

		<tr>
			<th>게시글번호</th>
			<td><input type="number" class="form-control" name="bno"
				value="${board.bno }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<!-- 작성자 입력 -->
			<td><input type="text" class="form-control" name="mid"
				value="${board.writer}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<!-- 제목 입력 -->
			<td><input type="text" class="form-control" name="title"
				value='${board.title}' readonly="readonly"></td>
		</tr>
		<tr>
			<th>내용</th>
			<!-- 내용 입력 -->
			<td><textarea rows="10" class="form-control" name="content"
				readonly="readonly">${board.content}</textarea></td>
		</tr>

	</table>




<button class='registerBtn'>글쓰기</button>

<div class='searchDiv'>
<select name='stype' class='stype'>
<option value=''>------</option>
<option value='t'${pageDTO.type == "t"?"selected":"" }>제목</option>
<option value='c'${pageDTO.type == "c"?"selected":"" }>내용</option>
<option value='w'${pageDTO.type == "w"?"selected":"" }>작성자</option>
<option value='tc'${pageDTO.type == "tc"?"selected":"" }>제목+내용</option>
<option value='tcw'${pageDTO.type == "tcw"?"selected":"" }>제목+내용+작성자</option>
</select>
<input name='skeyword' type='text' value='${pageDTO.keyword }'>
<button class='searchBtn'>검색</button>
</div>
<ul>
<%-- 	<c:forEach items="${list }" var="board">
		<li>
		<!-- 크로스 사이트 스크립팅을 막기 위해서 c:out태그를 사용했다. -->
		<span><a class='listA' href="<c:out value="${board.bno }"/>">
		<c:out value="${board.bno }"/></a></span>
		<c:out value="${board.title }"></c:out>
		</li>
	</c:forEach> --%>
</ul>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">게시글번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">시간</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="board">
    <tr>
      <th scope="row">${board.bno }</th>
      <td><a class ='listA' href="<c:out value='${board.bno }'/>"><c:out value="${board.title }"></c:out></a></td>
      <td>${board.writer }</td>
      <td>${board.regdate }</td>
    </tr>
    	</c:forEach>
  </tbody>
</table>

<%-- <h3>${pageMaker }</h3> --%>


<ul class="pagination">
	<c:if test="${pageMaker.prev}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.start - 1}" tabindex="-1">Previous</a></li>
	</c:if>
	<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
		<li class="page-item ${num == pageMaker.pageInfo.page ? "active" : ""}">
			<a class="page-link" href="${num }">${num}</a>
		</li>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<li class="page-item"><a class="page-link"
			href="${pageMaker.end + 1 }">Next</a></li>
	</c:if>
</ul>

<form class='actionForm' action="/board/read" method="get">
	<input type="hidden" name="page" value="${pageDTO.page }"> 
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet }">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
	<input type="hidden" name="bno" value="${board.bno}">
</form>

<script>


const dqs = document.querySelector.bind(document);
//const obj = dqs(".listBtn")
const actionForm = document.querySelector(".actionForm");
//console.log(obj)


//console.log(dqs(".table").querySelector("textarea[name=content]").value)
const bno = dqs(".table-striped").querySelector("input[name='bno']").value
console.log(bno)

console.log(dqs(".table-striped").querySelector("input[name='bno']").value)
console.log(actionForm.querySelector("input[name='bno']"))


/* ------------------------------목록 이동 이벤트------------------------------ */


dqs(".listBtn").addEventListener("click",function(e){

actionForm.setAttribute("action","/board/list")
actionForm.submit();

},false)


/* ------------------------------수정/삭제 이동 이벤트------------------------------ */


dqs(".modBtn").addEventListener("click",function(e){
	actionForm.innerHTML+="<input type='hidden' name='bno' value='${board.bno}'>"
	actionForm.setAttribute("action","/board/modify")
	actionForm.submit();
	
	
},false)




/* ------------------------------페이지 이동 이벤트------------------------------ */

document.querySelector(".pagination").addEventListener("click",e=>{
	e.preventDefault();
	const target = e.target;
	console.log(target);
	const pageNum = target.getAttribute("href");
	console.log(pageNum);
	
	document.querySelector(".actionForm input[name='page']").value=pageNum;
	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
	actionForm.submit();
	
},false);

/* ------------------------------게시글 이동 이벤트------------------------------ */

document.querySelectorAll(".listA").forEach(a => {
	a.addEventListener("click",function(e) {
		e.preventDefault();
		const bno = e.target.getAttribute("href");
		;
		actionForm.setAttribute("action","/board/read");
		//console.log(bno)
		
		actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
		console.log(actionForm.querySelector("input[name=bno]"))
		actionForm.submit();
	},false);
})

/* ------------------------------검색 이벤트------------------------------ */

document.querySelector(".searchBtn").addEventListener("click",function(e){
	
	//검색타입과 키워드를 가져와야한다
	//console.log(actionForm.querySelector(".stype").selectedIndex);
	const stype = document.querySelector(".stype");
	const idx = stype.selectedIndex;
	const type = stype[idx].value;
	
	//alert(type);
	//검색시 페이지 1로 초기화
	actionForm.querySelector("input[name='page']").value = 1;
	actionForm.querySelector("input[name='type']").value = type;
	actionForm.querySelector("input[name='keyword']").value = 
		document.querySelector("input[name='skeyword']").value;
	
	actionForm.submit();
},false)

/* ------------------------------글쓰기 이벤트------------------------------ */

dqs(".registerBtn").addEventListener("click",function(){
	
	self.location="/board/register";
	
},false)


</script>
<%@include file="../includes/footer.jsp"%>