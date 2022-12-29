<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>

        <div id="page-wrapper">
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
                        <div class="panel-heading">
                            Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
								<div class="form-group">
									<laber>Bno</laber>
									<input class="form-control" name="bno" 
									value='<c:out value="${board.bno}" />' readonly="readonly">
								</div>
								
								<div class="form-group">
									<laber>Title</laber>
									<input class="form-control" name="title" 
									value='<c:out value="${board.title}"/>' readonly="readonly">
								</div>
								
								<div class="form-group">
									<laber>Text area</laber>
									<textarea class="form-control" rows="3" name="content" readonly="readonly">
										<c:out value="${board.content}"/>
									</textarea>
								</div>
								
								<div class="form-group">
									<laber>Writer</laber>
									<input class="form-control" name="writer" readonly="readonly"
									value="${board.writer}">
								</div>
								
								<button data-oper='modify' class="btn btn-default">Modify</button>
								<button data-oper='list' class="btn btn-info">List</button>
								
								<form id='operForm' action="/board/modify" method="get">
									<input type="hidden" id="bno" name="bno" value= '<c:out value="${board.bno}"/>'>
									<input type="hidden" name="pageNum" value= '<c:out value="${cri.pageNum}"/>'>
									<input type="hidden" name="amount" value= '<c:out value="${cri.amount}"/>'>
									<input type="hidden" name="type" value= '<c:out value="${cri.type}"/>'>
									<input type="hidden" name="keyword" value= '<c:out value="${cri.keyword}"/>'>
								</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
            
           <!-- Modal -->
	        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           	 	<div class="modal-dialog">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                        <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
	                    </div>
	                    <div class="modal-body">
	                        <div>
	                        	<label>Reply</label>
	                        	<input class="form-control" name="reply" value="New Reply!!!">
	                        </div>
	                        <div>
	                        	<label>Replyer</label>
	                        	<input class="form-control" name="replyer" value="Replyer">
	                        </div>
	                        <div>
	                        	<label>Reply Date</label>
	                        	<input class="form-control" name="replyDate" value="">
	                        </div>
	                    </div>
	                    <div class="modal-footer">
	                        <button type="button" id="modalModBtn" class="btn btn-info">Modify</button>
	                        <button type="button" id="modalRemoveBtn" class="btn btn-danger">Remove</button>
	                        <button type="button" id="modalRegisterBtn" class="btn btn-primary">Register</button>
	                        <button type="button" id="modalCloseBtn" class="btn btn-default">Close</button>
	                    </div>
	               </div>
                <!-- /.modal-content -->
            	</div>
            <!-- /.modal-dialog -->
       		 </div>
      		  <!-- /.modal -->
       		<!-- 모달창 종료 -->
       		   
            
            <!-- 댓글 처리부분  -->
            <div class='row'>
			  <div class="col-lg-12">
			
			    <!-- /.panel -->
			   <div class="panel panel-default">
				<!--  <div class="panel-heading">
			        <i class="fa fa-comments fa-fw"></i> Reply
			      </div> --> 
			      
			   <div class="panel-heading">
			        <i class="fa fa-comments fa-fw"></i> Reply
			        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
			   </div>     
			      
			      <!-- /.panel-heading -->
			      <div class="panel-body">        
			        <ul class="chat">
						<li class="left clearfix" data-rno='12'>
							<div>
								<div header="header">
									<strong class="primary-font">user00</strong>
									<small class="pull-right" text-muted">2022-12-30</small>
								</div>
								<p>GOOD!!</p>
							</div>
						</li>
			        </ul>
			        <!-- ./ end ul -->
			      </div>
			      <!-- /.panel .chat-panel -->
				  <div class="panel-footer">
				  </div>
				</div>
			  </div>
			  <!-- ./ end row -->
			</div>  <!-- 댓글 끝 -->
</div>
<!-- /#page-wrapper -->
        
<script type="text/javascript" src="/resources/js/reply.js"></script>
<style>
	.chat > li:hover {
		cursor : pointer;
		background-color: grey;
	}
</style>
<script>

$(document).ready(function (){
	
	var bnoValue = '<c:out value="${board.bno}"/>';
	var replyUL = $(".chat");
	
	showList(1);
	
	function showList(page){
		
		console.log("show list : " + page);
		replyService.getList({bno:bnoValue,page: page|| 1 }, function(replyCnt, list) {
			console.log("replyCnt :" + replyCnt);
			console.log("list :" + list);
			
			if(page == -1){
				pageNum = Math.ceil(replyCnt/10.0);
				showList(pageNum);
				return ;
			}
			
			var str="";
		    if(list == null || list.length == 0){
			   // replyUL.html("");
			    return;
		    }
		    
			for(var i = 0, len = list.length || 0; i < len; i++) {
				   str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
			       str +="  <div><div class='header'><strong class='primary-font'>" +
			       list[i].replyer+ "</strong>";
			       
			       str +="    <small class='pull-right text-muted'>"
			           +replyService.displayTime(list[i].replyDate) +"</small></div>";
			       str +="    <p>"+list[i].reply+"</p></div></li>";
		    }
			replyUL.html(str);
			showReplyPage(replyCnt);
		});
	 } //end ShowList
	
	//페이지 번호 출력 부분
	var pageNum = 1;
    var replyPageFooter = $(".panel-footer");
    
    function showReplyPage(replyCnt){
      
      var endNum = Math.ceil(pageNum / 10.0) * 10;  
      var startNum = endNum - 9; 
      
      var prev = startNum != 1;
      var next = false;
      
      if(endNum * 10 >= replyCnt){
        endNum = Math.ceil(replyCnt/10.0);
      }
      
      if(endNum * 10 < replyCnt){
        next = true;
      }
      
	  var str = "<ul class='pagination pull-right'>";
      
      if(prev){
        str+= "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
      }
      
      for(var i = startNum ; i <= endNum; i++){
        
        var active = pageNum == i? "active":"";
        
        str+= "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
      }
      
      if(next){
        str+= "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
      }
      
      str += "</ul></div>";
      
      console.log(str);
      
      replyPageFooter.html(str);
    }  
	// end 페이지 출력 부분 
	
	// 댓글 페이징 처리
	replyPageFooter.on("click","li a", function(e){
		e.preventDefault();
		console.log("page click");
		
		var targetPageNum = $(this).attr("href");
		
		console.log("targetPageNum: " + targetPageNum);
		
		pageNum = targetPageNum;
		
		showList(pageNum);
	});     
	//end 댓글 페이징처리
	 
	var modal = $(".modal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");
    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");

    $("#addReplyBtn").on("click", function(e){
    	modal.find("input").val("")
    	modalInputReplyDate.closest("div").hide();
    	modal.find("button[id != 'modalCloseBtn']").hide();
    	
    	modalRegisterBtn.show();
    	$(".modal").modal("show");
    	
	});
	
    
    modalRegisterBtn.on("click", function(e){
    	var reply = {
    			reply : modalInputReply.val(),
    			replyer : modalInputReplyer.val(),
    			bno : bnoValue
    	};
    	replyService.add(reply, function(result){
    		alert(result);
    		//console.log("modalRegisterBtn => " + result);
    		modal.find("input").val();
    		modal.modal("hide");
    		showList(-1);
    	});
    });
    
    
    //댓글 조회 클릭 이벤트 처리
    $(".chat").on("click", "li", function(e){
    	var rno = $(this).data("rno");
    	
    	replyService.get(rno, function(reply){
    		modalInputReply.val(reply.reply);
    		modalInputReplyer.val(reply.replyer);
    		modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
    		.attr("readonly", "readonly");
    		modal.data("rno", reply.rno);
    		
    		modal.find("button[id != 'modalCloseBtn']").hide();
    		modalModBtn.show();
    		modalRemoveBtn.show();
    		
    		$(".modal").modal("show");
    	});
    });
    
    //댓글 수정
    modalModBtn.on("click", function(e){
    	var reply = {rno:modal.data("rno"), reply : modalInputReply.val()};
    	
    	replyService.update(reply, function(result){
    		alert(result);
    		modal.modal("hide");
    		showList(pageNum);
    	});
    });
    
    //댓글 삭제.
    modalRemoveBtn.on("click", function(e){
    	var rno = modal.data("rno");
    	
    	replyService.remove(rno, function(result){
    		alert(result);
    		modal.modal("hide");
    		showList(pageNum);
    	});
    	
    });
    
    //모달창 닫기
    $("#modalCloseBtn").on("click", function(e){
    	modal.modal("hide");
    	showList(pageNum);
    });
    
/* replyService.add(
	{reply:"JS2 TEST", replyer:"tester2", bno: bnoValue},
	function(result){
		alert("RESULT : " + result);
});

replyService.getList({
	{bno:bnoValue, page:1},
	function(list){
		for(var i=0,len = list.length||0, i<len; i++){
			console.log(list[i]);
		}
			
	}
}); */

/* replyService.remove(18, function(count){
	console.log("count : " + count);
	
	if(count === "success"){
		alert("REMOVED");
	}
	}, function(err){
		alert("ERROR...");
	   }
); */

/* replyService.update(
		{rno:13, bno:bnoValue, reply:"Modified Relpy..." },
		function(reslut){
			alert("수정완료");
		}
) */

/* replyService.get(10, function(result){
	alert("-----" + JSON.stringify(result));
});
 */
}); 
		
</script>

<script>
	$(document).ready(function(){
		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action", "/board/modify").submit();
		});

		$("button[data-oper='list']").on("click",function(e){
			operForm.find("bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
	});
</script>
<%@ include file="../includes/footer.jsp" %>
