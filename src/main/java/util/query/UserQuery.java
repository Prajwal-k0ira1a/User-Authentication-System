package util.query;

public class UserQuery {
 public final static String insertUser="INSERT INTO users (user_name, email, password) VALUES (?, ?,?);" ;
 public final static String loginUser="SELECT id, user_name, email, password FROM users WHERE email = ?;";
public static final String GET_ALL_TOPICS="SELECT * FROM topics WHERE user_id = ?";
}

