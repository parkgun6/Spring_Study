<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">VIEW PAGE</h1>
<%-- 
<h2>${board }</h2>
<h3>${pageDTO }</h3> --%>

<button class="listBtn btn btn-primary" type="button">목록</button>
<button class='modBtn btn btn-mod' type="button">수정/삭제</button>

<br>

<table class="table table-striped table-bordered">
	<input type="hidden" class="form-control" name="bno"
		value="${board.bno }" readonly="readonly">

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





<br>

<button class="registerBtn btn btn-primary" type="button">글쓰기</button>
<br>
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

<%-- <h3>${pageMaker }</h3> --%>

<span class='searchDiv input-group' aria-controls="dataTable">
<select name='stype' class='form-control-select stype'>
<option value='tc'${pageDTO.type == "tc"?"selected":"" }>제목+내용</option>
<option value='t'${pageDTO.type == "t"?"selected":"" }>제목</option>
<option value='c'${pageDTO.type == "c"?"selected":"" }>내용</option>
<option value='w'${pageDTO.type == "w"?"selected":"" }>작성자</option>

</select>
 <span class="input-group-append"> <input type="text"
		class="searchInput" name='skeyword' placeholder="Search for..."
		value='${pageDTO.keyword }'> <span class="input-group-append">
			<button class="btn searchBtn btn-search" type="button">
				<i class="searchi fas fa-search fa-sm"></i>
			</button>
	</span>
</span>
</span>
<br>
<br>
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

<script src="/resources/js/read.js"></script>
<%@include file="../includes/footer.jsp"%>