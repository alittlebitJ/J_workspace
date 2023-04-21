<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL조건문</title>
</head>
<body>
    <h1>4. 조건문 - if (c:if 태그)</h1>
    <pre>
    - 단독 if문 (else 구문이 없음)
    - 속성은 test만 존재함
    *** 주의 사항 ***
    1) test의 속성 값은 무조건 EL구문으로 작성되어야 한다
    2) test의 속성 값은 true 또는 false가 나오는 조건식이여야 한다
    3) test의 속성 값을 작성하는 "" 내부에는 앞뒤 공백이 존재해서는 안 된다
    </pre>


    request에 세팅된 name : ${name} <br> <%-- 홍길동 --%>
    request에 세팅된 money : ${money} <br> <%-- 50000원 --%>

    <c:if test="${money == 40000}" >
      <h3 style="color:gold">돈이 5만원이 있습니다.</h3>
    </c:if>


    <%-- EL에서 모든 비교는 == 또는 eq / != 또는 ne라고 함 --%>
    <%-- EL에서 문자열은 ''(홑따옴표)로 표현 --%>
    <c:if test="${name eq '홍길동'}">
      <h3 style="color:gold">이름이 일치합니다</h3>
    </c:if>

    <hr>
    <h1>5. 조건문 - choose, when, otherwise (if ~ else if ~ else) </h1>
    <pre>
        choose : when, otherwise 태그를 감싸는 태그
                 이 안에 if ~ else 를 쓰겠다
        when : if, else if 역할의 태그
               속성은 test 밖에 없음
        otherwise(그렇지 않으면) : else 역할, 속성 x 
    </pre>

    <%-- queryString : 주소에 작성된 파라미터 문자열 --%>
    <%-- http://localhost/jstl/condition?val=777 --%>
    <%-- queryString 바꿔가면서 테스트 --%>
    ${param.val} <br>




<%-- 
    lt (little) : < 미만
    gt (greater) : > 초과

    le (little or equal) : <= 이하
    ge (greater or equal) : >= 이하
 --%>    

    <c:choose>
       <c:when test="${param.val gt 100}"> <%-- 100초과 --%>
        100초과
       </c:when>
       <c:when test="${param.val lt 100}">
        100 미만
        </c:when>
       <c:otherwise>
        100과 같다
       </c:otherwise>
    </c:choose>


    

</body>
</html>