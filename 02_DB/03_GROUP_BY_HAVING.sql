SELECT DEPT_CODE FROM EMPLOYEE ; --23행 조회
SELECT SUM(SALARY) FROM EMPLOYEE ; -- 1행 조회

-- SELECT DEPT_CODE , SUM(SALARY)  FROM EMPLOYEE 
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
-- DB에서 정의하는 표의 모양이 아니다. 두 개를 붙여 놓으면 표의 모양이 아니게 된다.

-- 부서별 급여 합 조회
SELECT DEPT_CODE , SUM(SALARY) -- 3) 그룹별 SALARY 합계를 조회
FROM EMPLOYEE -- 1) EMPLOYEE 테이블에서
GROUP BY DEPT_CODE ; -- 2) DEPT_CODE가 같은 행 끼리 그룹을 지어

-- DEPT_CODE 끼리 먼저 그룹을 만든 후, DEPT_CODE와 SALARY 조회



/*
 * 
5 : SELECT 컬럼명, 함수, 계산식, 리터럴  [[AS] 별칭]
1 : FROM 테이블명
2 : WHERE 조건식
3 : GROUP BY 그룹으로 묶을 칼럼명|함수 
4 : HAVING 그룹함수를 이용한 조건식(GROUP BY가 있어야 작성 가능)
6 : ORDER BY 컬럼명|별칭|조회컬럼 순서 정렬방식 [NULLS FIRST | LAST]

 */


-- GROUP BY 절 : 같은 값들이 여러 개 기록된 행을 하나의 그룹으로 묶음
-- 부서별 급여 평균
SELECT DEPT_CODE , ROUND(AVG(SALARY), 1) "부서별 평균" 
FROM EMPLOYEE 
GROUP BY DEPT_CODE 
ORDER BY DEPT_CODE ;


-- 부서별 급여합, 급여평균, 인원 수, 최고참 입사일, 막내 입사일
SELECT DEPT_CODE , SUM(SALARY) 급여합, ROUND(AVG(SALARY)) 급여평균, COUNT(*), 
					MIN(HIRE_DATE) "최고참 입사일", MAX(HIRE_DATE) "막내 입사일"  
FROM EMPLOYEE 
GROUP BY DEPT_CODE 
ORDER BY DEPT_CODE ;


-- 각 직급코드별로 보너스를 받는 사원의 수를 조회
-- 직급코드 오름차순
SELECT JOB_CODE  ,COUNT(BONUS) 
FROM EMPLOYEE 
GROUP BY JOB_CODE 
ORDER BY JOB_CODE  ;


-- EMPLOYEE 테이블에서 성별과, 성별 별 급여 평균(내림처리), 급여 합, 인원 수 조회
-- 인원 수 오름차순 정렬

SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '여') 성별, FLOOR(AVG(SALARY)) "급여 평균", SUM(SALARY) "급여 합", COUNT(*) "인원 수" 
FROM EMPLOYEE 
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '여')
ORDER BY "인원 수" DESC ;
-- GROUP BY 절에 함수도 사용 가능하다
-- SELECT 절 해석이 되지 않아 성별 별칭 사용 불가능


-- WHERE + GROUP BY 
-- WHERE 절이 GROUP BY 절 보다 우선 순위가 빠르다

-- EMPLOYEE 테이블에서 부서코드가 'D5', 'D6'인 부서의 평균 급여 조회
SELECT DEPT_CODE , ROUND(AVG(SALARY)) "부서 평균 급여" -- 4) DEPT_CODE 와 급여 평균 조회
FROM EMPLOYEE -- 1) EMPLOYEE 테이블에서
WHERE DEPT_CODE IN ('D5', 'D6') -- 2) 부서코드가 D5, D6인 행만 추려서ㅓ
GROUP BY DEPT_CODE  --3) 추려진 결과 내에서 부서코드 별로 그룹을 지어
ORDER BY DEPT_CODE ;

-- EMPLOYEE 테이블에서 직급별 2000년도 이후 입사자들의 급여 합 조회 (2000년 이상)
SELECT JOB_CODE 직급, SUM(SALARY) "급여 합"
FROM EMPLOYEE 
WHERE EXTRACT (YEAR FROM HIRE_DATE) >= 2000
-- WHERE HIRE_DATE >= TO_DATE('2000-01-01')
GROUP BY JOB_CODE 
ORDER BY JOB_CODE ;


------------------------------------------------------------------

--  * 그룹 내 그룹(소규모 그룹) 만들기 *
-- EMPLOYEE 테이블에서 부서별로 같은 직급인 사원의 급여합을
-- 부서코드 오름차순으로 조회
SELECT DEPT_CODE , JOB_CODE , SUM(SALARY)
FROM EMPLOYEE 
GROUP BY DEPT_CODE, JOB_CODE 
ORDER BY DEPT_CODE ;
-- GROUP BY 큰 그룹, 작은 그룹

-- EMPLOYEE 테이블에서 부서 별로 급여 등급(SAL_LEVEL)이 같은 직원 수를 부서코드 오름차순, 급여 등급 내림차순으로 조회
SELECT DEPT_CODE , SAL_LEVEL , COUNT(*)
FROM EMPLOYEE 
GROUP BY DEPT_CODE , SAL_LEVEL 
ORDER BY DEPT_CODE , SAL_LEVEL DESC ;

------------------------------------------------------------------

-- * HAVING 절 : 그룸 함수로 조회할 그룹에 대한 조건을 설정할 때 사용

-- 부서별 평균급여가 300백만원 이상인 부서를 조회
/*4*/SELECT DEPT_CODE , AVG(SALARY) 
/*1*/FROM EMPLOYEE 
/*2*/GROUP BY DEPT_CODE 
/*3*/HAVING AVG(SALARY) >= 3000000
/*5*/ORDER BY 1; 

-- 부서별 급여가 300만 이상인 사원들의 평균 급여를 조회
SELECT DEPT_CODE , AVG(SALARY)
FROM EMPLOYEE 
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE
ORDER BY 1;

-- WHERE 절과 HAVING 절의 차이
-- WHERE : 테이블의 모든 행에 조건을 대입
-- HAVING : GROUP BY에서 묶인 그룹에 조건을 대입


-- 부서별 급여 합이 900만을 초과하는 부서의 부서코드 ,급여합, 인원 수 조회
SELECT DEPT_CODE , SUM(SALARY), COUNT(*)
FROM EMPLOYEE 
GROUP BY DEPT_CODE 
HAVING SUM(SALARY) > 9000000
ORDER BY 1;

-- EMPLOYEE 테이블에서 부서별 70년대생의 급여 평균이 300만 이상인 부서를 찾아
-- 부서코드, 평균 급여(소수점 내림)을 부서코드 내림차순으로 조회
SELECT DEPT_CODE, FLOOR(AVG(SALARY)) "평균 급여"
FROM EMPLOYEE 
WHERE SUBSTR(EMP_NO, 1,2) BETWEEN 70 AND 79
-- WHERE SUBSTR(EMP_NO, 1, 1) = 7;
GROUP BY DEPT_CODE 
HAVING AVG(SALARY) >= 3000000
ORDER BY 1 DESC ;

------------------------------------------------------------------
-- 집계함수
-- GROUP BY 절에 작성하여 그룹별로 산출한 결과를 집계하는 함수
-- ROLLUP과 CUBE 가 있음


-- ROLL UP : 그룹별로 중간 집계와 전체 합계를 처리하는 함수
-- EMPLOYEE 테이블에서 각 부서에 소속된 직급별 급여 합, 부서별 급여 합, 전체 직원의 급여 합을 조회
SELECT DEPT_CODE , JOB_CODE , SUM(SALARY)
FROM EMPLOYEE 
GROUP BY ROLLUP(DEPT_CODE , JOB_CODE)
ORDER BY 1;

-- CUBE : 그룹으로 지정된 모든 그룹에 대한 중간 집계와 총 합계를 처리하는 함수
SELECT DEPT_CODE , JOB_CODE , SUM(SALARY)
FROM EMPLOYEE 
GROUP BY ROLLUP(DEPT_CODE , JOB_CODE)
ORDER BY 1;
-- +
SELECT JOB_CODE , SUM(SALARY)
FROM EMPLOYEE 
GROUP BY JOB_CODE 
ORDER BY JOB_CODE ;
-- ==> 큐브
SELECT DEPT_CODE , JOB_CODE , SUM(SALARY)
FROM EMPLOYEE 
GROUP BY CUBE(DEPT_CODE , JOB_CODE)
ORDER BY 1;

------------------------------------------------------------------


---** SET OVERATION ( 집합 연산 ) **
-- 두 개 이상의 SELET 결과(RESULT SET)을 이용해 하나의 결과를 조회하는 연산자
-- 조건에 따른 SELECT 결과가 다른 경우 많은 SELECT를 한 번에 조회할 때 유용
-- **주의사항** : 집합 연산에 사용되는 SELECT문은 SELECT절의 타입, 순서, 개수가 동일해야 한다

-- UNION : 합집합
-- INTERSECT : 교집합
-- UNION ALL : 합집합 + 교집합
-- MINUS : 차집합

-- UNION 확인
-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
-- 6행 조회
UNION -- 둘 다 합한 후 중복되는 2행 제거
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY > 3000000;
-- 8행 조회


-- INTERSECT 교집합 확인
-- 부서코드가 'D5'이고 급여가 300만 초과인 사람의 사번, 이름, 부서코드, 급여 조회
-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
-- 6행 조회
INTERSECT 
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY > 3000000;
-- 8행 조회



-- UNION ALL 확인
-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
-- 6행 조회
UNION ALL
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY > 3000000;
-- 8행 조회




-- MINUS 확인
-- 부서코드가 D5이지만, 연봉 300만 초과인 사람은 제외
-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
-- 6행 조회
MINUS
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE 
WHERE SALARY > 3000000;
-- 8행 조회

-- 집합 연산은 2개 이상의 SELECT 문에 사용 가능
-- D5,D6먼저 UNION하고 그 결과를 D9와 계산
SELECT EMP_NAME , DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_NAME , DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D6'
UNION
SELECT EMP_NAME , DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9'

UNION 

-- SELECT 절의 타입, 개수, 순서가 동일해야 한다
SELECT '이름', '부서코드' FROM DUAL;
-- 테이블은 달라도 타입, 개수, 순서가 같으니 하나로 쓸 수 있음





------------------------------------------------------------------












