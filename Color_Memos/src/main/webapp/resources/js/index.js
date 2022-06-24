$(document).ready(function() {
	$('#goRight').on('click', function() {
		$('#slideBox').animate({
			'marginLeft' : '0'
		});
		$('.topLayer').animate({
			'marginLeft' : '100%'
		});
	});
	$('#goLeft').on('click', function() {
		if (window.innerWidth > 769) {
			$('#slideBox').animate({
				'marginLeft' : '50%'
			});
		} else {
			$('#slideBox').animate({
				'marginLeft' : '20%'
			});
		}
		$('.topLayer').animate({
			'marginLeft' : '0'
		});
	});

	$('#loginForm').validate({
		rules : {
			email : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			email : {
				required : "이메일을 입력해 주세요."
			},
			password : {
				required : "비밀번호를 입력해 주세요."
			}
		},
		submitHandler : function() { // 유효성 검사를 통과시 전송
			loginForm.submit();
		},
	});// end validate()

	$('#joinForm').validate({
		rules : {
			email : {
				required : true,
				email : true,
				/* remote : 엘리먼트의 검증을 지정된 다른 자원에 ajax 로 요청 */
				remote : {
					url : "/userEmailChk",
					type : "post",
					data : {
						email : function() {
							return $('#email').val();
						}
					}
				}
			},
			username : {
				required : true,
				rangelength : [ 2, 8 ]
			},
			password : {
				required : true,
				rangelength : [ 8, 16 ]
			},
			repassword : {
				required : true,
				equalTo : '#password'
			}
		},
		messages : {
			email : {
				required : "이메일을 입력해 주세요.",
				email : "올바른 이메일을 입력해 주세요.",
				remote : "중복된 아이디입니다."

			},
			name : {
				required : "이름을 입력해 주세요.",
				rangelength : "이름은 {0}자에서 {1}자까지 사용 가능합니다."
			},
			password : {
				required : "비밀번호를 입력해 주세요.",
				rangelength : "비밀번호는 {0}자에서 {1}자까지 사용 가능합니다."
			},
			repassword : {
				required : "비밀번호 확인을 입력해주세요.",
				equalTo : "비밀번호와 동일하게 입력해 주세요."
			}
		},
		submitHandler : function() { // 유효성 검사를 통과시 전송
			joinForm.submit();
			console.log("submitHandler >>> function");
		},
		success : function(e) {
			//
		}
	});// end validate()
});
