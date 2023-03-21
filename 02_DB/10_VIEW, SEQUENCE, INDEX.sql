
/**
 * [VIEW]
 * 
 * - 논리적 가상 테이블 -> 테이블 모양을 하고는 있지만, 실제로 값을 저장하고 있진 않음.
 * - SELECT문의 실행 결과 (RESULT SET)를 저장하는 객체
 * 
 * ** VIEW의 사용 목적 **
 * 1) 복잡한 SELECT문을 쉽게 재사용하기 위해
 * 2) 테이의 진 모습을 감출 수 있어 보안상 유리
 * 
 * ** VIEW 사용 시 주의 사항 **
 * 1) 가상의 테이블(실체가 없음)이기 때문에 ALTER 구문 사용 불가
 * 2) VIEW를 이용한 DML(INSERT, UPDATE, DELETE)이 가능한 경우도 있지만, 제약이 많이 따르기 때문에 
 *    조회(SELECT) 용도로만 대부분 사용→ VIEW를 가지고 웬만하면 DML을 하지 말라
 * 
 * **  VIEW 작성법 **
 * CREAT [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [컬럼 별칭] 
 * AS 서브쿼리(SELECT문)
 * [WITH CHECK OPTION]
 * [WITH READ ONLY]
 * 
 *  
 * 1) OR REPLACE 옵션 : 기존에 동일한 이름의 VIEW가 존재하면 이를 변경, 없으면 새로 생성
 * 2) FORCE | NOFORCE 옵션 : 데이터베이스 이관, 업그레드 할 때 많이 사용
 *	   - FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성 , 
 *				SELECT문 안에 FROM TABLE에서 TABLE이 실재로 존재하지 않는 것을 사용했을 때
 *	   - NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성, 기본값
 * 3) 컬럼 별칭 옵션 : 조회되는 VIEW의 컬럼명을 지정
 * 4) WITH CHECK OPTION 옵션 : 옵션을 지정한 컬럼의 값을 수정 불가능하게 함.
 * 5) WITH READ ONLY 옵션 : 뷰에 대해 SELECT만 가능하도록 지정
 * 
 */

SELECT EMP_ID 사번 FROM EMPLOYEE; 

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 부서명, 직급명 조회
SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME
FROM EMPLOYEE 
NATURAL JOIN JOB 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);


CREATE VIEW V_EMP AS
SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME
FROM EMPLOYEE 
NATURAL JOIN JOB 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- ORA-01031 : 권한이 불충분합니다


-- ** VIEW 생성 권한 얻는 법 **
-- > SYS계정으로 접속 후
-- ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE; 실행
-- > 각자 계정에 CREATE VIEW 권한 부여
-- GRANT CREAT VIEW TO kh_kjm; 실행
-- 다시 KH 계정으로 접속해서 VIEW 생성 구문 수행

-- 생성된 VIEW를 이용해서 조회
SELECT * FROM V_EMP;

-- V_EMP 뷰 수정하기(ALTER가 아니라 REPLACE를 이야기 함)
CREATE OR REPLACE VIEW V_EMP 
AS SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, JOB_NAME 직급명
	FROM EMPLOYEE 
	NATURAL JOIN JOB 
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); 

SELECT * FROM V_EMP;

-- V_EMP에서 직급이 대리인 사원의 정보 조회
SELECT *
FROM V_EMP 
WHERE 직급명 = '대리'; -- 이미 V_EMP에서 컬럼명이 '직급명'으로 되어 있으니 WHERE절도 별칭인 '직급명'으로 작성해야


-----------------------------------------------------------------------------------------------------------

/*
 * ** VIEW를 이용한 DML **
 * */

-- 테이블 복사
CREATE TABLE DEPT_COPY2 
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2에서 DEPT_ID, LOCATION_ID 컬럼만 조회하는 VIEW 생성
CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID 
   FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

-- VIEW를 이용한 INSERT 
INSERT INTO V_DCOPY2
VALUES ('D0', 'L3');

-- INSERT 확인
SELECT * FROM V_DCOPY2; -- 삽입 완료 처럼 보임. 근데 이 값이 VIEW에 저장된 것인가?
-- VIEW는 값을 저장하지 않는다고 했는데...
-- 저장 된 것 처럼 보인다.
-- > 실제 VIEW에 저장된 것이 아니라 VIEW를 생성할 때 사용한 서브쿼리의 테이블(DEPT_COPY2)에 값이 삽입되어 있다.

-- 원본 테이블 (DEPT_COPY2) 확인
SELECT * FROM DEPT_COPY2;
-- D0, NULL, L3
--> 원본 테이블에 삽입됨을 확인
--> INSERT 구문에 포함되지 않은 DEPT_TITLE 컬럼은 NULL이 삽입되어 있다

ROLLBACK;

SELECT * FROM V_DCOPY2;
-- 복사한 테이블(DEPT_COPY2)의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가

ALTER TABLE DEPT_COPY2 MODIFY DEPT_TITLE CONSTRAINT NN_DEPT_TITLE NOT NULL; 

-- 다시 VIEW를 이용해서 INSERT 
INSERT INTO V_DCOPY2 
VALUES ('D0', 'L3');
-- SQL Error [1400] [23000]: ORA-01400: NULL을 ("KH_KJM"."DEPT_COPY2"."DEPT_TITLE") 안에 삽입할 수 없습니다
-- 원본 테이블 DEPT_ID, LOCAITION_ID 컬럼에 'D0', 'L3' 삽입, DEPT_TITLE 컬럼에는 NULL이 삽입
----> 그러나 DEPT_TITLE 컬럼에는 NOT NULL 제약조건이 설정되어 NULL값이 삽입될 수 없음,

-- 데이터 무결성 : 중복X, NULLX -> 신뢰도 높은 데이터
-- > 대부분의 컬럼에 NOT NULL 제약조건이 추가되어 있음
----> NOT NULL이 설정된 테이블을 이용해서 VIEW를 만들면 ISNERT가 거의 불가능함
-----> 결론 : VIEW를 가지고 DML을 수행하는 행동을 지양해라

-----------------------------------------------------------------------------------------------------------

CREATE OR REPLACE VIEW V_DCOPY2 
AS SELECT * FROM DEPT_COPY2; 
-- 읽기전용 아직 아님. VIEW 변경 (DEPT_TITLE 포함)

INSERT INTO V_DCOPY2 
VALUES ('D0', '기획팀', 'L3');
-- 오류 없이 삽입된 것 확인

ROLLBACK;

CREATE OR REPLACE VIEW V_DCOPY2 
AS SELECT * FROM DEPT_COPY2
WITH READ ONLY; 
-- 읽기 전용 옵션 추가

INSERT INTO V_DCOPY2 
VALUES ('D0', '기획팀', 'L3');
-- 다시 INSERT 시도 
-- SQL Error [42399] [99999]: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

SELECT * FROM V_DCOPY2 ;


-----------------------------------------------------------------------------------------------------------


/*
 * SEQUENCE(순서, 연속)
 * -- 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체(번호 생성기)
 * 
 * ** SEQUENCE 왜 사용할까? **
 * PRIMARY KEY(기본키) : 테이블 내 각 행을 구별하는 식별자 역할. NOT NULL + UNIQUE의 의미를 가짐
 * 
 *   [작성법]
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
 * 
 * ** 사용법 **
 * 
 * 1) 시퀀스명.NEXTVAL : 다음 시퀀스 번호(INCREMENT BY 만큼 증가된 수)를 얻어온다.
 * 						단, 생성 후 처음 호출된 시퀀스인 경우 START WITH에 작성된 값이 반환
 * 2) 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어옴.
 * 						단, 시퀀스가 생성 되자마자 호출할 경우 오류 발생.
 * 						⇒ 마지막으로 호출한 NEXTVAL 값을 반환
 * */


-- 테이블 생성
CREATE TABLE TB_TEST (
	TEST_NO NUMBER PRIMARY KEY,
	TEST_NAME VARCHAR2(30) NOT NULL
);
SELECT * FROM TB_TEST;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100 			-- 100번부터 시작
INCREMENT BY 5			-- 5씩 증가
MAXVALUE 150			-- 최대값 150
NOMINVALUE				-- 최소값 없음
NOCYCLE					-- 반복 없음
NOCACHE;				-- 미리 만들어 두는 숫자 없음


-- 시퀀스 생성 확인
SELECT SEQ_TEST_NO.CURRVAL FROM DUAL;
-- SQL Error [8002] [72000]: ORA-08002: 시퀀스 SEQ_TEST_NO.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다
-- 시퀀스 생성 후 한 번도 NEXTVAL을 호출하지 않아서 이 문제 발생


SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;
SELECT SEQ_TEST_NO.CURRVAL FROM DUAL;
-- NEXTVAL을 실행시키고 나니 CURRVAL이 조회 됨

SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 105
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 110
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 115
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 120

SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 120



-- TB_TEST에 값 삽입
INSERT INTO TB_TEST VALUES (SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );

-- 들어간 값 확인
SELECT * FROM TB_TEST; -- 125, 홍길동125

-- INSERT 추가 수행
INSERT INTO TB_TEST VALUES (SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );
SELECT * FROM TB_TEST; -- 130, 홍길동130
INSERT INTO TB_TEST VALUES (SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );
SELECT * FROM TB_TEST; -- 135, 홍길동135
INSERT INTO TB_TEST VALUES (SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );
SELECT * FROM TB_TEST; -- 140, 홍길동140

-- UPDATE에 SEQUENCE TKDYD
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
-- WHERE TEST_NO = (SELECT * FROM (SELECT TEST_NO FROM TB_TEST ORDER BY TEST_NO DESC) WHERE ROWNUM = 1);
-- 밑의 방식으로 실행 시 범위설정이 가능해 확장성 유용

-- UPDATE 확인
SELECT * FROM TB_TEST; -- 140, 홍길동140 -> 145, 고길동145


UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
SELECT * FROM TB_TEST; -- 145, 고길동145 -> 150, 고길동150

UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
-- SQL Error [8004] [72000]: ORA-08004: 시퀀스 SEQ_TEST_NO.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
-- SEQUENCE MAXVALUE 초과


-----------------------------------------------------------------------------------------------------------


-- SEQUENCE 변경 (ALTER)


/*
 *   [작성법]
  ALTER SEQUENCE 시퀀스이름
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
  
  ** 시작값은 ALTER로 수정 불가능. CREATE에서만 설정 가능(START WITH 사용 불가) **
  
   */

-- SEQ_TEST_NO의 증가값을 1로, 최대값을 155로 수정
ALTER SEQUENCE SEQ_TEST_NO 
INCREMENT BY 1
MAXVALUE 155;

UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

SELECT * FROM TB_TEST; -- 151, 고길동151


-----------------------------------------------------------------------------------------------------------


-- VIEW, SEQUENCE 삭제
DROP VIEW V_DCOPY2 ;
SELECT * FROM V_DCOPY2;
-- SQL Error [942] [42000]: ORA-00942: 테이블 또는 뷰가 존재하지 않습니다

-- SEQUENCE 삭제
DROP SEQUENCE SEQ_TEST_NO;
-- SEQUENCE 는 START WITH를 변경하고 싶으면 삭제 후 다시 생성해야 한다.




-----------------------------------------------------------------------------------------------------------


/*
 * INDEX (색인)
 * 
 * -- SQL 구문 중 SELECT 처리 속도를 향상 시키기 위해 컬럼에 대하여 생성하는 객체
 * -- 인덱스 내부 구조는 B* 트리 형식으로 되어있음(BINARY / 2진)
 * 
 * ** INDEX 의 장점 **
 * -- 이진 트리 정식으로 구성되어 자동 정렬 및 검색 속도 증가
 * -- 조회 시(SELECT) 테이블의 전체 내용을 확인하며 조회하는 것이 아닌 
 *    인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에, 시스템의 부하가 낮아짐
 * 
 * ** INDEX 의 단점 **
 * -- 데이터 변경(INSERT, UPDATE, DELETE) 작업 시 이진 트리 구조에 변형이 일어남
 * 	  -> DML 작업이 빈번한 경우 시스템 부하가 늘어 성능 저하됨
 * -- 인덱스도 하나의 객체이다 보니 별도 저장 공간이 필요(메모리 소비) 
 * -- 인덱스 생성 시간이 필요함
 * 
 * 
 * [작성법]
 * CREATE [UNIQUE] INDEX 인덱스명 
 * ON 테이블명  (컬럼명 [, 컬럼명 | 함수명 | 계산식]) 
 * 
 * 삭제 : DROP INDEX 인덱스명
 * 
 * ** 인덱스가 자동 생성되는 경우 **
 * -> PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해 UNIQUE INDEX가 자동 생성된다
 * 
 * */

-- INDEX를 사용하지 않은 검색
SELECT * FROM EMPLOYEE 
WHERE EMP_NAME != '0';

-- INDEX를 사용한 검색
-- 사용 방법 : WHERE에 INDEX가 설정된 컬럼을 언급
SELECT * FROM EMPLOYEE 
WHERE EMP_ID != '0';

--> 데이터가 너무 적어서 유의미한 차이 식별 불가


-- 인덱스 확인용 테이블 생성
CREATE TABLE TB_INDEX_TEST(
	TEST_NO NUMBER PRIMARY KEY, -- UNIQUE INDEX 자동 생성
	TEST_ID VARCHAR2(20) NOT NULL
);

SELECT * FROM TB_INDEX_TEST;

-- TB_INDEX_TEST 테이블에 샘플 데이터 100만개 삽입
-- (PL/SQL 사용 : SQL을 이용한 절차적 언어)

BEGIN
	FOR I IN 1.. 1000000
	LOOP 
		INSERT INTO TB_INDEX_TEST VALUES (I, 'TEST' || I);
	END LOOP;
	COMMIT;
END;


-- 인덱스를 사용하지 않고 조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_ID = 'TEST500000'; -- 48ms

-- 인덱스를 사용하고 조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_NO = 500000; -- 5ms

-- TEST_ID 컬럼에 대한 인덱스 생성
CREATE INDEX IDX_TEST_ID 
ON TB_INDEX_TEST (TEST_ID);

-- 인덱스 생성 후 조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_ID = 'TEST500000'; -- 25ms



-----------------------------------------------------------------------------------------------------------



-- 인덱스 삭제
DROP INDEX IDX_TEST_ID;

-- 테스트용 테이블 삭제
DROP TABLE TB_INDEX_TEST; -- 테이블을 지우면 연관된 INDEX도 자동으로 삭제되기는 함


-----------------------------------------------------------------------------------------------------------



SELECT EMP_ID , EMP_NAME , NVL(DEPT_TITLE, '없음'), JOB_NAME, NVL(PHONE, '없음')
FROM EMPLOYEE 
NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE EMP_ID = 200
ORDER BY EMP_ID ;




	SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY 
	FROM EMPLOYEE 
	NATURAL JOIN JOB 
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	WHERE SALARY BETWEEN 2000000 AND 3000000
	ORDER BY SALARY DESC ;


-- 사번 생성 시퀀스 (223번 시작)
CREATE SEQUENCE SEQ_EMP_ID 
START WITH 223
INCREMENT BY 1
NOCYCLE
NOCACHE

-- SEO_EMP_ID.NEXTVAL : 다음 번호 생성
-- SEO_EMP_ID.CURRBAL : 현재 번호 조회
;



INSERT INTO EMPLOYEE 
VALUES ()
;

UPDATE EMPLOYEE 
SET EMAIL = ?,
	PHONE  = ?,
	SALARY  = ?
WHERE EMP_ID = ?
;

SELECT EMP_ID , EMP_NAME , PHONE , EMAIL , SALARY  FROM EMPLOYEE;

-- 7번 확인을 위한 코드
SELECT EMP_ID, EMP_NAME , ENT_YN , ENT_DATE 
FROM EMPLOYEE 
WHERE EMP_ID = 223;


UPDATE EMPLOYEE
SET ENT_YN = 'N',
	ENT_DATE = NULL 
WHERE EMP_ID = 200;

