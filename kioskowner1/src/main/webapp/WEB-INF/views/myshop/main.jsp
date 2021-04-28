<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->

<h1 class="mt-4">MAIN PAGE</h1>
<div class="container-fluid">
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<div class="row">
		<!-- Column -->
		<div class="col-md-6 col-lg-3">
			<div class="card card-hover">
				<div class="box bg-cyan text-center">
					<h1 class="font-light text-white">
						<i class="mdi mdi-view-dashboard"></i>
					</h1>
					<h6 class="text-white">가게 소개</h6>
				</div>
			</div>
		</div>
		<!-- Column -->
		<div class="col-md-6 col-lg-3">
			<div class="card card-hover">
				<div class="box bg-success text-center">
					<h1 class="font-light text-white">
						<i class="mdi mdi-chart-areaspline"></i>
					</h1>
					<h6 class="text-white">안내 및 혜택</h6>
				</div>
			</div>
		</div>
		<!-- Column -->
		<div class="col-md-6 col-lg-3">
			<div class="card card-hover">
				<div class="box bg-warning text-center">
					<h1 class="font-light text-white">
						<i class="mdi mdi-collage"></i>
					</h1>
					<h6 class="text-white">점포 정보 관리</h6>
				</div>
			</div>
		</div>
		<!-- Column -->
		<div class="col-md-6 col-lg-3">
			<div class="card card-hover">
				<div class="box bg-danger text-center">
					<h1 class="font-light text-white">
						<i class="mdi mdi-border-outside"></i>
					</h1>
					<h6 class="text-white">새 메뉴 추가</h6>
				</div>
			</div>
		</div>
	</div>

<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>
/* ------------------------------가게 소개 페이지 이동------------------------------ */
document.querySelector('.bg-cyan').addEventListener("click", function(e){
	e.preventDefault();
	//console.log("aaa");
	self.location="/owner/myshop/user00/intro";
},false);
/* ------------------------------안내 및 혜택 페이지 이동------------------------------ */
document.querySelector('.bg-success').addEventListener("click", function(e){
	e.preventDefault();
	//console.log("aaa");
	self.location="/owner/myshop/user00/event";
},false);
/* ------------------------------점포 정보 관리 페이지 이동------------------------------ */
document.querySelector('.bg-warning').addEventListener("click", function(e){
	e.preventDefault();
	//console.log("aaa");
	self.location="/owner/myshop/user00/info";
},false);
/* ------------------------------새 메뉴 추가 페이지 이동------------------------------ */
document.querySelector('.bg-danger').addEventListener("click", function(e){
	e.preventDefault();
	//console.log("aaa");
	self.location="/owner/myshop/user00/menu";
},false);
/* ------------------------------검색 이벤트------------------------------ */

</script>
<%@include file="../includes/footer.jsp"%>