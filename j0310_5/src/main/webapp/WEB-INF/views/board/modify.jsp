<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">MODIFY PAGE</h1>


<button class="modBtn btn btn-primary" type="button">수정완료</button>
<button class='listBtn btn btn-mod' type="button">목록</button>
<button class='removeBtn btn btn-del' type="button">삭제</button>




<table class="table table-striped table-bordered">

	<input type="hidden" name="bno" value="${board.bno }" readonly="readonly">

	<input type="hidden" name="writer" value="${board.writer}" readonly="readonly">

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
        <h5 class="modal-title">NOTICE</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>수정 완료되었습니다.</p>
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
        <h5 class="modal-title">NOTICE</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="modalRemoveBtn btn btn-primary">Remove</button>
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

<script src="/resources/js/modify.js"></script>
<%@include file="../includes/footer.jsp"%>
