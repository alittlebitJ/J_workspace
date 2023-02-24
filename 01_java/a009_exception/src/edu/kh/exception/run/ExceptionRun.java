package edu.kh.exception.run;

import java.io.IOException;

import edu.kh.exception.service.ExceptionService;
import edu.kh.exception.user.exception.ScoreInputException;

public class ExceptionRun {
	
	public static void main(String[] args) throws IOException, ScoreInputException { // throws는 호출한 곳으로 던진다는 것이기 때문에, 호출한 곳에서도 예외처리
		
		
		ExceptionService service = new ExceptionService();
		service.startEx5();		
		
	}

}
