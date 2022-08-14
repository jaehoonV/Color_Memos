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
    	            /*setTimeout(function() {
		            	location.reload();
		            	}, 5000);*/
    	        }
    	    }
    	});
    });
}); 