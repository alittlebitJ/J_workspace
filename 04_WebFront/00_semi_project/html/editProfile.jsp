<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit profile</title>
    <link rel="stylesheet" href="/00_semi_project/css/login_editProfile.css">
    <link rel="stylesheet" href="/00_semi_project/css/myPettitions.css">
</head>
<body>
    <main>
        <header>
            <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        </header>
        <form action="#" method="get">
            <div class="content" id="editProfile">
                <div class="contentbox" id="editProfileContainer">
                    <div class="edeit-profile-top-frame">
                        <div class="row">
                            <div id="editProfileTitle">프로필 편집</div>
                        </div>
                    </div>
                    <div>
                        <div id="imageContainer"></div>
                    </div>
                    <div>
                        <label class="upload-photo">Upload photo</label>
                    </div>
                    <div id="editPrifileNameFrame">
                        <label class="edit-profile-text">닉네임</label>
                        <div id="editProfileInputName">
                            <input type="text" class="edit-profile-input" placeholder="홍길동">
                            <button class="edit-profile-btn" type="button">중복확인</button>
                        </div>
                    </div>
                    <div>
                        <label class="edit-profile-text">자기소개</label>
                        <textarea id="editProfileDescription" placeholder="자신기자신에 대한 짧은 소개를 적어주세요"
                        row="6" maxlength="255"></textarea>
                    </div>
                    <div>
                        <label class="edit-profile-text">지역</label>
                        <div id="editProfileInputName">
                            <input type="text" id="sample6_address" class="edit-profile-input">
                            <button class="edit-profile-btn" type="button" onclick="sample6_execDaumPostcode()">주소찾기</button>
                        </div>
                    </div>
                    <div>
                        <label class="edit-profile-text">상세주소</label>
                        <div id="editProfileInputName">
                            <input type="text" class="edit-profile-input-long" id="sample6_detailAddress" placeholder="2층 KH 정보교육원 종로지원">
                        </div>
                    </div>
                    <div id="goRight">
                        <div class="submit-cancel-button-frame">
                            <button id="submit" class="submit-cancel-button">저장</button>
                            <button id="cancel" class="submit-cancel-button">취소</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <footer>
            <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        </footer>
    </main>    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
    
                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }
                    // 주소 정보를 해당 필드에 넣는다.
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").removeAttribute('placeholder');
                    document.getElementById("sample6_detailAddress").focus();

                }
            }).open();
        }
    </script>
</body>
</html>