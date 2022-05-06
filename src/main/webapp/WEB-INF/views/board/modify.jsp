<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="${pageContext.request.contextPath}/board/modify?pstartno=<c:out value="${paging.pstartno}"/>" method="post">
      
        <input type='hidden' name='pstartno' value='<c:out value="${paging.pstartno}"/>'> 
        <%-- 여기가 이제 주소창에 직접 변경이 이루어지는 name
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'> --%>
      
 
<div class="form-group">
  <label>Bno</label> 
  <input class="form-control" name='bno' 
     value='<c:out value="${board.bno }"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>Title</label> 
  <input class="form-control" name='title' 
    value='<c:out value="${board.title }"/>' >
</div>

<div class="form-group">
  <label>Text area</label>
  <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}"/></textarea>
</div>

<div class="form-group">
  <label>Writer</label> 
  <input class="form-control" name='writer'
    value='<c:out value="${board.writer}"/>' readonly="readonly">            
</div>

<div class="form-group">
  <label>RegDate</label> 
  <input class="form-control" name='regDate'
    value='<c:out value="${board.regdate}" />'  readonly="readonly">            
</div>

<div class="form-group">
  <label>Update Date</label> 
  <input class="form-control" name='updateDate'
    value='<c:out value="${board.updateDate}" />'  readonly="readonly">            
</div>

          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
  <%-- <a href="${pageContext.request.contextPath}/board/list?pstartno=<c:out value="${paging.pstartno}"/>" class="btn btn-info">List</a> --%>
</form>


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); // submit의 기능을 막는다.
	    
	    var operation = $(this).data("oper"); // data-oper 버튼의 종류에 따라 값을 받아온다.
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "${pageContext.request.contextPath}/board/remove"); //컨트롤러 remove로 이동한다.
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "${pageContext.request.contextPath}/board/list").attr("method","get"); 
	      
	      /* 
	      // http://localhost:8080/test/board/list?pageNum=&amount=&keyword=&type= 이런식으로 붙게된다. 
	      var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();      
	      
	      formObj.empty();
	      
	      formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	      formObj.append(typeTag);	  
	      */  
	      
	      var pageNumTag = $("input[name='pstartno']").clone();
	      
	      formObj.empty();
	      
	      formObj.append(pageNumTag);
	    }
	    
	    formObj.submit();
	  });

});
</script>
  




<%@include file="../includes/footer.jsp"%>
