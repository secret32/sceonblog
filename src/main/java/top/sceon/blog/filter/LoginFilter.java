package top.sceon.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhou_wei
 * @date 8/29/2016
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String loginPage = filterConfig.getInitParameter("loginPage");
        String[] excludes = filterConfig.getInitParameter("excludes").split(",");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = req.getServletPath();
        boolean isExclude = false;
        for (String exclude : excludes) {
            if (uri.startsWith(exclude)) {
                isExclude = true;
                break;
            }
        }
        if (session.getAttribute("userId") != null || isExclude || uri.startsWith(loginPage)) {
            filterChain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + loginPage);
        }
    }

    @Override
    public void destroy() {
    }
}
