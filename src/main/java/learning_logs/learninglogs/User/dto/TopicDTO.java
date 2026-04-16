package learning_logs.learninglogs.User.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TopicDTO {
    private int id;
    private String title;
    private String userName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructors
    public TopicDTO() {}

    public TopicDTO(int id, String title, String userName, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "TopicDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + userName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
