package zuel.huziliu.filter;

import zuel.huziliu.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessServlet implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        if(attribute==null){
            resp.sendRedirect("/error.jsp");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
