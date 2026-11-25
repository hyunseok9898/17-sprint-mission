package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class User {
    // 공통 필드
    private final UUID id;
    private final Long createdAt;
    private Long updatedAt;

    // 고유 필드
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
        this.username = username;
        this.email = email;
        this. password = password;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", id=" + id +
                '}';
    }
}


