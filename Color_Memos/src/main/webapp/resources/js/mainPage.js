$(document).ready(function(){
	memoList();
})

/* $(document).ready(function(){
	memoListTest();
})*/

$(document).ready(function(){
	delt_memoList();
})

// 검색
const userCardTemplate = document.querySelector("[data-user-template]")
const userCardContainer = document.querySelector("[data-user-cards-container]")
const searchInput = document.querySelector("[data-search]")

let objs = []

searchInput.addEventListener("input", (e) => { // 입력하는 것에 모두 실행
   const value = e.target.value.toLowerCase() // 소문자, 대문자 구분 X
   objs.forEach(obj => {
      const isVisible = obj.mname.toLowerCase().includes(value) || obj.mdescription.toLowerCase().includes(value) // 입력값이 name이나 email에 포함돼있다면 true
      obj.element.classList.toggle("hide", !isVisible) // false일 경우 hide
   })
})

function memoList(){
	$.ajax({
		url: "/memoList",
		type: "GET", 
		dataType: "json",
		success : function(data){
			objs = data.map(obj => {
         const card = userCardTemplate.content.cloneNode(true).children[0]; // 첫번째 자식을 가져옴
         const header = card.querySelector("[data-mname]");
         const menu = card.querySelector("[data-menu]");
         const navigation = card.querySelector("[data-navigation]");
         const body = card.querySelector("[data-content]");
         const footer = card.querySelector("[data-day]");
         
         let tag = "<ul><li style='--i:0.1s'><a  data-toggle='modal' href='#modifyMemo' onclick='modifyMemo(" +obj.mno+ ");' ><ion-icon name='pencil-outline'></ion-icon></a></li><li style='--i:0.2s'><a href='#' onclick='hidememo(" +obj.mno+ ");'>" ;
         if(obj.hide_gb == 1){		    
            tag += "<ion-icon name='eye-outline'></ion-icon></a></li>";
         }else{
            tag += "<ion-icon name='eye-off-outline'></ion-icon></a></li>";
         }
            	
         tag += "<li style='--i:0.3s'><a href='#' onclick='deletememo(" +obj.mno+ ");' ><ion-icon name='trash-outline'></ion-icon></a></li></ul>";
         
         let tag_fav = "";
            			    
         if(obj.favorite_gb == 1){
            tag_fav += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/star.png' style='width: 20px;'></button>";
         }else{
            tag_fav += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/empty_star.png' style='width: 20px;'></button>";
         }
                  
         $(menu).html(tag).trigger("create");
         $(navigation).after(tag_fav);
         $(header).html(obj.mname).trigger("create");
         $(body).html(obj.mdescription).trigger("create");
         $(footer).html(obj.regday).trigger("create");
         userCardContainer.append(card)
         return { mname: obj.mname, mdescription: obj.mdescription, regday: obj.regday, element: card }
      		});
		},
		error :function(){
			alert("request error!");
			}
	}); 
}

// 메모 숨김
function memoList_h(){
	$.ajax({
		url: "/memoList_h",
		type: "POST", 
		dataType: "json",
		success : function(data){
			$.each(data, (index, obj) => {
				
				let tag = 	"<div class = 'memo_div'>" +
				"<div class='navigation'><div class='menuToggle'></div><div class='menu'>" +
			    "<ul><li style='--i:0.1s'><a href><ion-icon name='pencil-outline'></ion-icon></a></li>" +
			    "<li style='--i:0.2s'><a href='#' onclick='hidememo(" +obj.mno+ ");'>" ;
				
				tag += "<ion-icon name='eye-off-outline'></ion-icon></a></li>" +
						
						"<li style='--i:0.3s'><a href='#' onclick='deletememo(" +obj.mno+ ");' ><ion-icon name='trash-outline'></ion-icon></a></li></ul></div></div>";
			    
				if(obj.favorite_gb == 1){
					tag += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/star.png' style='width: 20px;'></button>";
				}else{
					tag += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/empty_star.png' style='width: 20px;'></button>";
				}
	
	   	     	tag +=		"<p style='font-weight:bold;'>" + obj.mname + "</p>" +
	   	     				"<div class = 'memo_content'>" +
	   	     				"<p>" + obj.mdescription + "</p>" +
	   	     				"</div>" + "<p class='regday'>" + obj.regday + "</p>" + "</div>";
            	
   	            $(".user-cards").append(tag);
            })
		},
		error :function(){
			alert("request error!");
			}
	}); 
}

function delt_memoList(){
	$.ajax({
		url: "/delt_memoList",
		type: "POST", 
		dataType: "json",
		success : function(data){
			$.each(data, (index, obj) => {
				
            	let tag = 	"<div class = 'memo_div'>" +
            				"<button type='button' class='close memo_restore' value='" + obj.mno  + "'>복구</button>" +
	   	     				"<p style='font-weight:bold;'>" + obj.mname + "</p>" +
	   	     				"<div class = 'memo_content'>" +
	   	     				"<p>" + obj.mdescription + "</p>" +
	   	     				"</div>" + "<p class='regday'>" + obj.regday + "</p>" + "</div>";
            	
   	            $("#delt_memo_list").append(tag);
            })
		},
		error :function(){
			alert("request error!");
			}
	}); 
}

$(document).ready(function(){
	/* 메모 작성 */
    $('.memo_submit').on('click',function () {
    	let hide_check = $("#hide_check").prop("checked");
    	let objParams = {
    		"mname" : $('#mname').val(),
    	    "memo_text" : $('#memo_text').val().replace(/(?:\r\n|\r|\n)/g, '<br />')
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
        	        	$(".user-cards *").remove();
        	        	if(hide_check){
    	            		memoList_h();
    	            	}else{
							
    	            		memoList();
    	            	}
		            }, 1500);
    	        }
    	    }
    	});
    });
    
    /* 메모 수정 */
    $('.memo_modify_submit').on('click',function () {
    	let hide_check = $("#hide_check").prop("checked");
    	let objParams = {
    		"mname" : $('#modify_memo_title').val(),
    	    "mdescription" : $('#modify_memo_content').val().replace(/(?:\r\n|\r|\n)/g, '<br />'),
        	"mno" : $('#modify_memo_mno').val()
        };
    	
    	$.ajax({
    		type: "POST",
    	    url: "/modifyMemo",  
    	    dataType: "json",
    	    data: objParams,
    	    async: false,
    	    success: function (data) {
    	        if(data == true){
    	        	$('#memo_modify_message').css({ opacity: 0 }).animate({ opacity: 1 }, 900);
    	        	$('#memo_modify_message').css({ opacity: 1 }).animate({ opacity: 0 }, 400);
    	        	setTimeout(function() {
    	        		$("#modifyMemo").modal("hide");
    	        		document.forms['memo_register_form'].reset();
        	        	$(".user-cards *").remove();
        	        	if(hide_check){
    	            		memoList_h();
    	            	}else{
    	            		memoList();
    	            	}
		            }, 1500);
    	        }
    	    }
    	});
    });
    
    // memo menu
    $(document).on("click", ".menuToggle", function(){
    	$(this).toggleClass('active');
    })
    
}); 

$('#memo_register').on('hidden.bs.modal', function (e) {
	// 모달 종료 시,
	document.forms['memo_register_form'].reset(); // 폼의 전체 값 초기화 처리
});

// 메모 삭제
$(document).on("click", ".memo_close", function(){
	let hide_check = $("#hide_check").prop("checked");
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
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}); 

function deletememo(mno){
	let hide_check = $("#hide_check").prop("checked");
	
	$.ajax({
		type: "POST",
		url: "/memoDelete",  
		dataType: "json",
	    data: "mno=" + mno,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	$('#memo_delete_message').css({ opacity: 0 }).animate({ opacity: 1 }, 900);
	        	$('#memo_delete_message').css({ opacity: 1 }).animate({ opacity: 0 }, 400);
	        	setTimeout(function() {
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}

// 메모 복구
$(document).on("click", ".memo_restore", function(){
	let hide_check = $("#hide_check").prop("checked");
	let data = $(this).val();
	
	$.ajax({
		type: "POST",
		url: "/memoRestore",  
		dataType: "json",
	    data: "mno=" + data,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	$('#memo_restore_message').css({ opacity: 0 }).animate({ opacity: 1 }, 900);
	        	$('#memo_restore_message').css({ opacity: 1 }).animate({ opacity: 0 }, 400);
	        	setTimeout(function() {
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}); 

// 메모 숨김
$(document).on("click", ".memo_hide", function(){
	let hide_check = $("#hide_check").prop("checked");
	let data = $(this).val();
	
	$.ajax({
		type: "POST",
		url: "/memoHide",  
		dataType: "json",
	    data: "mno=" + data,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	setTimeout(function() {
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}); 

function hidememo(mno){
	let hide_check = $("#hide_check").prop("checked");
	
	$.ajax({
		type: "POST",
		url: "/memoHide",  
		dataType: "json",
	    data: "mno=" + mno,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	setTimeout(function() {
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}

// 메모 즐겨찾기
$(document).on("click", ".memo_fav", function(){
	let hide_check = $("#hide_check").prop("checked");
	let data = $(this).val();
	
	$.ajax({
		type: "POST",
		url: "/memoFav",  
		dataType: "json",
	    data: "mno=" + data,
	    async: false,
	    success: function (data) {
	        if(data == true){
	        	setTimeout(function() {
	            	$(".user-cards *").remove();
	            	$("#delt_memo_list *").remove();
	            	if(hide_check){
	            		memoList_h();
	            	}else{
	            		memoList();
	            	}
	        		delt_memoList();
	            }, 1500);
		    }
		}
	});
}); 

// 메모 숨김 리스트
$(document).on("click", "#hide_check", function(){
	let hide_check = $(this).prop("checked");
	$(".user-cards *").remove();
	if(hide_check){
		memoList_h();
	}else{
		memoList();
	}
}); 

// 메모 수정
function modifyMemo(mno) {
	console.log('modifyMemo click');
	$.ajax({
		url: "/modifyMemo_mno",  
		type: "POST",
		dataType: "json",
		data: {
			mno: mno,
		},
		success : function(data){
			console.log(data);
			$('#modify_memo_title').val(data.mname);
			$('#modify_memo_content').val(data.mdescription.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n'));
			$('#modify_memo_mno').val(data.mno);
		}
	});
}



function memoListTest(){
	$.ajax({
		url: "/memoList",
		type: "GET", 
		dataType: "json",
		success : function(data){
			objs = data.map(obj => {
         const card = userCardTemplate.content.cloneNode(true).children[0]; // 첫번째 자식을 가져옴
         const header = card.querySelector("[data-mname]");
         const menu = card.querySelector("[data-menu]");
         const navigation = card.querySelector("[data-navigation]");
         const body = card.querySelector("[data-content]");
         const footer = card.querySelector("[data-day]");
         
         let tag = "<ul><li style='--i:0.1s'><a  data-toggle='modal' href='#modifyMemo' onclick='modifyMemo(" +obj.mno+ ");' ><ion-icon name='pencil-outline'></ion-icon></a></li><li style='--i:0.2s'><a href='#' onclick='hidememo(" +obj.mno+ ");'>" ;
         if(obj.hide_gb == 1){		    
            tag += "<ion-icon name='eye-outline'></ion-icon></a></li>";
         }else{
            tag += "<ion-icon name='eye-off-outline'></ion-icon></a></li>";
         }
            	
         tag += "<li style='--i:0.3s'><a href='#' onclick='deletememo(" +obj.mno+ ");' ><ion-icon name='trash-outline'></ion-icon></a></li></ul>";
         
         let tag_fav = "";
            			    
         if(obj.favorite_gb == 1){
            tag_fav += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/star.png' style='width: 20px;'></button>";
         }else{
            tag_fav += "<button type='button' class='close memo_fav' value='" + obj.mno  + "'><img src='/resources/images/empty_star.png' style='width: 20px;'></button>";
         }
                  
         $(menu).html(tag).trigger("create");
         $(navigation).after(tag_fav);
         $(header).html(obj.mname).trigger("create");
         $(body).html(obj.mdescription).trigger("create");
         $(footer).html(obj.regday).trigger("create");
         userCardContainer.append(card)
         return { mname: obj.mname, mdescription: obj.mdescription, regday: obj.regday, element: card }
      		});
		},
		error :function(){
			alert("request error!");
		}
	}); 
}





