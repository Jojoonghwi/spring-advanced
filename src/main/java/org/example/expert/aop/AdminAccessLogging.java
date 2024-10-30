package org.example.expert.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "AdminAccessLogging")
@Aspect
@Component
@RequiredArgsConstructor
public class AdminAccessLogging {

	private final

	// 	- 요청한 사용자의 ID
	// - API 요청 시각
	// - API 요청 URL
	// - response, request body도 찍기

	// @Pointcut("execution(* org.example.expert.domain.auth.controller.AuthController.signin(..))")
	// void signin() {}
	@Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..))")
	void delete() {}
	@Pointcut("execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
	void changeUserRole() {}

	@Around("delete() || changeUserRole() /*|| signin()*/")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

		LocalDateTime apiRequestTime = LocalDateTime.now();
		System.out.println("API 요청 시각 : " + apiRequestTime);

		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String)httpServletRequest.getAttribute("userId");

		try {
			Object output = joinPoint.proceed();
			return output;
		} finally {

		}
	}
}
