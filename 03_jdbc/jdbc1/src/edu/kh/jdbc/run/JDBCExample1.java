package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {
	
	public static void main(String[] args) {
		
		// JDBC : Java에서 DB에 연결(접근)할 수 있게 해주는 코드(Class, interface)를 제공해 주는 것(Java Programming API)
		// 		  java.sql 패키지에서 제공
		
		
		/*
		 * ** JDBC를 이용한 애플리케이션 제작 시 필요한 것 **
		 * 1. Java의 JDBC 관련 인터페이스
		 * 2. DBMS의 종류 (Oracle)
		 * 3. DBMS 회사에서 제공하는 라이브러리(Java 애플리케이션과 DB 연결을 위한)
		 *    -> ojdbc11.jar → OracleDriver.class
		 */
		
		// 코드를 짜는 과정
		// 1단계 : JDBC 객체 참조 변수 선언
		
		Connection conn = null;
		// DB 연결 정보를 담는 객체
		// -> Connection을 상속 받아 구현한 자식 객체가 대입될 예정
		
		// DBMS 이름, 타입, IP, PORT, 계정명, 비밀번호 저장
		// -> DBeaver의 계쩡 접속 방법 추가와 유사함
		// DBMS 마다 상속받아 구현해야 함
		// (각각 종류마다 계정 접속 방법이 다르기 때문)
		
		
		// 왜 Connection은 인터페이스일까??
		// -> DBMS마다 연결 정보, 방법이 다르기 때문에 상속을 받아 공통된 부분을 DBMS마다 알맞게 구현하고
		//	  구현된 객체를 Java에서 참조해서 사용
		
		Statement stmt = null;
		// The object used for executing a static SQL statementand returning the results it produces.
		// sql을 DB에 전달해 수행하고, 결과(ResultSet 또는 DML 성공 행의 개수)를 반환 받는 데에 사용되는 객체
		
		
		ResultSet rs = null;
		// The object used for executing a static SQL statementand returning the results it produces. 
		// SELECT 질의 성공 시 반환되는 객체
		// 조회 결과의 집합을 나타냄 -> 테이블 모양으로 반환됨
		// -> ResultSet 객체를 이용해서 1행씩 접근
		// -> 더 이상 접근할 행이 없을 경우 false 반환
		
		// 연걸 정보를 이용해 어디있는지 확인, statement 를 통해 전달, 결과를 반환받음. 그 결과는 resultset을 통해 반환
		
		
		try {
			// 2단계 : 1단계에서 선언한 참조 변수에 알맞은 객체 대입
			// 1. DB 연결에 필요한 Oracle JDBC Driver 객체를 메모리에 로드하기(OracleDriver.class를 객체로 만들어 주기)
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
			// -> 객체를 만드는 구문
			// -> ()안에 작성된 경로에 존재하는 클래스를 이용해 객체를 생성
			// -> 메모리에 객체가 생성되고, Connection을 이용한 DB연결 시 이를 자동으로 참조
			
			// ClassNotFoundException의 가능성이 있음 
			// 오타 또는 라이브러리 추가 x 시 발생
			
			
			// 2. DB 연결 정보를 담은 Connection 객체 생성
			// -> DriverManager를 이용해서 생성함!
			
			// DB 연결을 위한 정보를 변수에 저장
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			
			String ip = "115.90.212.22";
			// localhost (127.0.0.1)

			String port = ":9000";
			// :1521 <- localhost일 시
			
			String dbName = ":XE";
			// DB이름(비슷한 단어론 SID) ,local 의 경우 19c버전 : ORCL / 18c또는 강의장db : xe
			
			String user = "kh_kjm";
			// 계정 명
			
			String pw = "oracle_kjm123A";
			// 비밀번호
			
			
			
			// DriverManager 
			// - 메모리에 로드된 JDBC 드라이버 객체를 이용해 DB에 접근하고, 작성된 정보를 이용해 DB와 연겱나능한 Connection 객체를 만들어 얻어오는 역할을 하는 객체
			
			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			
//			System.out.println(conn);
			// -> 정상적으로 작성한 경우 conn 객체의 주소가 출력(oracle.jdbc.driver.T4CConnection@6c40365c)
			// -> 잘못 작성한 경우 예외 발생
			// Drivemanager로 인해 java에서 db로 향하는 통로(Connection)가 만들어졌다
			
			// 3. SQL 작성
			// ** Java에서 작성되는 SQL은 마지막에 세미콜론(;)을 작성하지 않는다 **
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE";
			
			// 4. Ststement 객체 생성
			// -> DB에 SQL 전달 후 수행 -> 결과를 반환 받음
			// 통로에서 sql문을 그냥 db로 보내고 받는게 아니라 statement로 감싸서 보내고 받아야 한다.
			// --> Connection 내부에 생성되어 DB와 통신하는 역할
			
			stmt = conn.createStatement(); // create객체가 생성됨
			
			
			
			
			// 5. Statement객체를 통해 SQL문(SELECT문)을 수행하고 결과(ResultSet)를 반환 받아 와서 저장(ResultSet rs 변수)
			
			rs = stmt.executeQuery(sql);
			// executeQuery() : SELECT 문을 수행하는 메서드. 결과로 ResultSet을 반환 -> rs에 저장 가능
			
			
			// 3단계 : SQL 수행 결과로 반환 받는 ResultSet을 첫 번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력
			// 결과값마다 행의 개수가 다르기 때문에 for문 보단 while문 사용
			
			while (rs.next()) {
				// 조건식의 결과가 true일 때 반복
				
				// rs.next() : 커서를 다음 행으로 이동 후 행이 존재하면 true 존재하지 않으면 false를 반환
				// - ResultSet 객체는 조회 결과를 한번에 테이블로 다루는 것이 아닌, 커서를 이용해 1행씩만 접근
				
				// ** 현재 접근한 행의 컬럼 값을 얻어와 출력 ** 
				// rs.get자료형(컬럼명|컬럼순서)
				
				// [Java]				[DB]
				// String				CHAR, VARCHAR2
				// int, long			NUMBER (정수만)
				// float, double		NUMBER (실수만)
				// java.sql.Date		DATE
			
				String empId = rs.getString("EMP_ID");
				// 현재 커서가 접근한 행의 "EMP_ID"컬럼의 값을 얻어와 String으로 반환
				
				String empName = rs.getString("EMP_NAME");
				// 현재 커서가 접근한 행의 "EMP_NAME"컬럼의 값을 얻어와 String으로 반환
				
				int salary = rs.getInt("SALARY");
				// 현재 커서가 접근한 행의 "SALARY"컬럼의 값을 얻어와 int로 반환
				
				Date hireDate = rs.getDate("HIRE_DATE");
//				java.sql.Date hireDate = rs.getDate("HIRE_DATE");
				// 현재 커서가 접근한 행의 "HIRE_DATE"컬럼의 값을 얻어와 Date 타입으로 반환
				
				System.out.printf("사번 : %s / 이름 : %s / 급여 : %d / 입사일 : %s \n",
						empId, empName, salary, hireDate.toString());
				// Date 는 년도를 2023-03-17형식으로 toString 오버라이딩 되어 있음
			} // while문 종료

			
		} catch (ClassNotFoundException e) {
			System.out.println("지정된 경로에 클래스가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// JDBC 관련 객체 이용 중 발생되는 예외의 최상위 부모
			e.printStackTrace();
		} finally { // try에서 예외가 발생 하든 하지 않든 수행
			// 4 단계 : 사용한 JDBC 객체 자원 반환 (close())
			// -> close 구문은 객체 생성 역순으로 작성
			// 생성 순서 : conn, stmt, rs
			// close 순서 : rs, stmt, conn
	
			
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
	}

}
