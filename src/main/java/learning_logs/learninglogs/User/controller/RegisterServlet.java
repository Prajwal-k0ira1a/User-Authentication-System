package learning_logs.learninglogs.User.controller;
import learning_logs.learninglogs.User.dao.implementation.UserImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learning_logs.learninglogs.User.model.User;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

//        req.setAttribute("username",username);
//        req.setAttribute("email",email);
//        req.setAttribute("password",password);
//        req.getRequestDispatcher("home.jsp").forward(req,resp);

        User user=new User(username,email,password);
        UserImplementation Impl=new UserImplementation();

        try{
            boolean success=Impl.registerUser(user);
        if(success){
            req.setAttribute("success","Register Succcessfull");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }

            req.setAttribute("error", "Unable to register user.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        catch(SQLException e){
            throw  new ServletException(e);
        }catch(ClassNotFoundException e){
            throw  new ServletException(e);
        }
    }
}
