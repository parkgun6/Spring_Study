<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->

<main>
	<div class="container-fluid">
		<h1 class="mt-4">매출 통계</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a href="today">오늘의 매출</a></li>
			<li class="breadcrumb-item"><a href="hour">시간 대 매출</a></li>
			<li class="breadcrumb-item"><a href="time">지정 기간 매출</a></li>
		</ol>
		<div class="card mb-4">
			<div class="card-body">
				최근 매출입니다.
				자세한 매출은 위의 메뉴를 이용 해 주세요.
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-chart-area mr-1"></i> 최근 2주 간 매출
			</div>
			<div class="card-body">
				<canvas id="myAreaChart" width="100%" height="30"></canvas>
			</div>
			<div class="card-footer small text-muted">어제 11:59 PM에 업데이트 됨.</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar mr-1"></i> 월 별 매출
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="50"></canvas>
					</div>
					<div class="card-footer small text-muted">어제 11:59 PM에 업데이트
						됨.</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-pie mr-1"></i> 인기 많은 메뉴
					</div>
					<div class="card-body">
						<canvas id="myPieChart" width="100%" height="50"></canvas>
					</div>
					<div class="card-footer small text-muted">어제 11:59 PM에 업데이트
						됨.</div>
				</div>
			</div>
		</div>
	</div>
</main>


<%@include file="../includes/footer.jsp"%>

