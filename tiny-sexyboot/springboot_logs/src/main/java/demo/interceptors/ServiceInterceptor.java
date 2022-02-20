package demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ServiceInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        // fill request related info before processing
        if (request.getHeader("userId") != null) {
            MDC.put("user_id", request.getHeader("userId"));
        }
        MDC.put("session_id", request.getHeader("sessionId"));
        MDC.put("request_id", request.getHeader("requestId"));
        return super.preHandle(request, response, handler);
    }
}
