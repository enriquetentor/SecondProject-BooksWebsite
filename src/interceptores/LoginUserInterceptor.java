package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//para crear un interceptor en Spring, nos vale una clse que herede de HandlerInterceptorAdapter y 
//programemos lo que queramos que haga el interceptor en el metodo preHandle
public class LoginUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("idUser") == null) {
			// usuario no identificado
			response.sendRedirect("../error.jsp");
			return false;
		} else {
			return true;
		}
	}

}
