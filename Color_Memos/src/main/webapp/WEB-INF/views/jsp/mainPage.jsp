<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl c태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<!-- css -->
<link href="/resources/css/mainPage.css" rel="stylesheet">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- js -->
<script src="/resources/js/mainPage.js" defer></script>
<!-- 폰트어썸 -->
<script src="https://kit.fontawesome.com/f1b7ad5b17.js" crossorigin="anonymous"></script>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div>HI, This page is MainPage.</div>
	
	<!-- Button to Open the Modal -->
	<button type="button" class="green_class" data-toggle="modal" data-target="#memo_register" id="popup_memo_register">메모 추가</button>
	
	<!-- search bar -->
	<div class="search_wrapper">
      <label for="search">Search</label>
      <input type="search" id="search_input" data-search>
  	</div>
  	
  	<div class="user-cards" data-user-cards-container>

   </div>
   <template data-user-template>
      <div class="card">
         <div class="header" data-header></div>
         <div class="body" data-body></div>
      </div>
   </template>
   
	<section class="hide_section">
		<div class="hide_div">
		<span>hide button</span>
		<div class="checkbox">
    		<input type="checkbox" id="hide_check">
    		<label></label>
    	</div>
    </div>
    </section>
	<div id="memo_list">
		
	</div>
	
	<span>Delete Memo List</span>
	<div id="delt_memo_list">
		
	</div>
	
	<div class="message_class" id="memo_register_message" style="opacity: 0;">
		<span>메모가 추가되었습니다.</span>
	</div>
	
	<div class="message_class" id="memo_delete_message" style="opacity: 0;">
		<span>메모가 삭제되었습니다.</span>
	</div>
	
	<div class="message_class" id="memo_restore_message" style="opacity: 0;">
		<span>메모가 복구되었습니다.</span>
	</div>
	
	<div class="message_class" id="memo_modify_message" style="opacity: 0;">
		<span>메모가 수정되었습니다.</span>
	</div>
	
	<div class="modal fade" id="memo_register">
		<div class="modal-dialog modal-dialog-centered memo_register-modal">
			<div class="modal-content memo_register-modal-content">
				<form id="memo_register_form" name="memo_register_form">
				<div class="modal-header memo_header">
					<input class="memo_title_input" id="mname" type="text" name="mname" placeholder="메모 제목을 입력하세요" />
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
						<div class="memo_text_form">
							<textarea class="memo_input" id="memo_text" name="mdescription" placeholder="메모"></textarea>
						</div>
						<button type="button" class="memo_submit">만들기</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal closed-->
	
	<div class="modal fade" id="modifyMemo">
		<div class="modal-dialog modal-dialog-centered memo_modify-modal">
			<div class="modal-content memo_modify-modal-content">
				<form method="post" id="modifyMemoForm" name="memo_modify_form">
				<input type="hidden" name="mno" id="modify_memo_mno">
				<div class="modal-header memo_header">
					<input class="memo_title_input" id="modify_memo_title" type="text" name="mname" placeholder="메모 제목을 입력하세요" />
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
						<div class="memo_text_form">
							<textarea class="memo_input" id="modify_memo_content" name="mdescription" placeholder="메모"></textarea>
						</div>
						<button type="button" class="memo_modify_submit">수정</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal closed-->
	
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>