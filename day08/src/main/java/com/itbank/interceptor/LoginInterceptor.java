package com.itbank.interceptor;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler);
		// 클라이언트의 요청이 컨트롤러의 메서드에 도달하기 전에 작동한다
		// 반환값에 따라서 컨트롤러의 메서드를 예정대로 진행할지 말지 결정할 수 있다
		
		HttpSession session = request.getSession(false);	// 현재 사용중인 세션이 없으면 새로 생성하지 마라
		
		if(session != null && session.getAttribute("login") != null) {
			System.out.println("preHandle : true");
			return true;
		}
		String requestURI = request.getRequestURI();	// 어느 주소를 요청했는가 ?
		System.out.println("requestURI : " + requestURI);
		requestURI = requestURI.substring(request.getContextPath().length());
		// substring은 문자열에서 특정 인덱스를 이용해 문자열을 잘라내는 문자열 뺄셈의 기능이다
		// 0123456789
		// [/day08/gallery]
		
		System.out.println("preHandle : false");
		System.out.println("contextPath : " + request.getContextPath());
		System.out.println("requestURI : " + requestURI);
		
		response.sendRedirect(request.getContextPath() + "/login?uri=" + requestURI);
		// 이렇게 msg로 보내고 servlet-context에 매핑주소만 추가해주면 됨 !
		
		return false;
		// return true;		: preHandle에서 처리 이후 컨트롤러에게 요청을 그대로 넘겨준다 (계속 진행)
		// return false;	: preHandle에서 처리 중 다른 방식으로 처리할거라서 컨트롤러에게 넘기지 않는다 (중단)
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		System.out.println("postHandle");
		// 컨트롤러의 메서드가 수행되고 나서, view로 넘어가기 전에 작동하는 메서드
		Random ran = new Random();
		int num = ran.nextInt(9) + 1;
		String imgServer = "http://221.164.9.222/img/";
		mav.addObject("imgName", imgServer + num + ".jpg");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		// view가 화면에 출력된 이후에 작동하는 메서드
		System.out.println("Exception : " + ex);
		if(ex != null) {
			response.setCharacterEncoding("utf-8");
			response.getWriter().print("문제가 발생했습니다");
		}
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 비동기식 요청을 받았을 경우에 작동하는 메서드 (ex - AJAX, WebSocket, ...)
	}

	// 인터셉터는 서버에 들어오는 요청을 가로채는 객체이다
	// 요청을 중간에 가로채서 먼저 처리할 내용을 처리하고, 이후 컨트롤러의 메서드로 연결할지 말지 결정할 수 있다 (preHandle)
	
	// 인터셉터는 클래스 상속으로 만들 수 있다
	// extends는 implements와 달리 오버라이딩을 강제하지 않기 때문에 메서드가 자동으로 만들어지지는 않는다
	// 이클립스의 Override/Implements Methods 메뉴를 이용하면 편리하게 작성 가능
}
