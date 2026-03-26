package learning_logs.learninglogs.User.dao.implementation;

import learning_logs.learninglogs.User.dao.interfaces.UserInterface;
import learning_logs.learninglogs.User.model.User;
import util.DBConnection;
import util.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImplementation implements UserInterface {
    @Override
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UserQuery.insertUser)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public User loginUser(String email, String password) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UserQuery.loginUser)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("email"),
                            rs.getInt("id"),
                            rs.getString("user_name"),
                            rs.getString("password")
                    );
                }
            }
        }

        return null;
    }
}
