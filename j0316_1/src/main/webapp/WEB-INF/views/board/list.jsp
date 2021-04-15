<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>

<%@include file="../includes/header.jsp"%>



<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">LIST PAGE</h1>


<button class="registerBtn btn btn-primary" type="button">글쓰기</button>
<br>

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
<div class="listPage">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">날짜</th>
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
</div>
<%-- <h3>${pageMaker }</h3> --%>
<br>
<br>
<span class='input-group searchDiv' aria-controls="dataTable"> <select
	name='stype' class="form-control-select stype">
		<option value='tc' ${pageDTO.type == "tc"?"selected":"" }>제목+내용</option>
		<option value='t' ${pageDTO.type == "t"?"selected":"" }>제목만</option>
		<option value='c' ${pageDTO.type == "c"?"selected":"" }>내용</option>
		<option value='w' ${pageDTO.type == "w"?"selected":"" }>작성자</option>

</select>
 <span class="input-group-append"> <input type="text"
		class="searchInput" name='skeyword' placeholder="Search for..."
		value='${pageDTO.keyword }'> <span class="input-group-append">
			<button class="btn searchBtn btn-search" type="button">
				<i class="fas fa-search fa-sm"></i>
			</button>
	</span>
</span>
</span>
<br>
<br>
<ul class="pagination" >
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

<form class='actionForm' action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page }"> 
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet }">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
</form>

<script src="/resources/js/list.js"></script>
<%@include file="../includes/footer.jsp"%>