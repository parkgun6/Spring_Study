<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->

<h1 class="mt-4">FAQ BOARD PAGE</h1>

<div class="card mb-4">

	<div class="card-header">
		<i class="fas fa-table mr-1"></i> 자주 묻는 질문
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>자주 묻는 질문</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>어떻게 신청하나요?</td>
						<td>2021-04-05 13:00</td>
						<td>134</td>
					</tr>
					<tr>
						<td>라면</td>
						<td>13 개</td>
						<td>39,000</td>
					</tr>
					<tr>
						<td>떡볶이</td>
						<td>20 개</td>
						<td>80,000</td>
					</tr>
					<tr>
						<td>순대</td>
						<td>15 개</td>
						<td>30,000</td>
					</tr>
					<tr>
						<td>쥬시쿨</td>
						<td>13 개</td>
						<td>26,000</td>
					</tr>
					<tr>
						<td>콜라</td>
						<td>20 개</td>
						<td>80,000</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>

