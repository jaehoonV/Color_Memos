/* 메모 작성 */
$(function () {
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
		            	location.reload();
		            }, 1300);
    	        }
    	    }
    	});
    });
}); 


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
            	let tag = 	"<div>" +
	   	     				"<p>메모제목 :" + obj.mname + "</p>" +
	   	     				"<p>메모 :" + obj.mdescription + "</p>" +
	   	     				"<p>작성일 :" + obj.regday + "</p>" +
	   	     				"<p>메모 색상 :" + obj.mcolor + "</p>" +
	   	     				"</div>";
   	            $("#memo_list").append(tag);
            })
		},
		error :function(){
			alert("request error!");
			}
	}); 
}




