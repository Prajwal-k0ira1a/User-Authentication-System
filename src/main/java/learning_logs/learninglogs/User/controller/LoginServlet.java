package learning_logs.learninglogs.User.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learning_logs.learninglogs.User.dao.implementation.UserImplementation;
import learning_logs.learninglogs.User.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserImplementation userImplementation = new UserImplementation();

        try {
            User user = userImplementation.loginUser(email, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("loggedInUser", user);
                req.setAttribute("username", user.getUserName());
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
                return;
            }

            req.setAttribute("error", "Invalid email or password.");
            req.setAttribute("email", email);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Unable to process login request.", e);
        }
    }
}
