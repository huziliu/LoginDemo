package zuel.huziliu.filter;

import javax.servlet.*;
import java.io.IOException;

public class characterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("filter启动");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
