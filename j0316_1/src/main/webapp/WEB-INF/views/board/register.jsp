<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp" %>

<!-- Page Heading -->

<h1 class="h3 mb-4 text-gray-800">REGISTE PAGE</h1>

<button class="registerBtn btn btn-primary" type="button">완료</button>

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
		<td><input type="text" class="form-control" name="writer" value="user00" readonly="readonly"></td>
	</tr>
</table>
 <div class="custom-file">
    <input type="file" class="custom-file-input" id="validatedCustomFile" name='uploadFile' onchange="preview()" multiple='multiple' required>
    <label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
    <div class="invalid-feedback">Example invalid custom file feedback</div>
  </div>
<ul class="uploadResult">
	
</ul>

<div class="modal" id="registerModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">NOTICE</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>등록이 완료되었습니다.</p>
      </div>
      <div class="modal-footer">
        <!-- <button type="button" class="btn btn-primary" onclick="movePage()">Save changes</button> -->
        <button type="button" class="btn btn-secondary" onclick="movePage()" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>


<script src="/resources/js/register.js"></script>
<h3>${pageMaker }</h3> 
<%@include file="../includes/footer.jsp" %>

