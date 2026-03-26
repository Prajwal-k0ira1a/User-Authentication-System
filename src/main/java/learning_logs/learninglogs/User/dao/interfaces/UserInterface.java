package learning_logs.learninglogs.User.dao.interfaces;

import learning_logs.learninglogs.User.model.User;

import java.sql.SQLException;

public interface UserInterface {
 boolean registerUser(User user) throws SQLException, ClassNotFoundException;
 User loginUser(String email,String password) throws SQLException, ClassNotFoundException;

}
