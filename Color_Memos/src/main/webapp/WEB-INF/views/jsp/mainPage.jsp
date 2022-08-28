<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl c태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="/resources/js/mainPage.js"></script>
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
	
	<div id="memo_list">
		
	</div>
	
	<div id="memo_register_message" style="opacity: 0;">
		<span>메모가 추가되었습니다.</span>
	</div>
	
	<div id="memo_delete_message" style="opacity: 0;">
		<span>메모가 삭제되었습니다.</span>
	</div>
	
	<div class="modal fade" id="memo_register">
		<div class="modal-dialog modal-dialog-centered memo_register-modal">
			<div class="modal-content memo_register-modal-content">
				<form id="memo_register_form" name="memo_register_form">
				<!-- Modal Header -->
				<div class="modal-header memo_header">
					<!-- Memo name input-->
					<input class="memo_title_input" id="mname" type="text" name="mname" placeholder="메모 제목을 입력하세요" />
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
						<!-- Memo  input-->
						<div class="memo_text_form">
							<textarea class="memo_input" id="memo_text" name="mdescription" placeholder="메모"></textarea>
						</div>
						<!-- Memo Submit Button-->
						<button type="button" class="memo_submit">만들기</button>
					<!-- /memo_regist closed-->
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal closed-->
</body>
</html>