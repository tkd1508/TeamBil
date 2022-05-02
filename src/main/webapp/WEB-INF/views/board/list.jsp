<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
			<p class="panel-body">
				<a href="${pageContext.request.contextPath}/board/register"
					class="btn btn-info">글 등록하기</a>
			</p>
		</div>

		<!--  페이지 이동 버튼으로 책 버전은 스크립트 onclick으로 사용하고 있다. (책 버전) _ ref p.250 
	<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id='regBtn' type="button" class="btn btn-xs pull-right">
				RegisterNew Board</button>
			</div>
-->

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="board" varStatus="status">
						<tr>
							<td><c:out value="${paging.listTotal-paging.pstartno-status.index}" /></td>
							<td><a class='move'
								href='${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&pstartno=<c:out value="${paging.pstartno}"/>'>
									<c:out value="${board.title}" />
							</a></td>
							<td><c:out value="${board.writer}" /></td>
							<td><c:out value="${board.regdate}" /></td>
							<td><c:out value="${board.updateDate}" /></td>
						</tr>
					</c:forEach>
					<tfoot>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
						</tr>
					</tbody>
				</table>


				<nav aria-label="Page navigation example" >

					<ul class="pagination justify-content-end">  

						<c:if test="${paging.startBtn >= paging.bottomlist }">   
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/board/list?pstartno=${(paging.startBtn-2)*paging.onepageLimit }">이전</a></li>
						</c:if>

						<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}">
							<li class="page-item <c:if test="${i==paging.currentBtn}">active</c:if>">  
								<a class="page-link"
								href="${pageContext.request.contextPath}/board/list?pstartno=${(i-1)*paging.onepageLimit}">${i}</a>
							</li>
						</c:forEach>

						<c:if test="${paging.pageAll > paging.endBtn }">
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/board/list?pstartno=${paging.endBtn*paging.onepageLimit}">다음</a></li>
						</c:if>
					</ul>
				</nav>



				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body"></div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

<!-- End of Main Content -->
<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		console.log(result);

		checkModal(result);

		history.replaceState({}, null, null); // 뒤로가기 문제 해결 ref p.255~257

		function checkModal(result) {

			if (result === '' || history.state) {
				return;
			}

			/*
			 if (result.equals("success")) {
			 console.log("test");
			 $(".modal-body").html(
			 "게시글이 등록되었습니다.");
			 }
			 */
			$(".modal-body").html("게시글이 " + result + "되었습니다.");

			$("#myModal").modal("show");
		}

		/*		페이지 이동 방식 (책 버전) _ ref p.250
		 $("#regBtn").on("click", function() {

		 self.location = "/board/register";

		 });
		 */

	});
</script>

<%@ include file="../includes/footer.jsp"%>
