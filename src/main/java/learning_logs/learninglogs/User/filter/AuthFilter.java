package learning_logs.learninglogs.User.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    final String LOGIN_URL="/login";
    final String REGISTER_URL="/register";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req=(HttpServletRequest) request;
         HttpServletResponse res =(HttpServletResponse) response;

         HttpSession session =req.getSession(false);

         int userId = (int) session.getAttribute("loggedInUser");
         String uri=req.getRequestURI();

         if(uri.endsWith(LOGIN_URL)|| uri.endsWith(REGISTER_URL)){
             chain.doFilter(request,response);
         return;
         }

         if(userId<=0){
             res.sendRedirect("/login");
         }
         else{
             chain.doFilter(request, response);

         }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
