$(document).ready(function() {
		  $('#goRight').on('click', function(){
		    $('#slideBox').animate({
		      'marginLeft' : '0'
		    });
		    $('.topLayer').animate({
		      'marginLeft' : '100%'
		    });
		  });
		  $('#goLeft').on('click', function(){
		    if (window.innerWidth > 769){
		      $('#slideBox').animate({
		        'marginLeft' : '50%'
		      });
		    }
		    else {
		      $('#slideBox').animate({
		        'marginLeft' : '20%'
		      });
		    }
		    $('.topLayer').animate({
		      'marginLeft': '0'
		    });
		  });
		  
		  $('#loginCheck').click(function() {
				var email = $('#email').val();
				var password = $('#password').val();
				// 이메일이나 비밀번호 미입력시 validation
				if ($('#email').val() == "" || $('#password').val() == "") {
					$('#loginForm').submit();
				} else {
					$.ajax({
						type : "POST",
						url : '/loginCheck',
						data : {
							email : email,
							password : password
						},
						success : function(data) {
							if (data == "true") {
								$('#loginForm').submit();
							} else if (data == "false") {
								$('#auth_error').css('display', 'none');
								$('#error').css('display', 'block');
							} else if (data == "noauth") {
								$('#error').css('display', 'none');
								$('#auth_error').css('display', 'block');
							}
						}
					});
				}
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
		  
		});

