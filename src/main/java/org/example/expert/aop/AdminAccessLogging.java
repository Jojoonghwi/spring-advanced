package org.example.expert.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "AdminAccessLogging")
@Aspect
@Component
@RequiredArgsConstructor
public class AdminAccessLogging {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final HttpServletRequest httpServletRequest;

	// @Pointcut("execution(* org.example.expert.domain.auth.controller.AuthController.signin(..))")
	// void signin() {}
	@Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..))")
	void delete() {}
	@Pointcut("execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
	void changeUserRole() {}

	@Around("delete() || changeUserRole() /*|| signin()*/")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// - API 요청 시각
		LocalDateTime apiRequestTime = LocalDateTime.now();

		// - 요청한 사용자의 ID
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String) httpServletRequest.getAttribute("userId");

		// - API 요청 URL
		String requestURI = httpServletRequest.getRequestURI();

		// - request body
		String requestBody = objectMapper.writeValueAsString(joinPoint.getArgs());

		Object output = null;
		String responseBody = null;

		try {
			output = joinPoint.proceed();
			// - response body
			responseBody = objectMapper.writeValueAsString(output);
			return output;
		} finally {

			log.info("요청한 사용자의 ID : {}", userId);
			log.info("API 요청 시각 : {}", apiRequestTime);
			log.info("API 요청 URL : {}", requestURI);
			log.info("API request : {}", requestBody);
			log.info("API response : {}", responseBody);
		}
	}
}
