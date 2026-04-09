package learning_logs.learninglogs.User.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learning_logs.learninglogs.User.dao.implementation.TopicDAOImpl;
import learning_logs.learninglogs.User.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/topics")
public class TopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {
            TopicDAOImpl topicDAO = new TopicDAOImpl();
            req.setAttribute("topics", topicDAO.getTopicsByUser(loggedInUser.getId()));
            req.getRequestDispatcher("/topic.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Unable to fetch topics for the logged-in user.", e);
        }
    }
}
