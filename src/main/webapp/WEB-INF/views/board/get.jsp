<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group"> <!-- =================================================================== 굳이 글 번호가 필요한가? 협의 필요할듯 =================================== -->
          <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${board.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer }"/>' readonly="readonly">
        </div>

		<button data-oper='modify' class="btn btn-default">
        <%-- 새창 띄우는 속성 <a target='_blank' href="${pageContext.request.contextPath}/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a></button> --%>
        <a href="${pageContext.request.contextPath}/board/modify?bno=<c:out value="${board.bno}"/>&pstartno=<c:out value="${paging.pstartno}"/>">Modify</a></button>
        <!-- <button data-oper='list' class="btn btn-info"> (책버전 코드 / 주로 버튼 코드로 구현되어 있다. 이것은 유행이 지난 코드 노란줄 뜸.)-->
        <a href="${pageContext.request.contextPath}/board/list?pstartno=<c:out value="${paging.pstartno}"/>" class="btn btn-info">List</a>
        <!-- </button> -->

<%-- 수정 버튼 클릭시 bno를 넘겨주기 위한 hidden 코드
<form id='operForm' action="/boad/modify" method="get"> 
  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
</form> --%>


<form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
 
</form>



      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<!-- 수정 버튼 클릭시 bno를 넘겨주기 위한 hidden 코드 onclick 관련 코드
<script type="text/javascript">
$(document).ready(function() {
 
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/board/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#bno").remove();
    operForm.attr("action","/board/list")
    operForm.submit();
    
  });  

});
</script>
 -->

<%@include file="../includes/footer.jsp"%>
