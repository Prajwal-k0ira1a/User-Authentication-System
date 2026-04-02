package learning_logs.learninglogs.User.dao.implementation;

import learning_logs.learninglogs.User.dao.interfaces.TopicInterface;
import learning_logs.learninglogs.User.model.Topic;
import util.DBConnection;
import util.query.UserQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDAOImpl implements TopicInterface {
private final Connection conn;

    public TopicDAOImpl() throws SQLException,ClassNotFoundException{
        this.conn = DBConnection.getConnection();
    }

    @Override
    public List<Topic> getTopicsByUser(int user_id) throws SQLException {
        List<Topic> topics = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(UserQuery.GET_ALL_TOPICS)) {
            ps.setInt(1, user_id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Topic topic = new Topic();
                    topic.setId(rs.getInt("id"));
                    topic.setTitle(rs.getString("title"));
                    topic.setCreatedAt(rs.getTimestamp("created_at"));
                    topic.setUpdatedAt(rs.getTimestamp("updated_at"));
                    topic.setUser_id(rs.getInt("user_id"));
                    topics.add(topic);
                }
            }
        }

        return topics;
    }}


