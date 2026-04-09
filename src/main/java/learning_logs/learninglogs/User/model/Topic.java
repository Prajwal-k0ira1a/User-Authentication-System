package learning_logs.learninglogs.User.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int user_id;

    public Topic(){}

    public String getTitle() {
        return title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Topic(int id, String title, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user_id = user_id;
    }
    public Topic( String title, Timestamp createdAt, Timestamp updatedAt) {
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return title + " was " + createdAt + " and updated at " + updatedAt;
    }
}
