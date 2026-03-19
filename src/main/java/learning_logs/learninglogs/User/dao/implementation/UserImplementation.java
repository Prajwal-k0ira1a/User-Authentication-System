package learning_logs.learninglogs.User.dao.implementation;

import learning_logs.learninglogs.User.dao.interfaces.UserInterface;
import learning_logs.learninglogs.User.model.User;
import util.DBConnection;
import util.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImplementation implements UserInterface {
    @Override
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
       try( Connection conn =DBConnection.getConnection();
        PreparedStatement ps = com.prepareStatement(UserQuery.insertUser));
        ps.SetString(1,user.getUserName());
        ps.SetString(2,user.getEmail());
        ps.SetString(3,user.getPassword());
        int rowsAffected = ps.executeUpdate();

        return rowsAffected>0;
    }

    @Override
    public User loginUser(String email, String password) {
        return null;
    }
}
