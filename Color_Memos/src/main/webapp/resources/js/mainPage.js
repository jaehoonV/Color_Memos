$(document).ready(function(){
	memoList();
	
})

function memoList(){
	$.ajax({
		url: "/memoList",
		type: "POST", 
		dataType: "json",
		success : function(data){
			$.each(data, (index, obj) => {
				
            	let tag = 	"<div class = 'memo_div'>" +
            				"<button type='button' class='close memo_close' value='" + obj.mno  + "'>&times;</button>" +
	   	     				"<p>Title :" + obj.mname + "</p>" +
	   	     				"<p>Memo :" + obj.mdescription + "</p>" +
	   	     				"<p>Day :" + obj.regday + "</p>" +
	   	     				"<p>Color :" + obj.mcolor + "</p>" +
	   	     				"<p>Hide_gb :" + obj.hide_gb + "</p>" +
	   	     				"<p>Favorite_gb :" + obj.favorite_gb + "</p>" +
	   	     				"<p>Delete_gb :" + obj.delete_gb + "</p>" +
	   	     				"</div>";
            	
   	            $("#memo_list").append(tag);
            })
		},
		error :function(){
			alert("request error!");
			}
	}); 
}

/* 메모 작성 */
$(document).ready(function(){
    $('.memo_submit').on('click',function () {
    	let objParams = {
    		"mname" : $('#mname').val(),
    	    "memo_text" : $('#memo_text').val()
        };
    	
    	$.ajax({
    		type: "POST",
    	    url: "/memoRegist",  
    	    dataType: "json",
    	    data: objParams,
    	    async: false,
    	    success: function (data) {
    	        if(data == true){
    	        	$('#memo_register_message').css({ opacity: 0 }).animate({ opacity: 1 }, 900);
    	        	$('#memo_register_message').css({ opacity: 1 }).animate({ opacity: 0 }, 400);
    	        	setTimeout(function() {
    	        		$("#memo_register").modal("hide");
    	        		document.forms['memo_register_form'].reset();
        	        	$("#memo_list *").remove();
    	        		memoList();
		            }, 1500);
    	        }
    	    }
    	});
    });
    
    
}); 

$('#memo_register').on('hidden.bs.modal', function (e) {
	// 모달 종료 시,
	document.forms['memo_register_form'].reset(); // 폼의 전체 값 초기화 처리
});

// 메모 삭제
$(document).on("click", ".memo_close", function(){
	
	let data = $(this).val();
	
	$.ajax({
		type: "POST",
		url: "/memoDelete",  
		dataType: "json",
	    data: "mno=" + data,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	$('#memo_delete_message').css({ opacity: 0 }).animate({ opacity: 1 }, 900);
	        	$('#memo_delete_message').css({ opacity: 1 }).animate({ opacity: 0 }, 400);
	        	setTimeout(function() {
	            	$("#memo_list *").remove();
	        		memoList();
	            }, 1500);
		    }
		}
	});
}); 











