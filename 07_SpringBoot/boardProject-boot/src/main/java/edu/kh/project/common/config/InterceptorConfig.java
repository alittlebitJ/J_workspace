package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		return new BoardTypeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Bean으로 등록된 BoardTypeInterceptor를 얻어와 인터셉터로 등록
		registry.addInterceptor(boardTypeInterceptor())
		.addPathPatterns("/**")   // 가로첼 경로 지정(여러개 작성  시 ,로 구분) 별 두개는 이하 모든 경로
		.excludePathPatterns("/css/**", "/image/**", "/js/**"); // 가로채지 않을 경로
		
		
//		다른 인터셉터를 만들었을 시 register부터 경로설정까지를 이 안에 만들면 됨 (다른 인터셉터도 위에 Bean등록 해줘야 함)
		
	}
	
}
