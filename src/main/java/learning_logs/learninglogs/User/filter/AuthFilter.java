package learning_logs.learninglogs.User.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learning_logs.learninglogs.User.model.User;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    private static final String LOGIN_URL = "/login";
    private static final String REGISTER_URL = "/register";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        boolean publicRoute = uri.equals(contextPath + LOGIN_URL)
                || uri.equals(contextPath + REGISTER_URL)
                || uri.equals(contextPath + "/")
                || uri.endsWith("/index.jsp");

        if (publicRoute) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        User loggedInUser = session == null ? null : (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            res.sendRedirect(contextPath + LOGIN_URL);
            return;
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
